package com.ynuosoft.redisinfo.monitor.help;

import com.ynuosoft.redisinfo.monitor.entity.output.CommandStatsCallInfo;
import com.ynuosoft.redisinfo.monitor.entity.output.NodeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;


/**
 * Created by meng li on 2017/2/10.
 * 最新的数据与上一次数据计算
 * 非线程安全
 * 本代码仅限单线程使用，若要多线程需要更换容器
 */
public final class  RedisInfoCalculate {

    private static final Logger logger = LoggerFactory.getLogger(RedisInfoParser.class);

    private RedisInfoCalculate() {

    }
    //初始化
    static {
        hashMap = new HashMap<>();
    }

    /*
    非线程安全集合容器
     */
    private static HashMap<String, NodeInfo> hashMap;

    /**
     * 计算差值
     *
     * @param newNodeInfo
     */
    public static void CalculateNodeInfo(NodeInfo newNodeInfo) {

        String strServerHost = newNodeInfo.getServer().getServer_host();
        try {
            if (hashMap.containsKey(strServerHost)) {
                NodeInfo oldNodeInfo = hashMap.get(strServerHost);
                //
                CalculateMemory(oldNodeInfo, newNodeInfo);
                //
                CalculateStats(oldNodeInfo, newNodeInfo);
                //
                CalculateCommandStats(oldNodeInfo, newNodeInfo);
                //
                CalculateKeyspace(oldNodeInfo, newNodeInfo);
                //更新
                synchronized (strServerHost) {
                    hashMap.remove(strServerHost);
                    hashMap.put(strServerHost, newNodeInfo);
                }
            } else {
                hashMap.put(strServerHost, newNodeInfo);
            }
        } catch (Exception ex) {
            hashMap.remove(strServerHost);
            logger.error("calculate error", ex);
        }
    }
    /**
     *
     * @param oldNodeinfo
     * @param newNodenfo
     */
     static void CalculateMemory(NodeInfo oldNodeinfo, NodeInfo newNodenfo)
     {
         newNodenfo.getMemory().setUsed_memory_trend(newNodenfo.getMemory().getUsed_memory()
                 -oldNodeinfo.getMemory().getUsed_memory());
         newNodenfo.getMemory().setUsed_memory_rss_trend(newNodenfo.getMemory().getUsed_memory_rss()
                 -oldNodeinfo.getMemory().getUsed_memory_rss());
         newNodenfo.getMemory().setMem_fragmentation_ratio_trend(newNodenfo.getMemory().getMem_fragmentation_ratio()
                 -oldNodeinfo.getMemory().getMem_fragmentation_ratio());
     }

    /**
     *
     * @param oldNodeinfo
     * @param newNodenfo
     */
     static void CalculateStats(NodeInfo oldNodeinfo, NodeInfo newNodenfo)
     {
         newNodenfo.getStats().setTotal_connections_received_trend(newNodenfo.getStats().getTotal_connections_received()
                 -oldNodeinfo.getStats().getTotal_connections_received());
         newNodenfo.getStats().setTotal_commands_processed_trend(newNodenfo.getStats().getTotal_commands_processed()
                 -oldNodeinfo.getStats().getTotal_commands_processed());
         newNodenfo.getStats().setExpired_keys_trend(newNodenfo.getStats().getExpired_keys()
                 -oldNodeinfo.getStats().getExpired_keys());
         newNodenfo.getStats().setKeyspace_hits_trend(newNodenfo.getStats().getKeyspace_hits()
                 -oldNodeinfo.getStats().getKeyspace_hits());
         newNodenfo.getStats().setKeyspace_misses_trend(newNodenfo.getStats().getKeyspace_misses()
                 -oldNodeinfo.getStats().getKeyspace_misses());
         newNodenfo.getStats().setRejected_connections_trend(newNodenfo.getStats().getRejected_connections()
                 -oldNodeinfo.getStats().getRejected_connections());
         newNodenfo.getStats().setTotal_net_input_bytes_trend(newNodenfo.getStats().getTotal_net_input_bytes()
                 -oldNodeinfo.getStats().getTotal_net_input_bytes());
         newNodenfo.getStats().setTotal_net_output_bytes_trend(newNodenfo.getStats().getTotal_net_output_bytes()
                 -oldNodeinfo.getStats().getTotal_net_output_bytes());
     }
    /**
     * @param oldNodeinfo
     * @param newNodenfo
     */
    static void CalculateCommandStats(NodeInfo oldNodeinfo, NodeInfo newNodenfo) {

//    cmdstat_get:calls=101187,usec=815066,usec_per_call=8.06
        newNodenfo.getCommandstats().setCmdstat_get(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_get(), newNodenfo.getCommandstats().getCmdstat_get()));
//    cmdstat_set:calls=7783,usec=310505,usec_per_call=39.90
        newNodenfo.getCommandstats().setCmdstat_set(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_set(), newNodenfo.getCommandstats().getCmdstat_set()));
