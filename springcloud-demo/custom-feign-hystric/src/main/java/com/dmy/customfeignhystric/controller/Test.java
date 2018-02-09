package com.dmy.customfeignhystric.controller;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("延时5秒，完成了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
