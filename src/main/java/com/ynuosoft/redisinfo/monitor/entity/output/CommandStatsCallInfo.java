package com.ynuosoft.redisinfo.monitor.entity.output;

/**
 * Created by meng li on 2017/2/10.
 */
public class CommandStatsCallInfo {
    //cmdstat_get:calls=101187,usec=815066,usec_per_call=8.06

    private long calls;
    private long calls_trend;
    private long usec;
    private long usec_trend;
    private float usec_per_call;
    private float user_per_call_trend;

    public long getCalls() {
        return calls;
    }

    public void setCalls(long calls) {
        this.calls = calls;
    }

    public long getUsec() {
        return usec;
    }

    public void setUsec(long usec) {
        this.usec = usec;
    }

    public float getUsec_per_call() {
        return usec_per_call;
    }

    public void setUsec_per_call(float usec_per_call) {
        this.usec_per_call = usec_per_call;
    }

    public long getCalls_trend() {
        return calls_trend;
    }

    public void setCalls_trend(long calls_trend) {
        this.calls_trend = calls_trend;
    }

    public long getUsec_trend() {
        return usec_trend;
    }

    public void setUsec_trend(long usec_trend) {
        this.usec_trend = usec_trend;
    }

    public float getUser_per_call_trend() {
        return user_per_call_trend;
    }

    public void setUser_per_call_trend(float user_per_call_trend) {
        this.user_per_call_trend = user_per_call_trend;
    }
}