//    cmdstat_setex:calls=8452,usec=167247,usec_per_call=19.79
        newNodenfo.getCommandstats().setCmdstat_setex(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_setex(), newNodenfo.getCommandstats().getCmdstat_setex()));
//    cmdstat_del:calls=28110,usec=186114,usec_per_call=6.62
        newNodenfo.getCommandstats().setCmdstat_del(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_del(), newNodenfo.getCommandstats().getCmdstat_del()));
//    cmdstat_exists:calls=9270,usec=42521,usec_per_call=4.59
        newNodenfo.getCommandstats().setCmdstat_exists(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_exists(), newNodenfo.getCommandstats().getCmdstat_exists()));
//    cmdstat_rpush:calls=100000,usec=63860,usec_per_call=0.64
        newNodenfo.getCommandstats().setCmdstat_rpush(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_rpush(), newNodenfo.getCommandstats().getCmdstat_rpush()));
//    cmdstat_lpush:calls=358070,usec=1589102,usec_per_call=4.44
        newNodenfo.getCommandstats().setCmdstat_lpush(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_lpush(), newNodenfo.getCommandstats().getCmdstat_lpush()));
//    cmdstat_rpop:calls=100490,usec=75474,usec_per_call=0.75
        newNodenfo.getCommandstats().setCmdstat_rpop(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_rpop(), newNodenfo.getCommandstats().getCmdstat_rpop()));
//    cmdstat_lpop:calls=100002,usec=125880,usec_per_call=1.26
        newNodenfo.getCommandstats().setCmdstat_lpop(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_lpop(), newNodenfo.getCommandstats().getCmdstat_lpop()));
//    cmdstat_llen:calls=102983,usec=184490,usec_per_call=1.79
        newNodenfo.getCommandstats().setCmdstat_llen(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_llen(), newNodenfo.getCommandstats().getCmdstat_llen()));
//    cmdstat_lindex:calls=991,usec=13685,usec_per_call=13.81
        newNodenfo.getCommandstats().setCmdstat_lindex(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_lindex(), newNodenfo.getCommandstats().getCmdstat_lindex()));
//    cmdstat_lset:calls=11,usec=273,usec_per_call=24.82
        newNodenfo.getCommandstats().setCmdstat_lset(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_lset(), newNodenfo.getCommandstats().getCmdstat_lset()));
//    cmdstat_lrange:calls=512576,usec=14088447,usec_per_call=27.49
        newNodenfo.getCommandstats().setCmdstat_lrange(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_lrange(), newNodenfo.getCommandstats().getCmdstat_lrange()));
//    cmdstat_ltrim:calls=2,usec=36,usec_per_call=18.00
        newNodenfo.getCommandstats().setCmdstat_ltrim(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_ltrim(), newNodenfo.getCommandstats().getCmdstat_ltrim()));
//    cmdstat_lrem:calls=106573,usec=1271382,usec_per_call=11.93
        newNodenfo.getCommandstats().setCmdstat_lrem(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_lrem(), newNodenfo.getCommandstats().getCmdstat_lrem()));
//    cmdstat_sadd:calls=100000,usec=53779,usec_per_call=0.54
        newNodenfo.getCommandstats().setCmdstat_sadd(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_sadd(), newNodenfo.getCommandstats().getCmdstat_sadd()));
//    cmdstat_spop:calls=100000,usec=25161,usec_per_call=0.25
        newNodenfo.getCommandstats().setCmdstat_spop(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_spop(), newNodenfo.getCommandstats().getCmdstat_spop()));
//    cmdstat_hset:calls=898,usec=21597,usec_per_call=24.05
        newNodenfo.getCommandstats().setCmdstat_hset(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hset(), newNodenfo.getCommandstats().getCmdstat_hset()));
