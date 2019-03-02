package myThread.deadLock;/*
    user ji
    data 2019/3/2
    time 9:46 AM
*/

public class DeadLocktest {
    public static void main(String[] args) {
        OtherService os = new OtherService();
        DeadLock deadLock = new DeadLock(os);
        os.setLock(deadLock);
        new Thread("T1") {
            @Override
            public void run() {
                while (true)
                    deadLock.m1();
            }
        }.start();
        new Thread("T2") {
            @Override
            public void run() {
                while (true)
                    os.s2();
            }
        }.start();

    }
}
