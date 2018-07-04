package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/2/10.
 */
public class CommandStatsInfo {

//    # Commandstats
//    cmdstat_get:calls=101187,usec=815066,usec_per_call=8.06
    private CommandStatsCallInfo cmdstat_get;
//    cmdstat_set:calls=7783,usec=310505,usec_per_call=39.90
    private CommandStatsCallInfo cmdstat_set;
//    cmdstat_setex:calls=8452,usec=167247,usec_per_call=19.79
    private CommandStatsCallInfo cmdstat_setex;
//    cmdstat_del:calls=28110,usec=186114,usec_per_call=6.62
    private CommandStatsCallInfo cmdstat_del;
//    cmdstat_exists:calls=9270,usec=42521,usec_per_call=4.59
    private CommandStatsCallInfo cmdstat_exists;
//    cmdstat_rpush:calls=100000,usec=63860,usec_per_call=0.64
    private  CommandStatsCallInfo cmdstat_rpush;
//    cmdstat_lpush:calls=358070,usec=1589102,usec_per_call=4.44
    private  CommandStatsCallInfo cmdstat_lpush;
//    cmdstat_rpop:calls=100490,usec=75474,usec_per_call=0.75
    private  CommandStatsCallInfo cmdstat_rpop;
//    cmdstat_lpop:calls=100002,usec=125880,usec_per_call=1.26
    private  CommandStatsCallInfo cmdstat_lpop;
//    cmdstat_llen:calls=102983,usec=184490,usec_per_call=1.79
    private  CommandStatsCallInfo cmdstat_llen;
//    cmdstat_lindex:calls=991,usec=13685,usec_per_call=13.81
    private CommandStatsCallInfo cmdstat_lindex;
//    cmdstat_lset:calls=11,usec=273,usec_per_call=24.82
    private CommandStatsCallInfo cmdstat_lset;
//    cmdstat_lrange:calls=512576,usec=14088447,usec_per_call=27.49
    private CommandStatsCallInfo cmdstat_lrange;
//    cmdstat_ltrim:calls=2,usec=36,usec_per_call=18.00
    private  CommandStatsCallInfo cmdstat_ltrim;
//    cmdstat_lrem:calls=106573,usec=1271382,usec_per_call=11.93
    private CommandStatsCallInfo cmdstat_lrem;
//    cmdstat_sadd:calls=100000,usec=53779,usec_per_call=0.54
    private CommandStatsCallInfo cmdstat_sadd;
//    cmdstat_spop:calls=100000,usec=25161,usec_per_call=0.25
    private  CommandStatsCallInfo cmdstat_spop;
//    cmdstat_hset:calls=898,usec=21597,usec_per_call=24.05
    private CommandStatsCallInfo cmdstat_hset;
//    cmdstat_hget:calls=1630,usec=17109,usec_per_call=10.50
    private CommandStatsCallInfo cmdstat_hget;
//    cmdstat_hmset:calls=229,usec=5174,usec_per_call=22.59
    private  CommandStatsCallInfo cmdstat_hmset;
//    cmdstat_hdel:calls=26,usec=598,usec_per_call=23.00
    private CommandStatsCallInfo cmdstat_hdel;
//    cmdstat_hlen:calls=216,usec=1401,usec_per_call=6.49
    private CommandStatsCallInfo cmdstat_hlen;
//    cmdstat_hkeys:calls=2,usec=9,usec_per_call=4.50
    private CommandStatsCallInfo cmdstat_hkeys;
//    cmdstat_hvals:calls=1,usec=7,usec_per_call=7.00
    private  CommandStatsCallInfo cmdstat_hvals;
//    cmdstat_hgetall:calls=36007,usec=204499,usec_per_call=5.68
    private CommandStatsCallInfo cmdstat_hgetall;
//    cmdstat_hscan:calls=184,usec=4347,usec_per_call=23.62
    private CommandStatsCallInfo cmdstat_hscan;
//    cmdstat_getset:calls=7,usec=69,usec_per_call=9.86
    private CommandStatsCallInfo cmdstat_getset;
//    cmdstat_select:calls=416,usec=1580,usec_per_call=3.80
    private  CommandStatsCallInfo cmdstat_select;
//    cmdstat_renamenx:calls=1,usec=5,usec_per_call=5.00
    private  CommandStatsCallInfo cmdstat_renamenx;
//    cmdstat_expire:calls=2,usec=9,usec_per_call=4.50
    private  CommandStatsCallInfo cmdstat_expire;
//    cmdstat_expireat:calls=6,usec=44,usec_per_call=7.33
    private CommandStatsCallInfo cmdstat_expireat;
//    cmdstat_keys:calls=345,usec=92996,usec_per_call=269.55
    private  CommandStatsCallInfo cmdstat_keys;
//    cmdstat_scan:calls=161,usec=76001,usec_per_call=472.06
    private  CommandStatsCallInfo cmdstat_scan;
//    cmdstat_dbsize:calls=1,usec=3,usec_per_call=3.00
    private  CommandStatsCallInfo cmdstat_dbsize;
//    cmdstat_ping:calls=255875,usec=174574,usec_per_call=0.68
    private  CommandStatsCallInfo cmdstat_ping;
//    cmdstat_type:calls=16969,usec=73496,usec_per_call=4.33
    private CommandStatsCallInfo cmdstat_type;
//    cmdstat_sync:calls=3,usec=1618,usec_per_call=539.33
    private CommandStatsCallInfo cmdstat_sync;
//    cmdstat_psync:calls=1,usec=693,usec_per_call=693.00
    private CommandStatsCallInfo cmdstat_psync;
//    cmdstat_replconf:calls=8520709,usec=33608874,usec_per_call=3.94
    private CommandStatsCallInfo cmdstat_replconf;
//    cmdstat_info:calls=5387,usec=566093,usec_per_call=105.09
    private CommandStatsCallInfo cmdstat_info;
//    cmdstat_ttl:calls=8800,usec=38821,usec_per_call=4.41
    private CommandStatsCallInfo cmdstat_ttl;
//    cmdstat_role:calls=4,usec=55,usec_per_call=13.75
    private CommandStatsCallInfo cmdstat_role;
//    cmdstat_config:calls=29,usec=1962,usec_per_call=67.66
    private  CommandStatsCallInfo cmdstat_config;
//    cmdstat_subscribe:calls=2,usec=26,usec_per_call=13.00
    private CommandStatsCallInfo cmdstat_subscribe;
//    cmdstat_publish:calls=3,usec=56,usec_per_call=18.67
    private CommandStatsCallInfo cmdstat_publish;
//    cmdstat_pubsub:calls=6,usec=112,usec_per_call=18.67
    private CommandStatsCallInfo cmdstat_pubsub;
//    cmdstat_cluster:calls=9108,usec=1534795,usec_per_call=168.51
    private CommandStatsCallInfo cmdstat_cluster;
//    cmdstat_dump:calls=1,usec=24,usec_per_call=24.00
    private CommandStatsCallInfo cmdstat_dump;
//    cmdstat_client:calls=9,usec=199,usec_per_call=22.11
    private CommandStatsCallInfo cmdstat_client;
//    cmdstat_command:calls=21,usec=28389,usec_per_call=1351.86
    private CommandStatsCallInfo cmdstat_command;