//    cmdstat_hget:calls=1630,usec=17109,usec_per_call=10.50
        newNodenfo.getCommandstats().setCmdstat_hget(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hget(), newNodenfo.getCommandstats().getCmdstat_hget()));
//    cmdstat_hmset:calls=229,usec=5174,usec_per_call=22.59
        newNodenfo.getCommandstats().setCmdstat_hmset(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hmset(), newNodenfo.getCommandstats().getCmdstat_hmset()));
//    cmdstat_hdel:calls=26,usec=598,usec_per_call=23.00
        newNodenfo.getCommandstats().setCmdstat_hdel(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hdel(), newNodenfo.getCommandstats().getCmdstat_hdel()));
//    cmdstat_hlen:calls=216,usec=1401,usec_per_call=6.49
        newNodenfo.getCommandstats().setCmdstat_hlen(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hlen(), newNodenfo.getCommandstats().getCmdstat_hlen()));
//    cmdstat_hkeys:calls=2,usec=9,usec_per_call=4.50
        newNodenfo.getCommandstats().setCmdstat_hkeys(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hkeys(), newNodenfo.getCommandstats().getCmdstat_hkeys()));
//    cmdstat_hvals:calls=1,usec=7,usec_per_call=7.00
        newNodenfo.getCommandstats().setCmdstat_hvals(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hvals(), newNodenfo.getCommandstats().getCmdstat_hvals()));
//    cmdstat_hgetall:calls=36007,usec=204499,usec_per_call=5.68
        newNodenfo.getCommandstats().setCmdstat_hgetall(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hgetall(), newNodenfo.getCommandstats().getCmdstat_hgetall()));
//    cmdstat_hscan:calls=184,usec=4347,usec_per_call=23.62
        newNodenfo.getCommandstats().setCmdstat_hscan(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_hscan(), newNodenfo.getCommandstats().getCmdstat_hscan()));
//    cmdstat_getset:calls=7,usec=69,usec_per_call=9.86
        newNodenfo.getCommandstats().setCmdstat_getset(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_getset(), newNodenfo.getCommandstats().getCmdstat_getset()));
//    cmdstat_select:calls=416,usec=1580,usec_per_call=3.80
        newNodenfo.getCommandstats().setCmdstat_select(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_select(), newNodenfo.getCommandstats().getCmdstat_select()));
//    cmdstat_renamenx:calls=1,usec=5,usec_per_call=5.00
        newNodenfo.getCommandstats().setCmdstat_renamenx(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_renamenx(), newNodenfo.getCommandstats().getCmdstat_renamenx()));
//    cmdstat_expire:calls=2,usec=9,usec_per_call=4.50
        newNodenfo.getCommandstats().setCmdstat_expire(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_expire(), newNodenfo.getCommandstats().getCmdstat_expire()));
//    cmdstat_expireat:calls=6,usec=44,usec_per_call=7.33
        newNodenfo.getCommandstats().setCmdstat_expireat(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_expireat(), newNodenfo.getCommandstats().getCmdstat_expireat()));
//    cmdstat_keys:calls=345,usec=92996,usec_per_call=269.55
        newNodenfo.getCommandstats().setCmdstat_keys(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_keys(), newNodenfo.getCommandstats().getCmdstat_keys()));
//    cmdstat_scan:calls=161,usec=76001,usec_per_call=472.06
        newNodenfo.getCommandstats().setCmdstat_scan(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_scan(), newNodenfo.getCommandstats().getCmdstat_scan()));
//    cmdstat_dbsize:calls=1,usec=3,usec_per_call=3.00
        newNodenfo.getCommandstats().setCmdstat_dbsize(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_dbsize(), newNodenfo.getCommandstats().getCmdstat_dbsize()));
//    cmdstat_ping:calls=255875,usec=174574,usec_per_call=0.68
        newNodenfo.getCommandstats().setCmdstat_ping(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_ping(), newNodenfo.getCommandstats().getCmdstat_ping()));
//    cmdstat_type:calls=16969,usec=73496,usec_per_call=4.33
        newNodenfo.getCommandstats().setCmdstat_type(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_type(), newNodenfo.getCommandstats().getCmdstat_type()));
//    cmdstat_sync:calls=3,usec=1618,usec_per_call=539.33
        newNodenfo.getCommandstats().setCmdstat_sync(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_sync(), newNodenfo.getCommandstats().getCmdstat_sync()));
