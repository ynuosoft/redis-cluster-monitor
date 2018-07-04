package com.ynuosoft.redisinfo.monitor.entity.output;

import java.util.List;

/**
 * Created by meng li on 2017/1/18.
 */
public class ReplicationInfo {

//    # Replication
//    role:master
//    connected_slaves:1
//    slave0:ip=113.52.181.68,port=53451,state=online,offset=10359029778,lag=1
//    master_repl_offset:10359029778

//    repl_backlog_active:1
//    repl_backlog_size:1048576
//    repl_backlog_first_byte_offset:10357981203
//    repl_backlog_histlen:1048576

//    # Replication
//    role:slave
//    master_host:113.52.181.65
//    master_port:53450
//    master_link_status:up
//    master_last_io_seconds_ago:6
//    master_sync_in_progress:0
//    slave_repl_offset:10359033782
//    slave_priority:100
//    slave_read_only:1

//    connected_slaves:0
//    master_repl_offset:0
//    repl_backlog_active:0
//    repl_backlog_size:1048576
//    repl_backlog_first_byte_offset:0
//    repl_backlog_histlen:0

    private String role;
    private int connected_slaves;
    private List<ReplicationSlaveInfo> slaves;

    private long master_repl_offset;
    private int repl_backlog_active;
    private long repl_backlog_size;
    private long repl_backlog_first_byte_offset;
    private long repl_backlog_histlen;

    private String master_host;
    private String master_port;
    private String master_link_status;
    private int master_last_io_seconds_ago;
    private int master_sync_in_progress;
    private long slave_repl_offset;
    private int slave_priority;
    private int slave_read_only;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getConnected_slaves() {
        return connected_slaves;
    }

    public void setConnected_slaves(int connected_slaves) {
        this.connected_slaves = connected_slaves;
    }

    public List<ReplicationSlaveInfo> getSlaves() {
        return slaves;
    }

    public void setSlaves(List<ReplicationSlaveInfo> slaves) {
        this.slaves = slaves;
    }

    public long getMaster_repl_offset() {
        return master_repl_offset;
    }

    public void setMaster_repl_offset(long master_repl_offset) {
        this.master_repl_offset = master_repl_offset;
    }

    public int getRepl_backlog_active() {
        return repl_backlog_active;
    }

    public void setRepl_backlog_active(int repl_backlog_active) {
        this.repl_backlog_active = repl_backlog_active;
    }

    public long getRepl_backlog_size() {
        return repl_backlog_size;
    }

    public void setRepl_backlog_size(long repl_backlog_size) {
        this.repl_backlog_size = repl_backlog_size;
    }

    public long getRepl_backlog_first_byte_offset() {
        return repl_backlog_first_byte_offset;
    }

    public void setRepl_backlog_first_byte_offset(long repl_backlog_first_byte_offset) {
        this.repl_backlog_first_byte_offset = repl_backlog_first_byte_offset;
    }

    public long getRepl_backlog_histlen() {
        return repl_backlog_histlen;
    }

    public void setRepl_backlog_histlen(long repl_backlog_histlen) {
        this.repl_backlog_histlen = repl_backlog_histlen;
    }

    public String getMaster_host() {
        return master_host;
    }

    public void setMaster_host(String master_host) {
        this.master_host = master_host;
    }

    public String getMaster_port() {
        return master_port;
    }

    public void setMaster_port(String master_port) {
        this.master_port = master_port;
    }

    public String getMaster_link_status() {
        return master_link_status;
    }

    public void setMaster_link_status(String master_link_status) {
        this.master_link_status = master_link_status;
    }

    public int getMaster_last_io_seconds_ago() {
        return master_last_io_seconds_ago;
    }

    public void setMaster_last_io_seconds_ago(int master_last_io_seconds_ago) {
        this.master_last_io_seconds_ago = master_last_io_seconds_ago;
    }

    public int getMaster_sync_in_progress() {
        return master_sync_in_progress;
    }

    public void setMaster_sync_in_progress(int master_sync_in_progress) {
        this.master_sync_in_progress = master_sync_in_progress;
    }

    public long getSlave_repl_offset() {
        return slave_repl_offset;
    }

    public void setSlave_repl_offset(long slave_repl_offset) {
        this.slave_repl_offset = slave_repl_offset;
    }

    public int getSlave_priority() {
        return slave_priority;
    }

    public void setSlave_priority(int slave_priority) {
        this.slave_priority = slave_priority;
    }

    public int getSlave_read_only() {
        return slave_read_only;
    }

    public void setSlave_read_only(int slave_read_only) {
        this.slave_read_only = slave_read_only;
    }
}
