package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class ServerInfo {

//    # Server
//    redis_version:3.2.1
//    redis_git_sha1:00000000
//    redis_git_dirty:0
//    redis_build_id:7941e1fba3871983
//    redis_mode:cluster
//    os:Linux 3.8.13-68.3.4.el6uek.x86_64 x86_64
//    arch_bits:64
//    multiplexing_api:epoll
//    gcc_version:4.4.7
//    process_id:20284
//    run_id:db43ceb51a6fe7fd2539a4e1a9cac626714afc0b
//    tcp_port:53450
//    uptime_in_seconds:11647709
//    uptime_in_days:134
//    hz:10
//    lru_clock:8322020
//    executable:/usr/local/midware/redis-3.2.1-53450/./src/redis-server
//    config_file:/usr/local/midware/redis-3.2.1-53450/./redis-53450.conf

    private String redis_version;
    private String redis_mode;
    private int arc_hbits;
    private int process_id;
    private String run_id;
    private String server_host;
    private String tcp_port;
    private int uptime_in_seconds;
    private int uptime_in_days;
    private int lru_clock;


    public String getRedis_version() {
        return redis_version;
    }

    public void setRedis_version(String redis_version) {
        this.redis_version = redis_version;
    }

    public String getRedis_mode() {
        return redis_mode;
    }

    public void setRedis_mode(String redis_mode) {
        this.redis_mode = redis_mode;
    }

    public int getArc_hbits() {
        return arc_hbits;
    }

    public void setArc_hbits(int arc_hbits) {
        this.arc_hbits = arc_hbits;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public String getRun_id() {
        return run_id;
    }

    public void setRun_id(String run_id) {
        this.run_id = run_id;
    }

    public String getServer_host() {
        return server_host;
    }

    public void setServer_host(String server_host) {
        this.server_host = server_host;
    }

    public String getTcp_port() {
        return tcp_port;
    }

    public void setTcp_port(String tcp_port) {
        this.tcp_port = tcp_port;
    }

    public int getUptime_in_seconds() {
        return uptime_in_seconds;
    }

    public void setUptime_in_seconds(int uptime_in_seconds) {
        this.uptime_in_seconds = uptime_in_seconds;
    }

    public int getUptime_in_days() {
        return uptime_in_days;
    }

    public void setUptime_in_days(int uptime_in_days) {
        this.uptime_in_days = uptime_in_days;
    }

    public int getLru_clock() {
        return lru_clock;
    }

    public void setLru_clock(int lru_clock) {
        this.lru_clock = lru_clock;
    }
}
