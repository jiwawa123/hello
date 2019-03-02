package myThread.deadLock;/*
    user ji
    data 2019/3/2
    time 9:39 AM
*/

public class DeadLock {
    private OtherService otherService;
    private final Object obj = new Object();

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;

    }

    public void m1() {
        synchronized (obj) {
            System.out.println("m1");
            otherService.s1();
        }
    }

    public void m2() {
        synchronized (obj) {
            System.out.println("m2");
        }

    }
}
