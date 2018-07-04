package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/1/18.
 */
public class MemoryInfo {

//    # Memory
//    used_memory:56838184
//    used_memory_human:54.21M
//    used_memory_rss:70782976
//    used_memory_rss_human:67.50M
//    used_memory_peak:367117128
//    used_memory_peak_human:350.11M
//    total_system_memory:8104226816
//    total_system_memory_human:7.55G
//    used_memory_lua:37888
//    used_memory_lua_human:37.00K
//    maxmemory:4096000000
//    maxmemory_human:3.81G
//    maxmemory_policy:allkeys-lru
//    mem_fragmentation_ratio:1.25
//    mem_allocator:jemalloc-4.0.3


    private long used_memory;
    private long used_memory_trend;
    private long used_memory_rss;
    private long used_memory_rss_trend;
    private long used_memory_peak;
    private long total_system_memory;
    private long maxmemory;
    private float mem_fragmentation_ratio;
    private float mem_fragmentation_ratio_trend;

    public long getUsed_memory() {
        return used_memory;
    }

    public void setUsed_memory(long used_memory) {
        this.used_memory = used_memory;
    }

    public long getUsed_memory_rss() {
        return used_memory_rss;
    }

    public void setUsed_memory_rss(long used_memory_rss) {
        this.used_memory_rss = used_memory_rss;
    }

    public long getUsed_memory_peak() {
        return used_memory_peak;
    }

    public void setUsed_memory_peak(long used_memory_peak) {
        this.used_memory_peak = used_memory_peak;
    }

    public long getTotal_system_memory() {
        return total_system_memory;
    }

    public void setTotal_system_memory(long total_system_memory) {
        this.total_system_memory = total_system_memory;
    }

    public long getMaxmemory() {
        return maxmemory;
    }

    public void setMaxmemory(long maxmemory) {
        this.maxmemory = maxmemory;
    }

    public void setMaxmemory(int maxmemory) {
        this.maxmemory = maxmemory;
    }

    public float getMem_fragmentation_ratio() {
        return mem_fragmentation_ratio;
    }

    public void setMem_fragmentation_ratio(float mem_fragmentation_ratio) {
        this.mem_fragmentation_ratio = mem_fragmentation_ratio;
    }

    public long getUsed_memory_trend() {
        return used_memory_trend;
    }

    public void setUsed_memory_trend(long used_memory_trend) {
        this.used_memory_trend = used_memory_trend;
    }

    public long getUsed_memory_rss_trend() {
        return used_memory_rss_trend;
    }

    public void setUsed_memory_rss_trend(long used_memory_rss_trend) {
        this.used_memory_rss_trend = used_memory_rss_trend;
    }

    public float getMem_fragmentation_ratio_trend() {
        return mem_fragmentation_ratio_trend;
    }

    public void setMem_fragmentation_ratio_trend(float mem_fragmentation_ratio_trend) {
        this.mem_fragmentation_ratio_trend = mem_fragmentation_ratio_trend;
    }
}
