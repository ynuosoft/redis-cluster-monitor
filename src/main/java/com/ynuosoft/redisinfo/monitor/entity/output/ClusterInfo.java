package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class ClusterInfo {

//    # Cluster
//    cluster_enabled:1
//    cluster_state:ok
//    cluster_slots_assigned:16384
//    cluster_slots_ok:16384
//    cluster_slots_pfail:0
//    cluster_slots_fail:0
//    cluster_known_nodes:6
//    cluster_size:3
//    cluster_current_epoch:6
//    cluster_my_epoch:3
//    cluster_stats_messages_sent:24732030
//    cluster_stats_messages_received:24732030

    private String cluster_name;
    private String cluster_enabled;
    private String cluster_state;
    private int cluster_slots_assigned;
    private int cluster_slots_ok;
    private int cluster_slots_pfail;
    private int cluster_slots_fail;
    private int cluster_known_nodes;
    private int cluster_known_nodes_up;
    private int cluster_size;
    private int cluster_current_epoch;
    private long cluster_stats_messages_sent;
    private long cluster_stats_messages_received;

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getCluster_enabled() {
        return cluster_enabled;
    }

    public void setCluster_enabled(String cluster_enabled) {
        this.cluster_enabled = cluster_enabled;
    }

    public String getCluster_state() {
        return cluster_state;
    }

    public void setCluster_state(String cluster_state) {
        this.cluster_state = cluster_state;
    }

    public int getCluster_slots_assigned() {
        return cluster_slots_assigned;
    }

    public void setCluster_slots_assigned(int cluster_slots_assigned) {
        this.cluster_slots_assigned = cluster_slots_assigned;
    }

    public int getCluster_slots_ok() {
        return cluster_slots_ok;
    }

    public void setCluster_slots_ok(int cluster_slots_ok) {
        this.cluster_slots_ok = cluster_slots_ok;
    }

    public int getCluster_slots_pfail() {
        return cluster_slots_pfail;
    }

    public void setCluster_slots_pfail(int cluster_slots_pfail) {
        this.cluster_slots_pfail = cluster_slots_pfail;
    }

    public int getCluster_slots_fail() {
        return cluster_slots_fail;
    }

    public void setCluster_slots_fail(int cluster_slots_fail) {
        this.cluster_slots_fail = cluster_slots_fail;
    }

    public int getCluster_known_nodes() {
        return cluster_known_nodes;
    }

    public void setCluster_known_nodes(int cluster_known_nodes) {
        this.cluster_known_nodes = cluster_known_nodes;
    }

    public int getCluster_known_nodes_up() {
        return cluster_known_nodes_up;
    }

    public void setCluster_known_nodes_up(int cluster_known_nodes_up) {
        this.cluster_known_nodes_up = cluster_known_nodes_up;
    }

    public int getCluster_size() {
        return cluster_size;
    }

    public void setCluster_size(int cluster_size) {
        this.cluster_size = cluster_size;
    }

    public int getCluster_current_epoch() {
        return cluster_current_epoch;
    }

    public void setCluster_current_epoch(int cluster_current_epoch) {
        this.cluster_current_epoch = cluster_current_epoch;
    }

    public long getCluster_stats_messages_sent() {
        return cluster_stats_messages_sent;
    }

    public void setCluster_stats_messages_sent(long cluster_stats_messages_sent) {
        this.cluster_stats_messages_sent = cluster_stats_messages_sent;
    }

    public long getCluster_stats_messages_received() {
        return cluster_stats_messages_received;
    }

    public void setCluster_stats_messages_received(long cluster_stats_messages_received) {
        this.cluster_stats_messages_received = cluster_stats_messages_received;
    }
}
