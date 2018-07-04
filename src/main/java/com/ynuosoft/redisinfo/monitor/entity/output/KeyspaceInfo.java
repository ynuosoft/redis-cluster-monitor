package com.ynuosoft.redisinfo.monitor.entity.output;

import java.util.List;

/**
 * Created by meng li on 2017/1/18.
 */
public class KeyspaceInfo {

    private int server_db_counts;
    private int server_db_keys;
    private int server_db_keys_trend;
    private int server_db_expires;
    private int server_db_expires_trend;

    private List<KeyspaceDBXInfo> dbs;

    public int getServer_db_counts() {
        return server_db_counts;
    }

    public void setServer_db_counts(int server_db_counts) {
        this.server_db_counts = server_db_counts;
    }

    public int getServer_db_keys() {
        return server_db_keys;
    }

    public void setServer_db_keys(int server_db_keys) {
        this.server_db_keys = server_db_keys;
    }

    public int getServer_db_expires() {
        return server_db_expires;
    }

    public void setServer_db_expires(int server_db_expires) {
        this.server_db_expires = server_db_expires;
    }

    public List<KeyspaceDBXInfo> getDbs() {
        return dbs;
    }

    public void setDbs(List<KeyspaceDBXInfo> dbs) {
        this.dbs = dbs;
    }

    public int getServer_db_keys_trend() {
        return server_db_keys_trend;
    }

    public void setServer_db_keys_trend(int server_db_keys_trend) {
        this.server_db_keys_trend = server_db_keys_trend;
    }

    public int getServer_db_expires_trend() {
        return server_db_expires_trend;
    }

    public void setServer_db_expires_trend(int server_db_expires_trend) {
        this.server_db_expires_trend = server_db_expires_trend;
    }
}
