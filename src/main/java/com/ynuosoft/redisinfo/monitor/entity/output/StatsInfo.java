package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class StatsInfo {

//# Stats
//    total_connections_received:9503
//    total_commands_processed:30726265
//    instantaneous_ops_per_sec:1
//    total_net_input_bytes:11533821059
//    total_net_output_bytes:89328825120
//    instantaneous_input_kbps:0.05
//    instantaneous_output_kbps:0.00
//    rejected_connections:0
//    sync_full:1
//    sync_partial_ok:0
//    sync_partial_err:0
//    expired_keys:3928668
//    evicted_keys:0
//    keyspace_hits:5487255
//    keyspace_misses:2895317
//    pubsub_channels:0
//    pubsub_patterns:0
//    latest_fork_usec:3855
//    migrate_cached_sockets:0


    private int total_connections_received;
    private int total_connections_received_trend;
    private long total_commands_processed;
    private long total_commands_processed_trend;
    private int instantaneous_ops_per_sec;
    private long total_net_input_bytes;
    private long total_net_input_bytes_trend;
    private long total_net_output_bytes;
    private long total_net_output_bytes_trend;
    private float instantaneous_input_kbps;
    private float instantaneous_output_kbps;
    private int rejected_connections;
    private int rejected_connections_trend;

    private int sync_full;
    private int sync_partial_ok;
    private int sync_partial_err;
    private long expired_keys;
    private long expired_keys_trend;
    private long evicted_keys;
    private long keyspace_hits;
    private long keyspace_hits_trend;
    private long keyspace_misses;
    private long keyspace_misses_trend;
    private int latest_fork_usec;

    public int getTotal_connections_received() {
        return total_connections_received;
    }

    public void setTotal_connections_received(int total_connections_received) {
        this.total_connections_received = total_connections_received;
    }

    public long getTotal_commands_processed() {
        return total_commands_processed;
    }

    public void setTotal_commands_processed(long total_commands_processed) {
        this.total_commands_processed = total_commands_processed;
    }

    public int getInstantaneous_ops_per_sec() {
        return instantaneous_ops_per_sec;
    }

    public void setInstantaneous_ops_per_sec(int instantaneous_ops_per_sec) {
        this.instantaneous_ops_per_sec = instantaneous_ops_per_sec;
    }

    public long getTotal_net_input_bytes() {
        return total_net_input_bytes;
    }

    public void setTotal_net_input_bytes(long total_net_input_bytes) {
        this.total_net_input_bytes = total_net_input_bytes;
    }

    public long getTotal_net_output_bytes() {
        return total_net_output_bytes;
    }

    public void setTotal_net_output_bytes(long total_net_output_bytes) {
        this.total_net_output_bytes = total_net_output_bytes;
    }

    public float getInstantaneous_input_kbps() {
        return instantaneous_input_kbps;
    }

    public void setInstantaneous_input_kbps(float instantaneous_input_kbps) {
        this.instantaneous_input_kbps = instantaneous_input_kbps;
    }

    public float getInstantaneous_output_kbps() {
        return instantaneous_output_kbps;
    }

    public void setInstantaneous_output_kbps(float instantaneous_output_kbps) {
        this.instantaneous_output_kbps = instantaneous_output_kbps;
    }

    public int getRejected_connections() {
        return rejected_connections;
    }

    public void setRejected_connections(int rejected_connections) {
        this.rejected_connections = rejected_connections;
    }

    public int getSync_full() {
        return sync_full;
    }

    public void setSync_full(int sync_full) {
        this.sync_full = sync_full;
    }

    public int getSync_partial_ok() {
        return sync_partial_ok;
    }

    public void setSync_partial_ok(int sync_partial_ok) {
        this.sync_partial_ok = sync_partial_ok;
    }

    public int getSync_partial_err() {
        return sync_partial_err;
    }

    public void setSync_partial_err(int sync_partial_err) {
        this.sync_partial_err = sync_partial_err;
    }

    public long getExpired_keys() {
        return expired_keys;
    }

    public void setExpired_keys(long expired_keys) {
        this.expired_keys = expired_keys;
    }

    public long getEvicted_keys() {
        return evicted_keys;
    }

    public void setEvicted_keys(long evicted_keys) {
        this.evicted_keys = evicted_keys;
    }

    public long getKeyspace_hits() {
        return keyspace_hits;
    }

    public void setKeyspace_hits(long keyspace_hits) {
        this.keyspace_hits = keyspace_hits;
    }

    public long getKeyspace_misses() {
        return keyspace_misses;
    }

    public void setKeyspace_misses(long keyspace_misses) {
        this.keyspace_misses = keyspace_misses;
    }

    public int getLatest_fork_usec() {
        return latest_fork_usec;
    }

    public void setLatest_fork_usec(int latest_fork_usec) {
        this.latest_fork_usec = latest_fork_usec;
    }

    public int getTotal_connections_received_trend() {
        return total_connections_received_trend;
    }

    public void setTotal_connections_received_trend(int total_connections_received_trend) {
        this.total_connections_received_trend = total_connections_received_trend;
    }

    public long getTotal_commands_processed_trend() {
        return total_commands_processed_trend;
    }

    public void setTotal_commands_processed_trend(long total_commands_processed_trend) {
        this.total_commands_processed_trend = total_commands_processed_trend;
    }

    public long getTotal_net_input_bytes_trend() {
        return total_net_input_bytes_trend;
    }

    public void setTotal_net_input_bytes_trend(long total_net_input_bytes_trend) {
        this.total_net_input_bytes_trend = total_net_input_bytes_trend;
    }

    public long getTotal_net_output_bytes_trend() {
        return total_net_output_bytes_trend;
    }

    public void setTotal_net_output_bytes_trend(long total_net_output_bytes_trend) {
        this.total_net_output_bytes_trend = total_net_output_bytes_trend;
    }

    public int getRejected_connections_trend() {
        return rejected_connections_trend;
    }

    public void setRejected_connections_trend(int rejected_connections_trend) {
        this.rejected_connections_trend = rejected_connections_trend;
    }

    public long getExpired_keys_trend() {
        return expired_keys_trend;
    }

    public void setExpired_keys_trend(long expired_keys_trend) {
        this.expired_keys_trend = expired_keys_trend;
    }

    public long getKeyspace_hits_trend() {
        return keyspace_hits_trend;
    }

    public void setKeyspace_hits_trend(long keyspace_hits_trend) {
        this.keyspace_hits_trend = keyspace_hits_trend;
    }

    public long getKeyspace_misses_trend() {
        return keyspace_misses_trend;
    }

    public void setKeyspace_misses_trend(long keyspace_misses_trend) {
        this.keyspace_misses_trend = keyspace_misses_trend;
    }
}
