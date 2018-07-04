package com.ynuosoft.redisinfo.monitor.help;

import com.ynuosoft.redisinfo.monitor.entity.input.CacheObj;
import com.ynuosoft.redisinfo.monitor.entity.input.ClusterConf;
import com.ynuosoft.redisinfo.monitor.entity.input.NodeConf;

import com.ynuosoft.redisinfo.monitor.job.RedisMonitorJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.*;


/**
 * Created by meng li on 2017/2/22.
 * 目的定时创建jediscluster，达到自动刷新的目的
 */
public  class RedisClusterManage {
    /*
     */
    private static Logger logger = LoggerFactory.getLogger(RedisMonitorJob.class);
    /*
     */
    private static HashMap<String, CacheObj> cacheHashMap;
    /**
     *
     */
    private RedisClusterManage() {
    }
    static {
        cacheHashMap = new HashMap<>();
    }
    /**
     * @param clusterConf
     * @return
     */
    public static JedisCluster getJedisCluster(ClusterConf clusterConf) {

        CacheObj cacheObj = cacheHashMap.get(clusterConf.getName());
        if (cacheObj == null) {
            cacheObj = initCacheObj(clusterConf);
        } else {
            if (cacheObj.getCacheTime() < new Date().getTime()) {
                try {
                    cacheObj.getJedisCluster().close();
                } catch (IOException ex) {
                   logger.error("cacheobj error",ex);
                }
                cacheObj=initCacheObj(clusterConf);
            }
        }
        return cacheObj == null ? null : cacheObj.getJedisCluster();
    }
    /**
     * @param clusterConf
     * @return
     */
   synchronized static CacheObj initCacheObj(ClusterConf clusterConf) {
        CacheObj cacheObj = null;
        if (clusterConf.getNodes() != null && clusterConf.getNodes().size() > 0) {

            Set<HostAndPort> hostAndPortSet = new HashSet<>();
            for (NodeConf nodeConf : clusterConf.getNodes()) {
                hostAndPortSet.add(new HostAndPort(nodeConf.getHost(), nodeConf.getPort()));
            }
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setBlockWhenExhausted(false);
            jedisPoolConfig.setMaxWaitMillis(10);
            JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, jedisPoolConfig);
            //缓存时间
            Date date01 = new Date();//取时间
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date01);
            calendar.add(calendar.MINUTE, clusterConf.getCacheMin());//把日期往后增加一天.整数往后推,负数往前移动
            date01 = calendar.getTime();   //这个时间就是日期往后推一天的结果
            //
            cacheObj = new CacheObj(date01.getTime(),jedisCluster);
            //
            cacheHashMap.remove(clusterConf.getName());
            cacheHashMap.put(clusterConf.getName(), cacheObj);
            //
            logger.info("cacheobj create :" + clusterConf.getName());
        }
        return cacheObj;
    }

}

