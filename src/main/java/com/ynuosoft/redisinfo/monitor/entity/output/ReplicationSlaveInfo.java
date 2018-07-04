package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/19.
 */
public class ReplicationSlaveInfo {

    private String slave_id;
    private String slave_ip;
    private String slave_port;
    private String slave_state;
    private long slave_offset;
    private int slave_lag;

    public String getSlave_id() {
        return slave_id;
    }

    public void setSlave_id(String slave_id) {
        this.slave_id = slave_id;
    }

    public String getSlave_ip() {
        return slave_ip;
    }

    public void setSlave_ip(String slave_ip) {
        this.slave_ip = slave_ip;
    }

    public String getSlave_port() {
        return slave_port;
    }

    public void setSlave_port(String slave_port) {
        this.slave_port = slave_port;
    }

    public String getSlave_state() {
        return slave_state;
    }

    public void setSlave_state(String slave_state) {
        this.slave_state = slave_state;
    }

    public long getSlave_offset() {
        return slave_offset;
    }

    public void setSlave_offset(long slave_offset) {
        this.slave_offset = slave_offset;
    }

    public int getSlave_lag() {
        return slave_lag;
    }

    public void setSlave_lag(int slave_lag) {
        this.slave_lag = slave_lag;
    }
}