    public CommandStatsCallInfo getCmdstat_get() {
        return cmdstat_get;
    }

    public void setCmdstat_get(CommandStatsCallInfo cmdstat_get) {
        this.cmdstat_get = cmdstat_get;
    }

    public CommandStatsCallInfo getCmdstat_set() {
        return cmdstat_set;
    }

    public void setCmdstat_set(CommandStatsCallInfo cmdstat_set) {
        this.cmdstat_set = cmdstat_set;
    }

    public CommandStatsCallInfo getCmdstat_setex() {
        return cmdstat_setex;
    }

    public void setCmdstat_setex(CommandStatsCallInfo cmdstat_setex) {
        this.cmdstat_setex = cmdstat_setex;
    }

    public CommandStatsCallInfo getCmdstat_del() {
        return cmdstat_del;
    }

    public void setCmdstat_del(CommandStatsCallInfo cmdstat_del) {
        this.cmdstat_del = cmdstat_del;
    }

    public CommandStatsCallInfo getCmdstat_exists() {
        return cmdstat_exists;
    }

    public void setCmdstat_exists(CommandStatsCallInfo cmdstat_exists) {
        this.cmdstat_exists = cmdstat_exists;
    }

    public CommandStatsCallInfo getCmdstat_rpush() {
        return cmdstat_rpush;
    }

