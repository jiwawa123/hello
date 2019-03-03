package myThread.ProductCustom;/*
    user ji
    data 2019/3/2
    time 7:38 PM
*/

import java.util.stream.Stream;

public class ProduceConsumerVersion3 {
    private int i = 0;
    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            if (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("p——>" + (i++));
                isProduce = true;
                LOCK.notify();
            }
        }

    }

    public void consumer() {
        synchronized (LOCK) {
            if (!isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("c——>" + (i));
                LOCK.notify();
                isProduce = false;

            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion3 ps = new ProduceConsumerVersion3();
        Stream.of("p1", "p2").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                while (true)
                    ps.produce();
            }
        }.start());
        Stream.of("c1", "c2").forEach(n -> new Thread(n) {
            @Override
            public void run() {
                while (true)
                    ps.consumer();
            }
        }.start());
    }
}
