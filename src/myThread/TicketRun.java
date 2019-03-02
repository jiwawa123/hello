package myThread;/*
    user ji
    data 2019/2/26
    time 4:34 PM
*/

public class TicketRun implements Runnable {
    public int index = 1;
    public int max = 500;
    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            //同步代码块 使用关键字 影响效率，强制将并行变成串行
            synchronized (MONITOR) {
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
}
