package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/19.
 */
public class KeyspaceDBXInfo {

    private String db_id;

    private int keys;
    private int expires;
    private long avg_ttl;

    public String getDb_id() {
        return db_id;
    }

    public void setDb_id(String db_id) {
        this.db_id = db_id;
    }

    public int getKeys() {
        return keys;
    }

    public void setKeys(int keys) {
        this.keys = keys;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public long getAvg_ttl() {
        return avg_ttl;
    }

    public void setAvg_ttl(long avg_ttl) {
        this.avg_ttl = avg_ttl;
    }
}
