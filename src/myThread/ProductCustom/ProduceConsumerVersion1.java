package myThread.ProductCustom;/*
    user ji
    data 2019/3/2
    time 5:58 PM
*/

public class ProduceConsumerVersion1 {
    private int i = 1;

    final private Object LOCK = new Object();

    private void produce() {
        synchronized (LOCK) {
            System.out.println("p——>" + (i++));
        }
    }

    private void consumer() {
        synchronized (LOCK) {
            System.out.println("c——>" + (i));
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion1 pc = new ProduceConsumerVersion1();
        //定义两个线程，一个用来消费，一个用来生产；
        new Thread("t1") {
            @Override
            public void run() {
                while (true)
                    pc.produce();
            }
        }.start();
        new Thread("t1") {
            @Override
            public void run() {
                while (true)
                    pc.consumer();
            }
        }.start();
    }
}
