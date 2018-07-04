package com.ynuosoft.redisinfo.monitor.entity.input;

import java.util.ArrayList;

/**
 * Created by meng li on 2017/1/16.
 */
public class ClusterConf {

    //集群名称
    private String name;
    //集群redis实例 密码
    private String pwd;
    /**
     * 自定义缓存时间
     */
    private int cacheMin=30;

    public int getCacheMin() {
        return cacheMin;
    }

    public void setCacheMin(int cacheMin) {
        this.cacheMin = cacheMin;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //集群节点,结构 ip:port
    private ArrayList<NodeConf> nodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<NodeConf> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<NodeConf> nodes) {
        this.nodes = nodes;
    }
}
