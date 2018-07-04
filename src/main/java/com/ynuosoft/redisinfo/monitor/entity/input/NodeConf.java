package com.ynuosoft.redisinfo.monitor.entity.input;

/**
 * Created by meng li on 2017/1/17.
 * 节点配置
 */
public class NodeConf {
    private String host;
    private int port;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
