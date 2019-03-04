package myThread.ThreadException;/*
    user ji
    data 2019/3/4
    time 8:56 AM
*/

public class ThreadException1 {
    public static void main(String[] args) {
//        Thread t = new Thread(()->{
////            //此时只能在控制台查看异常情况
////            int a = 0;
////            System.out.println(5/a);
////            System.out.println("hello");
////        });
////        //使用内置的方法输出异常错误
////        t.setUncaughtExceptionHandler((thread,e)->{
////            System.out.println(e);
////            System.out.println(thread);
////        });
////        t.start();
        new Test1().test();
    }
}
