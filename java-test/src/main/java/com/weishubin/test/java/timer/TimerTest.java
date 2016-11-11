package com.weishubin.test.java.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author weishubin
 */
public class TimerTest {
    public static void main(String[] args) throws InterruptedException {
        Timer  timer = new Timer("SyncSubcategory", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("task");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);

        Thread.sleep(5000);
        timer.cancel();
    }
}