    public void setCmdstat_rpush(CommandStatsCallInfo cmdstat_rpush) {
        this.cmdstat_rpush = cmdstat_rpush;
    }

    public CommandStatsCallInfo getCmdstat_lpush() {
        return cmdstat_lpush;
    }

    public void setCmdstat_lpush(CommandStatsCallInfo cmdstat_lpush) {
        this.cmdstat_lpush = cmdstat_lpush;
    }

    public CommandStatsCallInfo getCmdstat_rpop() {
        return cmdstat_rpop;
    }

    public void setCmdstat_rpop(CommandStatsCallInfo cmdstat_rpop) {
        this.cmdstat_rpop = cmdstat_rpop;
    }

    public CommandStatsCallInfo getCmdstat_lpop() {
        return cmdstat_lpop;
    }

    public void setCmdstat_lpop(CommandStatsCallInfo cmdstat_lpop) {
        this.cmdstat_lpop = cmdstat_lpop;
    }

    public CommandStatsCallInfo getCmdstat_llen() {
        return cmdstat_llen;
    }

    public void setCmdstat_llen(CommandStatsCallInfo cmdstat_llen) {
        this.cmdstat_llen = cmdstat_llen;
    }

    public CommandStatsCallInfo getCmdstat_lindex() {
        return cmdstat_lindex;
    }

    public void setCmdstat_lindex(CommandStatsCallInfo cmdstat_lindex) {
        this.cmdstat_lindex = cmdstat_lindex;
    }

    public CommandStatsCallInfo getCmdstat_lset() {
        return cmdstat_lset;
    }

    public void setCmdstat_lset(CommandStatsCallInfo cmdstat_lset) {
        this.cmdstat_lset = cmdstat_lset;
    }

    public CommandStatsCallInfo getCmdstat_lrange() {
        return cmdstat_lrange;
    }

    public void setCmdstat_lrange(CommandStatsCallInfo cmdstat_lrange) {
        this.cmdstat_lrange = cmdstat_lrange;
    }

    public CommandStatsCallInfo getCmdstat_ltrim() {
        return cmdstat_ltrim;
    }

    public void setCmdstat_ltrim(CommandStatsCallInfo cmdstat_ltrim) {
        this.cmdstat_ltrim = cmdstat_ltrim;
    }

    public CommandStatsCallInfo getCmdstat_lrem() {
        return cmdstat_lrem;
    }

    public void setCmdstat_lrem(CommandStatsCallInfo cmdstat_lrem) {
        this.cmdstat_lrem = cmdstat_lrem;
    }

    public CommandStatsCallInfo getCmdstat_sadd() {
        return cmdstat_sadd;
    }

    public void setCmdstat_sadd(CommandStatsCallInfo cmdstat_sadd) {
        this.cmdstat_sadd = cmdstat_sadd;
    }

    public CommandStatsCallInfo getCmdstat_spop() {
        return cmdstat_spop;
    }

    public void setCmdstat_spop(CommandStatsCallInfo cmdstat_spop) {
        this.cmdstat_spop = cmdstat_spop;
    }

    public CommandStatsCallInfo getCmdstat_hset() {
        return cmdstat_hset;
    }

    public void setCmdstat_hset(CommandStatsCallInfo cmdstat_hset) {
        this.cmdstat_hset = cmdstat_hset;
    }

    public CommandStatsCallInfo getCmdstat_hget() {
        return cmdstat_hget;
    }

