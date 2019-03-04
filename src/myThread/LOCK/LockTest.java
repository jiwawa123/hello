package myThread.LOCK;/*
    user ji
    data 2019/3/3
    time 5:40 PM
*/

import java.sql.SQLOutput;
import java.util.stream.Stream;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1", "T2", "T3").
                forEach(name -> {
                    new Thread(() -> {
                        try {

                            booleanLock.lock(10);
                            System.out.println(Thread.currentThread().getName() + " is getting clock");
                            work();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (LOCK.TimeOutException e) {
                            System.out.println(Thread.currentThread().getName()+"time out");
                        } finally {
                            booleanLock.unlock();
                        }
                    }, name).start();
                });
    }

    private static void work() {
        System.out.println(Thread.currentThread().getName() + " is working");
        try {
            Thread.sleep(10_1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