//    cmdstat_psync:calls=1,usec=693,usec_per_call=693.00
        newNodenfo.getCommandstats().setCmdstat_psync(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_psync(), newNodenfo.getCommandstats().getCmdstat_psync()));
//    cmdstat_replconf:calls=8520709,usec=33608874,usec_per_call=3.94
        newNodenfo.getCommandstats().setCmdstat_replconf(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_replconf(), newNodenfo.getCommandstats().getCmdstat_replconf()));
//    cmdstat_info:calls=5387,usec=566093,usec_per_call=105.09
        newNodenfo.getCommandstats().setCmdstat_info(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_info(), newNodenfo.getCommandstats().getCmdstat_info()));
//    cmdstat_ttl:calls=8800,usec=38821,usec_per_call=4.41
        newNodenfo.getCommandstats().setCmdstat_ttl(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_ttl(), newNodenfo.getCommandstats().getCmdstat_ttl()));
//    cmdstat_role:calls=4,usec=55,usec_per_call=13.75
        newNodenfo.getCommandstats().setCmdstat_role(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_role(), newNodenfo.getCommandstats().getCmdstat_role()));
//    cmdstat_config:calls=29,usec=1962,usec_per_call=67.66
        newNodenfo.getCommandstats().setCmdstat_config(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_config(), newNodenfo.getCommandstats().getCmdstat_config()));
//    cmdstat_subscribe:calls=2,usec=26,usec_per_call=13.00
        newNodenfo.getCommandstats().setCmdstat_subscribe(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_subscribe(), newNodenfo.getCommandstats().getCmdstat_subscribe()));
//    cmdstat_publish:calls=3,usec=56,usec_per_call=18.67
        newNodenfo.getCommandstats().setCmdstat_publish(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_publish(), newNodenfo.getCommandstats().getCmdstat_publish()));
//    cmdstat_pubsub:calls=6,usec=112,usec_per_call=18.67
        newNodenfo.getCommandstats().setCmdstat_pubsub(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_pubsub(), newNodenfo.getCommandstats().getCmdstat_pubsub()));
//    cmdstat_cluster:calls=9108,usec=1534795,usec_per_call=168.51
        newNodenfo.getCommandstats().setCmdstat_cluster(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_cluster(), newNodenfo.getCommandstats().getCmdstat_cluster()));
//    cmdstat_dump:calls=1,usec=24,usec_per_call=24.00
        newNodenfo.getCommandstats().setCmdstat_dump(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_dump(), newNodenfo.getCommandstats().getCmdstat_dump()));
//    cmdstat_client:calls=9,usec=199,usec_per_call=22.11
        newNodenfo.getCommandstats().setCmdstat_client(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_client(), newNodenfo.getCommandstats().getCmdstat_client()));
//    cmdstat_command:calls=21,usec=28389,usec_per_call=1351.86
        newNodenfo.getCommandstats().setCmdstat_command(CalculuateCommandStatsCall(oldNodeinfo.getCommandstats().getCmdstat_command(), newNodenfo.getCommandstats().getCmdstat_command()));
    }

    /**
     * 计算commandstat差值
     *
     * @param oldCallInfo
     * @param newCallInfo
     */
    static CommandStatsCallInfo CalculuateCommandStatsCall(CommandStatsCallInfo oldCallInfo, CommandStatsCallInfo newCallInfo) {
        newCallInfo.setCalls_trend(newCallInfo.getCalls() - oldCallInfo.getCalls());
        newCallInfo.setUsec_trend(newCallInfo.getUsec() - oldCallInfo.getUsec());
        newCallInfo.setUser_per_call_trend(newCallInfo.getUsec_per_call() - oldCallInfo.getUsec_per_call());

        return newCallInfo;
    }

    /**
     *
     * @param oldNodeinfo
     * @param newNodenfo
     */
    static void CalculateKeyspace(NodeInfo oldNodeinfo, NodeInfo newNodenfo)
    {
        newNodenfo.getKeyspace().setServer_db_keys_trend(newNodenfo.getKeyspace().getServer_db_keys()-oldNodeinfo.getKeyspace().getServer_db_keys());
        newNodenfo.getKeyspace().setServer_db_expires_trend(newNodenfo.getKeyspace().getServer_db_expires()-oldNodeinfo.getKeyspace().getServer_db_expires());
    }

}
