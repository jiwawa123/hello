package myThread;/*
    user ji
    data 2019/3/2
    time 9:07 AM
*/

public class SynchronizedRunnable implements Runnable {
    public int index = 1;
    public int max = 500;
    private final Object MONITOR = new Object();

    @Override
    /*同步方法块
     */
    public synchronized void run() {
        while (true) {
            //同步代码块 使用关键字 影响效率，强制将并行变成串行

            if (index > max) {
                break;
            }
            //通过休眠，从而是同步数据出错
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //通过调整判断顺序，从而实现代码不出错

            System.out.println(Thread.currentThread().getName() + " " + (index++));
        }
    }
}
