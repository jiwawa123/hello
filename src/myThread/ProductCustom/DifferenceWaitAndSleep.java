package myThread.ProductCustom;/*
    user ji
    data 2019/3/2
    time 8:10 PM
    wait与sleep之间的区别
*/

import java.util.stream.Stream;

public class DifferenceWaitAndSleep {
    public static final Object LOCK = new Object();

    public static void main(String[] args) {
        Stream.of("T1", "T2").forEach(n -> {
            new Thread(n) {
                @Override
                public void run() {
                    m2();
                }
            }.start();
        });
    }

    public static void m1() {
        try {
            System.out.println(Thread.currentThread().getName() + "enter m1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m2() {
        synchronized (LOCK) {
            try {
                System.out.println(Thread.currentThread().getName() + "enter m2");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
