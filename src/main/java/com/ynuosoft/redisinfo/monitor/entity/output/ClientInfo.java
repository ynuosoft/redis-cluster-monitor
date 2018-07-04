package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class ClientInfo {

//# Clients
//    connected_clients:1
//    client_longest_output_list:0
//    client_biggest_input_buf:0
//    blocked_clients:0


//    clients 部分记录了已连接客户端的信息，它包含以下域：
//
    private int connected_clients;
    private int client_longest_output_list;
    private int client_biggest_input_buf;
    private int blocked_clients;

    public int getConnected_clients() {
        return connected_clients;
    }
    public void setConnected_clients(int connected_clients) {
        this.connected_clients = connected_clients;
    }
    public int getClient_longest_output_list() {
        return client_longest_output_list;
    }
    public void setClient_longest_output_list(int client_longest_output_list) {
        this.client_longest_output_list = client_longest_output_list;
    }

    public int getClient_biggest_input_buf() {
        return client_biggest_input_buf;
    }

    public void setClient_biggest_input_buf(int client_biggest_input_buf) {
        this.client_biggest_input_buf = client_biggest_input_buf;
    }

    public int getBlocked_clients() {
        return blocked_clients;
    }
    public void setBlocked_clients(int blocked_clients) {
        this.blocked_clients = blocked_clients;
    }
}
