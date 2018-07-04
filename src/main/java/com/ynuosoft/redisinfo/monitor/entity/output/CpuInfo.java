package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class CpuInfo {
    //    # CPU
//    used_cpu_sys:20010.03
//    used_cpu_user:19532.58
//    used_cpu_sys_children:387.63
//    used_cpu_user_children:1840.69
    private float used_cpu_sys;
    private float used_cpu_user;
    private float used_cpu_sys_children;
    private float used_cpu_user_children;

    public float getUsed_cpu_sys() {
        return used_cpu_sys;
    }

    public void setUsed_cpu_sys(float used_cpu_sys) {
        this.used_cpu_sys = used_cpu_sys;
    }

    public float getUsed_cpu_user() {
        return used_cpu_user;
    }

    public void setUsed_cpu_user(float used_cpu_user) {
        this.used_cpu_user = used_cpu_user;
    }

    public float getUsed_cpu_sys_children() {
        return used_cpu_sys_children;
    }

    public void setUsed_cpu_sys_children(float used_cpu_sys_children) {
        this.used_cpu_sys_children = used_cpu_sys_children;
    }

    public float getUsed_cpu_user_children() {
        return used_cpu_user_children;
    }

    public void setUsed_cpu_user_children(float used_cpu_user_children) {
        this.used_cpu_user_children = used_cpu_user_children;
    }
}
