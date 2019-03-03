package myThread.ProductCustom;/*
    user ji
    data 2019/3/2
    time 7:46 PM
*/

import java.util.stream.Stream;

public class ProduceConsumerVersion4 {
    private int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            while (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("p——>" + (i++));
            LOCK.notifyAll();
            isProduce = true;


        }

    }

    public void consumer() {
        synchronized (LOCK) {
            while (!isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("c——>" + (i));
            LOCK.notifyAll();
            isProduce = false;


        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion4 ps = new ProduceConsumerVersion4();
        Stream.of("p1", "p2").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                while (true) {
                    ps.produce();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start());
        Stream.of("c1", "c2").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                while (true) {
                    ps.consumer();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }.start());
    }
}