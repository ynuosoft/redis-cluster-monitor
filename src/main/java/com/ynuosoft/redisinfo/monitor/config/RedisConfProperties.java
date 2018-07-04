package com.ynuosoft.redisinfo.monitor.config;

import com.ynuosoft.redisinfo.monitor.entity.input.ClusterConf;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


/**
 * Created by meng li on 2017/1/16.
 */

@Component
@ConfigurationProperties(prefix = "ynuosoft.redis.monitor")
public class RedisConfProperties {

    private ArrayList<ClusterConf> clusterConfs = new ArrayList<>();

    public ArrayList<ClusterConf> getClusterConfs() {
        return clusterConfs;
    }

    public void setClusterConfs(ArrayList<ClusterConf> clusterConfs) {
        this.clusterConfs = clusterConfs;
    }
}
