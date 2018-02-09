package com.dmy.customfeignhystric.Test;

import java.util.EnumSet;

public enum  EnumTest {
    MON("星期一",1), TUE("星期二",2), WED("星期三",3), THU("星期四",4), FRI("星期五",5), SAT("星期六",6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN("星期天",0) {
        @Override
        public boolean isRest() {
            return true;
        }
    };

    private int value;
    private String name;

    private EnumTest(String name,int value) {
        this.value = value;
        this.name=name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRest() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(EnumTest.FRI.name());
    }
}
