package myThread;/*
    user ji
    data 2019/2/27
    time 8:13 PM
*/

public class ThreadCloseForce {
    public static void main(String[] args) {
        ThreadService ts = new ThreadService();
        long start = System.currentTimeMillis();
        ts.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        ts.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
