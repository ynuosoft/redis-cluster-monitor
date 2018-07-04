package com.ynuosoft.redisinfo.monitor.entity.output;


/**
 * Created by meng li on 2017/1/18.
 * redis节点信息
 */
public class NodeInfo {

    private String record_time;
    private ServerInfo server;
    private ClientInfo client;
    private MemoryInfo memory;
    private PersistenceInfo persistence;
    private StatsInfo stats;
    private ReplicationInfo replication;
    private CpuInfo cpu;
    private CommandStatsInfo commandstats;
    private ClusterInfo cluster;
    private KeyspaceInfo keyspace;

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    public ServerInfo getServer() {
        return server;
    }

    public void setServer(ServerInfo server) {
        this.server = server;
    }
    public ClientInfo getClient() {
        return client;
    }

    public void setClient(ClientInfo client) {
        this.client = client;
    }

    public MemoryInfo getMemory() {
        return memory;
    }

    public void setMemory(MemoryInfo memory) {
        this.memory = memory;
    }

    public PersistenceInfo getPersistence() {
        return persistence;
    }

    public void setPersistence(PersistenceInfo persistence) {
        this.persistence = persistence;
    }

    public StatsInfo getStats() {
        return stats;
    }

    public void setStats(StatsInfo stats) {
        this.stats = stats;
    }

    public ReplicationInfo getReplication() {
        return replication;
    }

    public void setReplication(ReplicationInfo replication) {
        this.replication = replication;
    }

    public CpuInfo getCpu() {
        return cpu;
    }

    public void setCpu(CpuInfo cpu) {
        this.cpu = cpu;
    }

    public ClusterInfo getCluster() {
        return cluster;
    }

    public void setCluster(ClusterInfo cluster) {
        this.cluster = cluster;
    }

    public KeyspaceInfo getKeyspace() {
        return keyspace;
    }

    public void setKeyspace(KeyspaceInfo keyspace) {
        this.keyspace = keyspace;
    }

    public CommandStatsInfo getCommandstats() {
        return commandstats;
    }

    public void setCommandstats(CommandStatsInfo commandstats) {
        this.commandstats = commandstats;
    }
}
