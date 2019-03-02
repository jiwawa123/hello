package myThread.deadLock;/*
    user ji
    data 2019/3/2
    time 9:38 AM
*/

public class OtherService {
    private final Object obj = new Object();
    private DeadLock deadLock;

    public void s1() {
        synchronized (obj) {
            System.out.println("s1");
        }
    }
    public void s2() {
        synchronized (obj) {
           deadLock.m2();
        }
    }

    public void setLock(DeadLock obj) {
        this.deadLock = obj;
        return;
    }
}
