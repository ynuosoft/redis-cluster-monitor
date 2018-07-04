package com.ynuosoft.redisinfo.monitor.entity.input;


import redis.clients.jedis.JedisCluster;

/**
 * Created by meng li on 2017/2/22.
 */
public class CacheObj {

    public  CacheObj(long cacheTime1,JedisCluster jedisCluste1r)
    {
        this.cacheTime=cacheTime1;
        this.jedisCluster=jedisCluste1r;
    }
    //缓存过期绝对时间
    private long cacheTime;
    private JedisCluster jedisCluster;

    public long getCacheTime() {
        return cacheTime;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }


}
