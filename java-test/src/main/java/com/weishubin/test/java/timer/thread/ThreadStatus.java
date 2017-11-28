package com.weishubin.test.java.timer.thread;

/**
 * Created by weishubin on 2017/5/3.
 */
public class ThreadStatus {
    static String LOCK = "LOCK";
    static volatile boolean isWaiting = false;
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        TT tt = new TT(t);
        tt.start();

//        Thread.sleep(100000000);
        t.join();
    }
    static class T extends Thread {
        T() {
            super("wait thread");
        }
        @Override
        public void run() {
            while (true) {
//                System.out.println("runing1...");
//                int count = 1000;
//                int sum = 0;
//                for (int i = 0; i < count; i++) {
//                    for (int j = 0; j < count; j++) {
//                        sum += i * j;
//                        System.out.println("running");
//                    }
//                }
//
//                System.out.println("sleeping...");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println("wait...");
                try {
                    isWaiting = true;
                    synchronized (LOCK) {
                        LOCK.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class TT extends Thread {
        T t;
        TT(T t) {
            super("notify thread");
            this.t = t;
        }
        public void run() {
           while (true) {
               if (isWaiting) {
                   isWaiting = false;
                   synchronized (LOCK) {
                       try {
                           Thread.sleep(5000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("notify...");
                       LOCK.notifyAll();
                   }
               }
           }
        }

    }


}
