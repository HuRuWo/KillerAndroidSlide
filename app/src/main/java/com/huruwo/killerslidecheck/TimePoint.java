package com.huruwo.killerslidecheck;

public class TimePoint {
    private long time;
    private float x;
    private float y;

    public TimePoint(long time, float x, float y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
