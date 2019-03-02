package myThread;/*
    user ji
    data 2019/3/2
    time 9:21 AM
*/

public class SynchronizeTestThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("T1"){
            @Override
            public void run() {
                thisLock.method1();
            }
        }.start();
        new Thread("T2"){
            @Override
            public void run() {
                thisLock.method2();
            }
        }.start();
    }

}

class ThisLock {
    public synchronized void method1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void method2(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
