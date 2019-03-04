package myThread.ThreadGroup;/*
    user ji
    data 2019/3/4
    time 9:25 AM
*/

public class ThreadGroupCreate {
    public static void main(String[] args) {
        //use the name
        ThreadGroup tg1 = new ThreadGroup("tg1");
        Thread t1 = new Thread(tg1,"t1"){
            @Override
            public void run() {
                try {
                    System.out.println(getThreadGroup().getName());
                    System.out.println(getThreadGroup().getParent().getName());
                    System.out.println(getThreadGroup().getParent().activeCount());
                    Thread.sleep(10_1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        //use the parent and group name
        ThreadGroup tg2 = new ThreadGroup(tg1,"tg2");
        System.out.println(tg2.getParent().getName());
    }
}
