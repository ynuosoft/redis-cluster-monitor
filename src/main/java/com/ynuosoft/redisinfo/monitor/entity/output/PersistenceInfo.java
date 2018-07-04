package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class PersistenceInfo {

//# Persistence
//    loading:0
//    rdb_changes_since_last_save:2
//    rdb_bgsave_in_progress:0
//    rdb_last_save_time:1484816673
//    rdb_last_bgsave_status:ok
//    rdb_last_bgsave_time_sec:0
//    rdb_current_bgsave_time_sec:-1

//    aof_enabled:1
//    aof_rewrite_in_progress:0
//    aof_rewrite_scheduled:0
//    aof_last_rewrite_time_sec:3
//    aof_current_rewrite_time_sec:-1
//    aof_last_bgrewrite_status:ok
//    aof_last_write_status:ok
//    aof_current_size:373684566
//    aof_base_size:278652585
//    aof_pending_rewrite:0
//    aof_buffer_length:0
//    aof_rewrite_buffer_length:0
//    aof_pending_bio_fsync:0
//    aof_delayed_fsync:0


    private int loading;
    private long rdb_changes_since_last_save;
    private int rdb_bgsave_in_progress;
    private long rdb_last_save_time;
    private String rdb_last_bgsave_status;
    private long rdb_last_bgsave_time_sec;
    private long rdb_current_bgsave_time_sec;

    private int aof_enabled;
    private int aof_rewrite_in_progress;
    private int aof_rewrite_scheduled;
    private long aof_last_rewrite_time_sec;
    private long aof_current_rewrite_time_sec;
    private String aof_last_bgrewrite_status;
    private String aof_last_write_status;
    private long aof_current_size;
    private long aof_base_size;
    private int aof_pending_rewrite;
    private int aof_buffer_length;
    private int aof_rewrite_buffer_length;
    private int aof_pending_bio_fsync;
    private int aof_delayed_fsync;


    public int getLoading() {
        return loading;
    }

    public void setLoading(int loading) {
        this.loading = loading;
    }

    public long getRdb_changes_since_last_save() {
        return rdb_changes_since_last_save;
    }

    public void setRdb_changes_since_last_save(long rdb_changes_since_last_save) {
        this.rdb_changes_since_last_save = rdb_changes_since_last_save;
    }

    public int getRdb_bgsave_in_progress() {
        return rdb_bgsave_in_progress;
    }

    public void setRdb_bgsave_in_progress(int rdb_bgsave_in_progress) {
        this.rdb_bgsave_in_progress = rdb_bgsave_in_progress;
    }

    public long getRdb_last_save_time() {
        return rdb_last_save_time;
    }

    public void setRdb_last_save_time(long rdb_last_save_time) {
        this.rdb_last_save_time = rdb_last_save_time;
    }

    public String getRdb_last_bgsave_status() {
        return rdb_last_bgsave_status;
    }

    public void setRdb_last_bgsave_status(String rdb_last_bgsave_status) {
        this.rdb_last_bgsave_status = rdb_last_bgsave_status;
    }

    public long getRdb_last_bgsave_time_sec() {
        return rdb_last_bgsave_time_sec;
    }

    public void setRdb_last_bgsave_time_sec(long rdb_last_bgsave_time_sec) {
        this.rdb_last_bgsave_time_sec = rdb_last_bgsave_time_sec;
    }

    public long getRdb_current_bgsave_time_sec() {
        return rdb_current_bgsave_time_sec;
    }

    public void setRdb_current_bgsave_time_sec(long rdb_current_bgsave_time_sec) {
        this.rdb_current_bgsave_time_sec = rdb_current_bgsave_time_sec;
    }

    public int getAof_enabled() {
        return aof_enabled;
    }

    public void setAof_enabled(int aof_enabled) {
        this.aof_enabled = aof_enabled;
    }

    public int getAof_rewrite_in_progress() {
        return aof_rewrite_in_progress;
    }

    public void setAof_rewrite_in_progress(int aof_rewrite_in_progress) {
        this.aof_rewrite_in_progress = aof_rewrite_in_progress;
    }

    public int getAof_rewrite_scheduled() {
        return aof_rewrite_scheduled;
    }

    public void setAof_rewrite_scheduled(int aof_rewrite_scheduled) {
        this.aof_rewrite_scheduled = aof_rewrite_scheduled;
    }

    public long getAof_last_rewrite_time_sec() {
        return aof_last_rewrite_time_sec;
    }

    public void setAof_last_rewrite_time_sec(long aof_last_rewrite_time_sec) {
        this.aof_last_rewrite_time_sec = aof_last_rewrite_time_sec;
    }

    public long getAof_current_rewrite_time_sec() {
        return aof_current_rewrite_time_sec;
    }

    public void setAof_current_rewrite_time_sec(long aof_current_rewrite_time_sec) {
        this.aof_current_rewrite_time_sec = aof_current_rewrite_time_sec;
    }

    public String getAof_last_bgrewrite_status() {
        return aof_last_bgrewrite_status;
    }

    public void setAof_last_bgrewrite_status(String aof_last_bgrewrite_status) {
        this.aof_last_bgrewrite_status = aof_last_bgrewrite_status;
    }

    public String getAof_last_write_status() {
        return aof_last_write_status;
    }

    public void setAof_last_write_status(String aof_last_write_status) {
        this.aof_last_write_status = aof_last_write_status;
    }

    public long getAof_current_size() {
        return aof_current_size;
    }

    public void setAof_current_size(long aof_current_size) {
        this.aof_current_size = aof_current_size;
    }

    public long getAof_base_size() {
        return aof_base_size;
    }

    public void setAof_base_size(long aof_base_size) {
        this.aof_base_size = aof_base_size;
    }

    public int getAof_pending_rewrite() {
        return aof_pending_rewrite;
    }

    public void setAof_pending_rewrite(int aof_pending_rewrite) {
        this.aof_pending_rewrite = aof_pending_rewrite;
    }

    public int getAof_buffer_length() {
        return aof_buffer_length;
    }

    public void setAof_buffer_length(int aof_buffer_length) {
        this.aof_buffer_length = aof_buffer_length;
    }

    public int getAof_rewrite_buffer_length() {
        return aof_rewrite_buffer_length;
    }

    public void setAof_rewrite_buffer_length(int aof_rewrite_buffer_length) {
        this.aof_rewrite_buffer_length = aof_rewrite_buffer_length;
    }

    public int getAof_pending_bio_fsync() {
        return aof_pending_bio_fsync;
    }

    public void setAof_pending_bio_fsync(int aof_pending_bio_fsync) {
        this.aof_pending_bio_fsync = aof_pending_bio_fsync;
    }

    public int getAof_delayed_fsync() {
        return aof_delayed_fsync;
    }

    public void setAof_delayed_fsync(int aof_delayed_fsync) {
        this.aof_delayed_fsync = aof_delayed_fsync;
    }
}
