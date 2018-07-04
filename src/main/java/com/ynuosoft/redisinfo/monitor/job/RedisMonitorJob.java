package com.ynuosoft.redisinfo.monitor.job;

import com.ynuosoft.redisinfo.monitor.config.RedisConfProperties;
import com.ynuosoft.redisinfo.monitor.entity.input.ClusterConf;
import com.ynuosoft.redisinfo.monitor.entity.output.NodeInfo;
import com.ynuosoft.redisinfo.monitor.help.RedisClusterManage;
import com.ynuosoft.redisinfo.monitor.help.RedisInfoCalculate;
import com.ynuosoft.redisinfo.monitor.help.RedisInfoParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

import java.util.*;

/**
 * Created by meng li on 2017/1/17.
 */
@Component
public class RedisMonitorJob {
    private static final Logger logRedisInfo = LoggerFactory.getLogger("logger_redis_info");
    private static final Logger logger = LoggerFactory.getLogger(RedisMonitorJob.class);

    @Autowired
    private RedisConfProperties redisConfProperties;

    @Scheduled(cron = "${redisMonitorJob.scheduledCron:5 0/1 * * * *}")
    public void GatherRedisInfo() {
        for (ClusterConf clusterConf : redisConfProperties.getClusterConfs()) {
            JedisCluster jedisCluster = RedisClusterManage.getJedisCluster(clusterConf);
            if (jedisCluster == null) {
                continue;
            }
            Map<String, JedisPool> jedisPoolMap = jedisCluster.getClusterNodes();
            String cluster_known_nodes_up = String.valueOf(jedisPoolMap.size());
            for (Map.Entry<String, JedisPool> jedisPoolEntry : jedisPoolMap.entrySet()) {
                try {
                    Jedis jedis = jedisPoolEntry.getValue().getResource();
                    String strProperties0 = jedis.info("all");
                    if (strProperties0 == null) {
                        strProperties0 = "";
                    }
                    String strProperties1 = jedis.clusterInfo();
                    if (strProperties1 == null) {
                        strProperties1 = "";
                    }
                    if (!(strProperties0.isEmpty() && strProperties1.isEmpty())) {
                        strProperties0 = strProperties0 + "\n" + strProperties1;
                        if (!(strProperties0.isEmpty())) {
                            Properties properties = RedisInfoParser.ParserToProperties(strProperties0.getBytes());
                            if (properties != null) {
                                properties.setProperty("cluster_name", clusterConf.getName());
                                properties.setProperty("server_host", jedisPoolEntry.getKey());
                                properties.setProperty("cluster_known_nodes_up", cluster_known_nodes_up);
                                //
                                NodeInfo nodeInfo = RedisInfoParser.ParserToNodeInfo(properties, new Date());
                                //修改值 计算差值
                                RedisInfoCalculate.CalculateNodeInfo(nodeInfo);
                                //json写入log
                                logRedisInfo.info(RedisInfoParser.ParserNodeInfoToJsonStr(nodeInfo));
                            }
                        }
                    }
                    jedis.close();
                    Thread.sleep(5);
                } catch (JedisException ex) {
                    logger.error("jedis error 1 " + clusterConf.getName()+",ip +"+jedisPoolEntry.getKey(), ex);
                    jedisCluster.getClusterNodes().remove(jedisPoolEntry.getKey());
                } catch (Exception ex) {
                    logger.error("jedis error 2 " + clusterConf.getName()+",ip +"+jedisPoolEntry.getKey(), ex);
                    jedisCluster.getClusterNodes().remove(jedisPoolEntry.getKey());
                }
                finally {
//                    //删除
//                    jedisCluster.getClusterNodes().remove(jedisPoolEntry.getKey());
                }
            }
            logger.info("running... ," + clusterConf.getName());
        }
    }
}
