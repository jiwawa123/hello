package myThread;/*
    user ji
    data 2019/2/27
    time 8:04 PM
*/

public class ThreadService {
    private Thread executeThread;
    private static boolean finished = false;

    public static void main(String[] args) {

    }

    public void execute(Runnable task) {
        executeThread = new Thread(() -> {
            Thread t1 = new Thread(task);
            t1.setDaemon(true);
            t1.start();
            try {
                t1.join();
                finished = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executeThread.start();
    }

    public void shutdown(long mills) {
        long current = System.currentTimeMillis();
        //这个时候应该需要结束线程
        while (!finished) {
            if (System.currentTimeMillis() - current > mills) {
                finished = true;
                //直接打断守护线程，从而打断中间的线程
                System.out.println("强行中断");
                executeThread.interrupt();
                break;
            }
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                e.printStackTrace();
            }

        }
        finished = false;
    }
}
