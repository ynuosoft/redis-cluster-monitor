package com.ynuosoft.redisinfo.monitor.help;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynuosoft.redisinfo.monitor.entity.output.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by meng li on 2017/1/17.
 */
public class RedisInfoParser {
    private static final Logger log = LoggerFactory.getLogger(RedisInfoParser.class);
    private static SimpleDateFormat simpleDateFormatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");
    private RedisInfoParser(){
    }
    static {
    }
    /*
 转换为properties类
  */
    public static Properties ParserToProperties(byte[] bytes) {

        Properties prop = null;
        try {
            InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(bytes));
            prop = new Properties();
            prop.load(inputStream);
            inputStream.close();

        } catch (Exception ex) {
            log.error("parser properties error", ex);
        } finally {
            return prop;
        }
    }

    public static String ParserNodeInfoToJsonStr(NodeInfo nodeInfo) {
        String strJson = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            strJson = mapper.writeValueAsString(nodeInfo);
        } catch (JsonProcessingException ex) {

            log.error("parser nodeinfo json error", ex);
        } finally {
            return strJson;
        }
    }

    /*
       转换为nodeInfo
     */
    public static NodeInfo ParserToNodeInfo(Properties properties, Date recordTime) {

        NodeInfo nodeInfo = new NodeInfo();

        nodeInfo.setRecord_time(simpleDateFormatUTC.format(recordTime));

        nodeInfo.setServer(ParserToServerInfo(properties));
        nodeInfo.setClient(ParserToClientInfo(properties));

        nodeInfo.setMemory(ParserToMemoryInfo(properties));
        nodeInfo.setPersistence(ParserToPersistenceInfo(properties));

        nodeInfo.setStats(ParserToStatsInfo(properties));
        nodeInfo.setReplication(ParserToReplicationInfo(properties));

        nodeInfo.setCpu(ParserToCpuInfo(properties));
        nodeInfo.setKeyspace(ParserToKeyspaceInfo(properties));

        nodeInfo.setCluster(ParserToClusterInfo(properties));

        nodeInfo.setCommandstats(ParserToCommandStatsInfo(properties));


        return nodeInfo;
    }


    /*

     */
    private static ServerInfo ParserToServerInfo(Properties properties) {
        ServerInfo serverInfo = new ServerInfo();
        //
        serverInfo.setArc_hbits(Integer.parseInt(default0(properties.getProperty("arch_bits"))));
        serverInfo.setLru_clock(Integer.parseInt(default0(properties.getProperty("lru_clock"))));
        serverInfo.setProcess_id(Integer.parseInt(default0(properties.getProperty("process_id"))));
        serverInfo.setRedis_mode(properties.getProperty("redis_mode"));
        serverInfo.setRedis_version(properties.getProperty("redis_version"));
        serverInfo.setRun_id(properties.getProperty("run_id"));
        //自定义
        serverInfo.setServer_host(properties.getProperty("server_host"));

        serverInfo.setTcp_port(properties.getProperty("tcp_port"));
        serverInfo.setUptime_in_days(Integer.parseInt(default0(properties.getProperty("uptime_in_days"))));
        serverInfo.setUptime_in_seconds(Integer.parseInt(default0(properties.getProperty("uptime_in_seconds"))));

        return serverInfo;
    }

    /*

     */
    private static ClientInfo ParserToClientInfo(Properties properties) {

        ClientInfo clientInfo = new ClientInfo();

        clientInfo.setBlocked_clients(Integer.parseInt(default0(properties.getProperty("blocked_clients"))));
        clientInfo.setClient_biggest_input_buf(Integer.parseInt(default0(properties.getProperty("client_biggest_input_buf"))));
        clientInfo.setClient_longest_output_list(Integer.parseInt(default0(properties.getProperty("client_longest_output_list"))));
        clientInfo.setConnected_clients(Integer.parseInt(default0(properties.getProperty("connected_clients"))));

        return clientInfo;
    }

    /*

     */
    private static MemoryInfo ParserToMemoryInfo(Properties properties) {
        MemoryInfo memoryInfo = new MemoryInfo();

        memoryInfo.setMaxmemory(Long.parseLong(default0(properties.getProperty("maxmemory"))));
        memoryInfo.setMem_fragmentation_ratio(Float.parseFloat(default0(properties.getProperty("mem_fragmentation_ratio"))));
        memoryInfo.setTotal_system_memory(Long.parseLong(default0(properties.getProperty("total_system_memory"))));
        memoryInfo.setUsed_memory(Long.parseLong(default0(properties.getProperty("used_memory"))));
        memoryInfo.setUsed_memory_peak(Long.parseLong(default0(properties.getProperty("used_memory_peak"))));
        memoryInfo.setUsed_memory_rss(Long.parseLong(default0(properties.getProperty("used_memory_rss"))));

        return memoryInfo;
    }

    /*

     */
    private static PersistenceInfo ParserToPersistenceInfo(Properties properties) {
        PersistenceInfo persistenceInfo = new PersistenceInfo();

        persistenceInfo.setAof_base_size(Long.parseLong(default0(properties.getProperty("aof_base_size"))));
        persistenceInfo.setAof_buffer_length(Integer.parseInt(default0(properties.getProperty("aof_buffer_length"))));
        persistenceInfo.setAof_current_rewrite_time_sec(Long.parseLong(default0(properties.getProperty("aof_current_rewrite_time_sec"))));
        persistenceInfo.setAof_current_size(Long.parseLong(default0(properties.getProperty("aof_current_size"))));
        persistenceInfo.setAof_delayed_fsync(Integer.parseInt(default0(properties.getProperty("aof_delayed_fsync"))));
        persistenceInfo.setAof_enabled(Integer.parseInt(default0(properties.getProperty("aof_enabled"))));
        persistenceInfo.setAof_last_bgrewrite_status(properties.getProperty("aof_last_bgrewrite_status"));
        persistenceInfo.setAof_last_rewrite_time_sec(Long.parseLong(default0(properties.getProperty("aof_last_rewrite_time_sec"))));
        persistenceInfo.setAof_last_write_status(properties.getProperty("aof_last_write_status"));
        persistenceInfo.setAof_pending_bio_fsync(Integer.parseInt(default0(properties.getProperty("aof_pending_bio_fsync"))));
        persistenceInfo.setAof_pending_rewrite(Integer.parseInt(default0(properties.getProperty("aof_pending_rewrite"))));
        persistenceInfo.setAof_rewrite_buffer_length(Integer.parseInt(default0(properties.getProperty("aof_rewrite_buffer_length"))));
        persistenceInfo.setAof_rewrite_in_progress(Integer.parseInt(default0(properties.getProperty("aof_rewrite_in_progress"))));
        persistenceInfo.setAof_rewrite_scheduled(Integer.parseInt(default0(properties.getProperty("aof_rewrite_scheduled"))));

        persistenceInfo.setLoading(Integer.parseInt(default0(properties.getProperty("loading"))));
        persistenceInfo.setRdb_bgsave_in_progress(Integer.parseInt(default0(properties.getProperty("rdb_bgsave_in_progress"))));
        persistenceInfo.setRdb_changes_since_last_save(Long.parseLong(default0(properties.getProperty("rdb_changes_since_last_save"))));
        persistenceInfo.setRdb_current_bgsave_time_sec(Long.parseLong(default0(properties.getProperty("rdb_current_bgsave_time_sec"))));

        persistenceInfo.setRdb_last_save_time(Long.parseLong(default0(properties.getProperty("rdb_last_save_time"))));

        persistenceInfo.setRdb_last_bgsave_status(properties.getProperty("rdb_last_bgsave_status"));
        return persistenceInfo;
    }

    /*

     */
    private static StatsInfo ParserToStatsInfo(Properties properties) {
        StatsInfo statsInfo = new StatsInfo();

        statsInfo.setEvicted_keys(Long.parseLong(default0(properties.getProperty("evicted_keys"))));
        statsInfo.setExpired_keys(Long.parseLong(default0(properties.getProperty("expired_keys"))));
        statsInfo.setInstantaneous_input_kbps(Float.parseFloat(default0(properties.getProperty("instantaneous_input_kbps"))));
        statsInfo.setInstantaneous_ops_per_sec(Integer.parseInt(default0(properties.getProperty("instantaneous_ops_per_sec"))));
        statsInfo.setInstantaneous_output_kbps(Float.parseFloat(default0(properties.getProperty("instantaneous_output_kbps"))));
        statsInfo.setKeyspace_hits(Long.parseLong(default0(properties.getProperty("keyspace_hits"))));
        statsInfo.setKeyspace_misses(Long.parseLong(default0(properties.getProperty("keyspace_misses"))));
        statsInfo.setLatest_fork_usec(Integer.parseInt(default0(properties.getProperty("latest_fork_usec"))));
        statsInfo.setRejected_connections(Integer.parseInt(default0(properties.getProperty("rejected_connections"))));
        statsInfo.setSync_full(Integer.parseInt(default0(properties.getProperty("sync_full"))));

        statsInfo.setSync_partial_err(Integer.parseInt(default0(properties.getProperty("sync_partial_err"))));
        statsInfo.setSync_partial_ok(Integer.parseInt(default0(properties.getProperty("sync_partial_ok"))));
        statsInfo.setTotal_commands_processed(Long.parseLong(default0(properties.getProperty("total_commands_processed"))));
        statsInfo.setTotal_connections_received(Integer.parseInt(default0(properties.getProperty("total_connections_received"))));
        statsInfo.setTotal_net_input_bytes(Long.parseLong(default0(properties.getProperty("total_net_input_bytes"))));
        statsInfo.setTotal_net_output_bytes(Long.parseLong(default0(properties.getProperty("total_net_output_bytes"))));

        return statsInfo;
    }

    /*

     */
    private static ReplicationInfo ParserToReplicationInfo(Properties properties) {
        ReplicationInfo replicationInfo = new ReplicationInfo();
        replicationInfo.setConnected_slaves(Integer.parseInt(default0(properties.getProperty("connected_slaves"))));
        replicationInfo.setSlaves(ParserToReplicationSlaveInfo(properties, replicationInfo.getConnected_slaves()));

        replicationInfo.setRole(properties.getProperty("role"));
        if (replicationInfo.getRole().equals("slave")) {

            replicationInfo.setMaster_host(properties.getProperty("master_host") + ":" + properties.getProperty("master_port"));
            //replicationInfo.setMaster_host(properties.getProperty("master_host"));
            replicationInfo.setMaster_last_io_seconds_ago(Integer.parseInt(default0(properties.getProperty("master_last_io_seconds_ago"))));
            replicationInfo.setMaster_link_status(properties.getProperty("master_link_status"));
            replicationInfo.setMaster_port(properties.getProperty("master_port"));


            replicationInfo.setMaster_sync_in_progress(Integer.parseInt(default0(properties.getProperty("master_sync_in_progress"))));
            replicationInfo.setSlave_priority(Integer.parseInt(default0(properties.getProperty("slave_priority"))));
            replicationInfo.setSlave_read_only(Integer.parseInt(default0(properties.getProperty("slave_read_only"))));
            replicationInfo.setSlave_repl_offset(Long.parseLong(default0(properties.getProperty("slave_repl_offset"))));
        } else { //master为null时 默认将slave的数据赋值到master
            if (replicationInfo.getSlaves() != null && replicationInfo.getSlaves().size() > 0) {
                replicationInfo.setMaster_host(replicationInfo.getSlaves().get(0).getSlave_ip() + ":" + replicationInfo.getSlaves().get(0).getSlave_port());
                replicationInfo.setMaster_port(replicationInfo.getSlaves().get(0).getSlave_port());
                replicationInfo.setMaster_link_status(replicationInfo.getSlaves().get(0).getSlave_state());
            } else {
                //noslave
                replicationInfo.setMaster_host("no slave");
                replicationInfo.setMaster_port("error");
                replicationInfo.setMaster_link_status("online");
            }

        }

        replicationInfo.setMaster_repl_offset(Long.parseLong(default0(properties.getProperty("master_repl_offset"))));
        replicationInfo.setRepl_backlog_active(Integer.parseInt(default0(properties.getProperty("repl_backlog_active"))));
        replicationInfo.setRepl_backlog_size(Long.parseLong(default0(properties.getProperty("repl_backlog_size"))));
        replicationInfo.setRepl_backlog_first_byte_offset(Long.parseLong(default0(properties.getProperty("repl_backlog_first_byte_offset"))));
        replicationInfo.setRepl_backlog_histlen(Long.parseLong(default0(properties.getProperty("repl_backlog_histlen"))));

        return replicationInfo;
    }

    /*
     */
    private static List<ReplicationSlaveInfo> ParserToReplicationSlaveInfo(Properties properties, int connectedSlaves) {

        List<ReplicationSlaveInfo> slaveInfoList = null;
        if (connectedSlaves > 0) {
            slaveInfoList = new ArrayList<>();
            for (int i = 0; i < connectedSlaves; i++) {
                ReplicationSlaveInfo replicationSlaveInfo = new ReplicationSlaveInfo();

                String strSlaveId = "slave" + i;
                replicationSlaveInfo.setSlave_id(strSlaveId);

                String[] strArrSlaveX = properties.getProperty(strSlaveId).split(",");
                for (String strSlavex : strArrSlaveX) {
                    String[] slave0 = strSlavex.split("=");
                    if (slave0[0].equals("ip")) {
                        replicationSlaveInfo.setSlave_ip(slave0[1]);
                    } else if (slave0[0].equals("port")) {
                        replicationSlaveInfo.setSlave_port(slave0[1]);
                    } else if (slave0[0].equals("state")) {
                        replicationSlaveInfo.setSlave_state(slave0[1]);
                    } else if (slave0[0].equals("offset")) {
                        replicationSlaveInfo.setSlave_offset(Long.parseLong(slave0[1]));
                    } else if (slave0[0].equals("lag")) {
                        replicationSlaveInfo.setSlave_lag(Integer.parseInt(slave0[1]));
                    } else {
                        continue;
                    }
                }
                slaveInfoList.add(replicationSlaveInfo);
            }
        }
        return slaveInfoList;
    }

    /*

     */
    private static CpuInfo ParserToCpuInfo(Properties properties) {
        CpuInfo cpuInfo = new CpuInfo();
        cpuInfo.setUsed_cpu_sys(Float.parseFloat(default0(properties.getProperty("used_cpu_sys"))));
        cpuInfo.setUsed_cpu_sys_children(Float.parseFloat(default0(properties.getProperty("used_cpu_sys_children"))));
        cpuInfo.setUsed_cpu_user(Float.parseFloat(default0(properties.getProperty("used_cpu_user"))));
        cpuInfo.setUsed_cpu_user_children(Float.parseFloat(default0(properties.getProperty("used_cpu_user_children"))));

        return cpuInfo;
    }

    /*

     */
    private static ClusterInfo ParserToClusterInfo(Properties properties) {
        ClusterInfo clusterInfo = new ClusterInfo();

        clusterInfo.setCluster_name(properties.getProperty("cluster_name"));

        clusterInfo.setCluster_current_epoch(Integer.parseInt(default0(properties.getProperty("cluster_current_epoch"))));
        clusterInfo.setCluster_enabled(properties.getProperty("cluster_enabled"));
        clusterInfo.setCluster_known_nodes(Integer.parseInt(default0(properties.getProperty("cluster_known_nodes"))));
        clusterInfo.setCluster_known_nodes_up(Integer.parseInt(default0(properties.getProperty("cluster_known_nodes_up"))));
        clusterInfo.setCluster_size(Integer.parseInt(default0(properties.getProperty("cluster_size"))));
        clusterInfo.setCluster_slots_assigned(Integer.parseInt(default0(properties.getProperty("cluster_slots_assigned"))));
        clusterInfo.setCluster_slots_fail(Integer.parseInt(default0(properties.getProperty("cluster_slots_fail"))));
        clusterInfo.setCluster_slots_ok(Integer.parseInt(default0(properties.getProperty("cluster_slots_ok"))));
        clusterInfo.setCluster_slots_pfail(Integer.parseInt(default0(properties.getProperty("cluster_slots_pfail"))));
        clusterInfo.setCluster_state(properties.getProperty("cluster_state"));
        clusterInfo.setCluster_stats_messages_received(Long.parseLong(default0(properties.getProperty("cluster_stats_messages_received"))));
        clusterInfo.setCluster_stats_messages_sent(Long.parseLong(default0(properties.getProperty("cluster_stats_messages_sent"))));

        return clusterInfo;
    }

    /*

     */
    private static KeyspaceInfo ParserToKeyspaceInfo(Properties properties) {

        KeyspaceInfo keyspaceInfo = new KeyspaceInfo();
        List<KeyspaceDBXInfo> dbxInfoList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            String strDbId = "db" + i;
            String strDbXValue = properties.getProperty(strDbId);
            if (strDbXValue != null) {
                keyspaceInfo.setServer_db_counts(keyspaceInfo.getServer_db_counts() + 1);
                KeyspaceDBXInfo keyspaceDBXInfo = new KeyspaceDBXInfo();
                keyspaceDBXInfo.setDb_id(strDbId);
                String[] strDbX0 = strDbXValue.split(",");
                for (String dbx0 : strDbX0) {
                    String[] strDbX1 = dbx0.split("=");
                    if (strDbX1[0].equals("keys")) {
                        keyspaceDBXInfo.setKeys(Integer.parseInt(strDbX1[1]));
                        //
                        keyspaceInfo.setServer_db_keys(keyspaceDBXInfo.getKeys() + keyspaceInfo.getServer_db_keys());
                    } else if (strDbX1[0].equals("expires")) {
                        keyspaceDBXInfo.setExpires(Integer.parseInt(strDbX1[1]));
                        keyspaceInfo.setServer_db_expires(keyspaceDBXInfo.getExpires() + keyspaceInfo.getServer_db_expires());
                    } else if (strDbX1[0].equals("avg_ttl")) {
                        keyspaceDBXInfo.setAvg_ttl(Long.parseLong(strDbX1[1]));
                    } else {
                        continue;
                    }
                }
                dbxInfoList.add(keyspaceDBXInfo);
            }
        }
        keyspaceInfo.setDbs(dbxInfoList);
        return keyspaceInfo;
    }

    /*

     */
    private static CommandStatsInfo ParserToCommandStatsInfo(Properties properties) {
        CommandStatsInfo commandStatsInfo = new CommandStatsInfo();
//# Commandstats
//        cmdstat_get:calls=101187,usec=815066,usec_per_call=8.06
        commandStatsInfo.setCmdstat_get(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_get")));
//        cmdstat_set:calls=7783,usec=310505,usec_per_call=39.90
        commandStatsInfo.setCmdstat_set(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_set")));
//        cmdstat_setex:calls=8452,usec=167247,usec_per_call=19.79
        commandStatsInfo.setCmdstat_setex(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_setex")));
//        cmdstat_del:calls=28110,usec=186114,usec_per_call=6.62
        commandStatsInfo.setCmdstat_del(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_del")));
//        cmdstat_exists:calls=9270,usec=42521,usec_per_call=4.59
        commandStatsInfo.setCmdstat_exists(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_exists")));
//        cmdstat_rpush:calls=100000,usec=63860,usec_per_call=0.64
        commandStatsInfo.setCmdstat_rpush(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_rpush")));
//        cmdstat_lpush:calls=358070,usec=1589102,usec_per_call=4.44
        commandStatsInfo.setCmdstat_lpush(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_lpush")));
//        cmdstat_rpop:calls=100490,usec=75474,usec_per_call=0.75
        commandStatsInfo.setCmdstat_rpop(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_rpop")));
//        cmdstat_lpop:calls=100002,usec=125880,usec_per_call=1.26
        commandStatsInfo.setCmdstat_lpop(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_lpop")));
//        cmdstat_llen:calls=102983,usec=184490,usec_per_call=1.79
        commandStatsInfo.setCmdstat_llen(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_llen")));
//        cmdstat_lindex:calls=991,usec=13685,usec_per_call=13.81
        commandStatsInfo.setCmdstat_lindex(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_lindex")));
//        cmdstat_lset:calls=11,usec=273,usec_per_call=24.82
        commandStatsInfo.setCmdstat_lset(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_lset")));
//        cmdstat_lrange:calls=512576,usec=14088447,usec_per_call=27.49
        commandStatsInfo.setCmdstat_lrange(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_lrange")));
//        cmdstat_ltrim:calls=2,usec=36,usec_per_call=18.00
        commandStatsInfo.setCmdstat_ltrim(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_ltrim")));
//        cmdstat_lrem:calls=106573,usec=1271382,usec_per_call=11.93
        commandStatsInfo.setCmdstat_lrem(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_lrem")));
//        cmdstat_sadd:calls=100000,usec=53779,usec_per_call=0.54
        commandStatsInfo.setCmdstat_sadd(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_sadd")));
//        cmdstat_spop:calls=100000,usec=25161,usec_per_call=0.25
        commandStatsInfo.setCmdstat_spop(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_spop")));
//        cmdstat_hset:calls=898,usec=21597,usec_per_call=24.05
        commandStatsInfo.setCmdstat_hset(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hset")));
//        cmdstat_hget:calls=1630,usec=17109,usec_per_call=10.50
        commandStatsInfo.setCmdstat_hget(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hget")));
//        cmdstat_hmset:calls=229,usec=5174,usec_per_call=22.59
        commandStatsInfo.setCmdstat_hmset(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hmset")));
//        cmdstat_hdel:calls=26,usec=598,usec_per_call=23.00
        commandStatsInfo.setCmdstat_hdel(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hdel")));
//        cmdstat_hlen:calls=216,usec=1401,usec_per_call=6.49
        commandStatsInfo.setCmdstat_hlen(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hlen")));
//        cmdstat_hkeys:calls=2,usec=9,usec_per_call=4.50
        commandStatsInfo.setCmdstat_hkeys(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hkeys")));
//        cmdstat_hvals:calls=1,usec=7,usec_per_call=7.00
        commandStatsInfo.setCmdstat_hvals(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hvals")));
//        cmdstat_hgetall:calls=36007,usec=204499,usec_per_call=5.68
        commandStatsInfo.setCmdstat_hgetall(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hgetall")));
//        cmdstat_hscan:calls=184,usec=4347,usec_per_call=23.62
        commandStatsInfo.setCmdstat_hscan(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_hscan")));
//        cmdstat_getset:calls=7,usec=69,usec_per_call=9.86
        commandStatsInfo.setCmdstat_getset(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_getset")));
//        cmdstat_select:calls=416,usec=1580,usec_per_call=3.80
        commandStatsInfo.setCmdstat_select(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_select")));
//        cmdstat_renamenx:calls=1,usec=5,usec_per_call=5.00
        commandStatsInfo.setCmdstat_renamenx(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_renamenx")));
//        cmdstat_expire:calls=2,usec=9,usec_per_call=4.50
        commandStatsInfo.setCmdstat_expire(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_expire")));
//        cmdstat_expireat:calls=6,usec=44,usec_per_call=7.33
        commandStatsInfo.setCmdstat_expireat(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_expireat")));
//        cmdstat_keys:calls=345,usec=92996,usec_per_call=269.55
        commandStatsInfo.setCmdstat_keys(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_keys")));
//        cmdstat_scan:calls=161,usec=76001,usec_per_call=472.06
        commandStatsInfo.setCmdstat_scan(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_scan")));
//        cmdstat_dbsize:calls=1,usec=3,usec_per_call=3.00
        commandStatsInfo.setCmdstat_dbsize(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_dbsize")));
//        cmdstat_ping:calls=255875,usec=174574,usec_per_call=0.68
        commandStatsInfo.setCmdstat_ping(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_ping")));
//        cmdstat_type:calls=16969,usec=73496,usec_per_call=4.33
        commandStatsInfo.setCmdstat_type(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_type")));
//        cmdstat_sync:calls=3,usec=1618,usec_per_call=539.33
        commandStatsInfo.setCmdstat_sync(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_sync")));
//        cmdstat_psync:calls=1,usec=693,usec_per_call=693.00
        commandStatsInfo.setCmdstat_psync(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_psync")));
//        cmdstat_replconf:calls=8520709,usec=33608874,usec_per_call=3.94
        commandStatsInfo.setCmdstat_replconf(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_replconf")));
//        cmdstat_info:calls=5387,usec=566093,usec_per_call=105.09
        commandStatsInfo.setCmdstat_info(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_info")));
//        cmdstat_ttl:calls=8800,usec=38821,usec_per_call=4.41
        commandStatsInfo.setCmdstat_ttl(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_ttl")));
//        cmdstat_role:calls=4,usec=55,usec_per_call=13.75
        commandStatsInfo.setCmdstat_role(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_role")));
//        cmdstat_config:calls=29,usec=1962,usec_per_call=67.66
        commandStatsInfo.setCmdstat_config(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_config")));
//        cmdstat_subscribe:calls=2,usec=26,usec_per_call=13.00
        commandStatsInfo.setCmdstat_subscribe(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_subscribe")));
//        cmdstat_publish:calls=3,usec=56,usec_per_call=18.67
        commandStatsInfo.setCmdstat_publish(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_publish")));
//        cmdstat_pubsub:calls=6,usec=112,usec_per_call=18.67
        commandStatsInfo.setCmdstat_pubsub(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_pubsub")));
//        cmdstat_cluster:calls=9108,usec=1534795,usec_per_call=168.51
        commandStatsInfo.setCmdstat_cluster(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_cluster")));
//        cmdstat_dump:calls=1,usec=24,usec_per_call=24.00
        commandStatsInfo.setCmdstat_dump(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_dump")));
//        cmdstat_client:calls=9,usec=199,usec_per_call=22.11
        commandStatsInfo.setCmdstat_client(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_client")));
//        cmdstat_command:calls=21,usec=28389,usec_per_call=1351.86
        commandStatsInfo.setCmdstat_command(ParserToCommandStatsCallInfo(properties.getProperty("cmdstat_command")));

        return commandStatsInfo;
    }

    /**
     *
     * @param propertiesValue
     * @return
     */
    private static String default0(String propertiesValue)
    {
        if(propertiesValue==null)
        {
            return "0";
        }
        return propertiesValue;
    }
    /*

     */
    private static CommandStatsCallInfo ParserToCommandStatsCallInfo(String strInfo) {
        CommandStatsCallInfo commandStatsCallInfo = new CommandStatsCallInfo();
        //cmdstat_command:calls=21,usec=28389,usec_per_call=1351.86
        if (strInfo != null) {
            String[] str_arr0 = strInfo.split(",");
            for (String str0 : str_arr0) {
                String[] str_arr1 = str0.split("=");
                if (str_arr1[0].equals("calls")) {
                    commandStatsCallInfo.setCalls(Long.parseLong(str_arr1[1]));
                } else if (str_arr1[0].equals("usec")) {
                    commandStatsCallInfo.setUsec(Long.parseLong(str_arr1[1]));
                } else if (str_arr1[0].equals("usec_per_call")) {
                    commandStatsCallInfo.setUsec_per_call(Float.parseFloat(str_arr1[1]));
                } else {
                    continue;
                }

            }

        }
        return commandStatsCallInfo;
    }
}
