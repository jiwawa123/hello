package myThread;/*
    user ji
    data 2019/3/2
    time 9:07 AM
*/

public class SynchronizedRunnable implements Runnable {
    public int index = 1;
    public int max = 500;
    @Override
    /*同步方法块
     */
    public  void run() {
        while (true) {
            if(!ticket()){
               break;
            }

        }
    }
    //通过同构，是每一个人都能有机会获取入口
    private synchronized  boolean ticket(){
        // getField
        if(index>max)
            return false;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //通过调整判断顺序，从而实现代码不出错

        System.out.println(Thread.currentThread().getName() + " " + (index++));
        return true;
    }
}
