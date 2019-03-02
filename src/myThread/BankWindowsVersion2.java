package myThread;/*
    user ji
    data 2019/3/2
    time 9:08 AM
*/

public class BankWindowsVersion2 {
    public static void main(String[] args) {
        SynchronizedRunnable tALL = new SynchronizedRunnable();
        Thread t1 = new Thread(tALL, "one");
        Thread t2 = new Thread(tALL, "two");
        Thread t3 = new Thread(tALL, "three");
        t1.start();
        t2.start();
        t3.start();
    }
}
