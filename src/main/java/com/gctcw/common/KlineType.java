package com.gctcw.common;

public enum KlineType {
    MIN1(1, 60),
    MIN5(5, 300),
    MIN15(15, 900),
    MIN30(30,1800),
    HOUR1(60, 3600),
    HOUR4(240,  14400),
    DAY(1440, 86400),
    WEEK(10080, 604800),
    ;

    private int type;
    private int second;

    KlineType(int type, int second) {
        this.type = type;
        this.second = second;
    }

    public int getType() {
        return type;
    }

    public int getSecond() {
        return second;
    }
}