    public void setCmdstat_hget(CommandStatsCallInfo cmdstat_hget) {
        this.cmdstat_hget = cmdstat_hget;
    }

    public CommandStatsCallInfo getCmdstat_hmset() {
        return cmdstat_hmset;
    }

    public void setCmdstat_hmset(CommandStatsCallInfo cmdstat_hmset) {
        this.cmdstat_hmset = cmdstat_hmset;
    }

    public CommandStatsCallInfo getCmdstat_hdel() {
        return cmdstat_hdel;
    }

    public void setCmdstat_hdel(CommandStatsCallInfo cmdstat_hdel) {
        this.cmdstat_hdel = cmdstat_hdel;
    }

    public CommandStatsCallInfo getCmdstat_hlen() {
        return cmdstat_hlen;
    }

    public void setCmdstat_hlen(CommandStatsCallInfo cmdstat_hlen) {
        this.cmdstat_hlen = cmdstat_hlen;
    }

    public CommandStatsCallInfo getCmdstat_hkeys() {
        return cmdstat_hkeys;
    }

    public void setCmdstat_hkeys(CommandStatsCallInfo cmdstat_hkeys) {
        this.cmdstat_hkeys = cmdstat_hkeys;
    }

    public CommandStatsCallInfo getCmdstat_hvals() {
        return cmdstat_hvals;
    }

    public void setCmdstat_hvals(CommandStatsCallInfo cmdstat_hvals) {
        this.cmdstat_hvals = cmdstat_hvals;
    }

    public CommandStatsCallInfo getCmdstat_hgetall() {
        return cmdstat_hgetall;
    }

    public void setCmdstat_hgetall(CommandStatsCallInfo cmdstat_hgetall) {
        this.cmdstat_hgetall = cmdstat_hgetall;
    }

    public CommandStatsCallInfo getCmdstat_hscan() {
        return cmdstat_hscan;
    }

    public void setCmdstat_hscan(CommandStatsCallInfo cmdstat_hscan) {
        this.cmdstat_hscan = cmdstat_hscan;
    }

    public CommandStatsCallInfo getCmdstat_getset() {
        return cmdstat_getset;
    }

    public void setCmdstat_getset(CommandStatsCallInfo cmdstat_getset) {
        this.cmdstat_getset = cmdstat_getset;
    }

    public CommandStatsCallInfo getCmdstat_select() {
        return cmdstat_select;
    }

    public void setCmdstat_select(CommandStatsCallInfo cmdstat_select) {
        this.cmdstat_select = cmdstat_select;
    }

    public CommandStatsCallInfo getCmdstat_renamenx() {
        return cmdstat_renamenx;
    }

    public void setCmdstat_renamenx(CommandStatsCallInfo cmdstat_renamenx) {
        this.cmdstat_renamenx = cmdstat_renamenx;
    }

    public CommandStatsCallInfo getCmdstat_expire() {
        return cmdstat_expire;
    }

    public void setCmdstat_expire(CommandStatsCallInfo cmdstat_expire) {
        this.cmdstat_expire = cmdstat_expire;
    }

    public CommandStatsCallInfo getCmdstat_expireat() {
        return cmdstat_expireat;
    }

    public void setCmdstat_expireat(CommandStatsCallInfo cmdstat_expireat) {
        this.cmdstat_expireat = cmdstat_expireat;
    }

    public CommandStatsCallInfo getCmdstat_keys() {
        return cmdstat_keys;
    }

    public void setCmdstat_keys(CommandStatsCallInfo cmdstat_keys) {
        this.cmdstat_keys = cmdstat_keys;
    }

    public CommandStatsCallInfo getCmdstat_scan() {
        return cmdstat_scan;
    }

    public void setCmdstat_scan(CommandStatsCallInfo cmdstat_scan) {
        this.cmdstat_scan = cmdstat_scan;
    }

    public CommandStatsCallInfo getCmdstat_dbsize() {
        return cmdstat_dbsize;
    }

    public void setCmdstat_dbsize(CommandStatsCallInfo cmdstat_dbsize) {
        this.cmdstat_dbsize = cmdstat_dbsize;
    }

