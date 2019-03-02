package myThread;/*
    user ji
    data 2019/3/2
    time 9:34 AM
*/

public class SynchronizedStaticTest {
    public static void main(String[] args) {

        SynchronizedStatic sss = new SynchronizedStatic();
        new Thread("T1"){
            @Override
            public void run() {
                sss.m1();
            }
        }.start();
        new Thread("T2"){
            @Override
            public void run() {
                sss.m2();
            }
        }.start();
    }
}
