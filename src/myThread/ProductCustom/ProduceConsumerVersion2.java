package myThread.ProductCustom;/*
    user ji
    data 2019/3/2
    time 6:05 PM
*/

public class ProduceConsumerVersion2 {
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
        ProduceConsumerVersion2 ps = new ProduceConsumerVersion2();
        new Thread("p") {
            @Override
            public void run() {
                while (true)
                    ps.produce();
            }
        }.start();
        new Thread("c") {
            @Override
            public void run() {
                while (true)
                    ps.consumer();
            }
        }.start();
    }
}