    public CommandStatsCallInfo getCmdstat_ping() {
        return cmdstat_ping;
    }

    public void setCmdstat_ping(CommandStatsCallInfo cmdstat_ping) {
        this.cmdstat_ping = cmdstat_ping;
    }

    public CommandStatsCallInfo getCmdstat_type() {
        return cmdstat_type;
    }

    public void setCmdstat_type(CommandStatsCallInfo cmdstat_type) {
        this.cmdstat_type = cmdstat_type;
    }

    public CommandStatsCallInfo getCmdstat_sync() {
        return cmdstat_sync;
    }

    public void setCmdstat_sync(CommandStatsCallInfo cmdstat_sync) {
        this.cmdstat_sync = cmdstat_sync;
    }

    public CommandStatsCallInfo getCmdstat_psync() {
        return cmdstat_psync;
    }

    public void setCmdstat_psync(CommandStatsCallInfo cmdstat_psync) {
        this.cmdstat_psync = cmdstat_psync;
    }

    public CommandStatsCallInfo getCmdstat_replconf() {
        return cmdstat_replconf;
    }

    public void setCmdstat_replconf(CommandStatsCallInfo cmdstat_replconf) {
        this.cmdstat_replconf = cmdstat_replconf;
    }

    public CommandStatsCallInfo getCmdstat_info() {
        return cmdstat_info;
    }

    public void setCmdstat_info(CommandStatsCallInfo cmdstat_info) {
        this.cmdstat_info = cmdstat_info;
    }

    public CommandStatsCallInfo getCmdstat_ttl() {
        return cmdstat_ttl;
    }

    public void setCmdstat_ttl(CommandStatsCallInfo cmdstat_ttl) {
        this.cmdstat_ttl = cmdstat_ttl;
    }

    public CommandStatsCallInfo getCmdstat_role() {
        return cmdstat_role;
    }

    public void setCmdstat_role(CommandStatsCallInfo cmdstat_role) {
        this.cmdstat_role = cmdstat_role;
    }

    public CommandStatsCallInfo getCmdstat_config() {
        return cmdstat_config;
    }

    public void setCmdstat_config(CommandStatsCallInfo cmdstat_config) {
        this.cmdstat_config = cmdstat_config;
    }

    public CommandStatsCallInfo getCmdstat_subscribe() {
        return cmdstat_subscribe;
    }

    public void setCmdstat_subscribe(CommandStatsCallInfo cmdstat_subscribe) {
        this.cmdstat_subscribe = cmdstat_subscribe;
    }

    public CommandStatsCallInfo getCmdstat_publish() {
        return cmdstat_publish;
    }

    public void setCmdstat_publish(CommandStatsCallInfo cmdstat_publish) {
        this.cmdstat_publish = cmdstat_publish;
    }

    public CommandStatsCallInfo getCmdstat_pubsub() {
        return cmdstat_pubsub;
    }

    public void setCmdstat_pubsub(CommandStatsCallInfo cmdstat_pubsub) {
        this.cmdstat_pubsub = cmdstat_pubsub;
    }

    public CommandStatsCallInfo getCmdstat_cluster() {
        return cmdstat_cluster;
    }

    public void setCmdstat_cluster(CommandStatsCallInfo cmdstat_cluster) {
        this.cmdstat_cluster = cmdstat_cluster;
    }

    public CommandStatsCallInfo getCmdstat_dump() {
        return cmdstat_dump;
    }

    public void setCmdstat_dump(CommandStatsCallInfo cmdstat_dump) {
        this.cmdstat_dump = cmdstat_dump;
    }

    public CommandStatsCallInfo getCmdstat_client() {
        return cmdstat_client;
    }

    public void setCmdstat_client(CommandStatsCallInfo cmdstat_client) {
        this.cmdstat_client = cmdstat_client;
    }

    public CommandStatsCallInfo getCmdstat_command() {
        return cmdstat_command;
    }

    public void setCmdstat_command(CommandStatsCallInfo cmdstat_command) {
        this.cmdstat_command = cmdstat_command;
    }
}
