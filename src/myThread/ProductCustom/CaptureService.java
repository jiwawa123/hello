package myThread.ProductCustom;/*
    user ji
    data 2019/3/3
    time 4:14 PM
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CaptureService {
    private final static LinkedList<Control> CONTROLS = new LinkedList();
    private final static  int MAX_WORK = 5;
    public static void main(String[] args) {
        List<Thread> work = new ArrayList<>();
        Arrays.asList("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8").stream().
                map(CaptureService::createThread).forEach(t -> {
            t.start();
            work.add(t);
        });
        work.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("ALL thread have finished");
    }

    //根据名字创建名字
    private static Thread createThread(String name) {
        return new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " begin capture data");
            synchronized (CONTROLS) {
                while (CONTROLS.size() > MAX_WORK) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.add(new Control());
            }

            System.out.println(Thread.currentThread().getName() + " is working");
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //每次都删除一个，但是不一定每次都删除的是自己放入的control
            synchronized (CONTROLS){
                System.out.println(Thread.currentThread().getName() + " has finished");
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        }, name);

    }

    public static class Control {

    }
}

