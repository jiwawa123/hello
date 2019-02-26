package myThread;/*
    user ji
    data 2019/2/26
    time 4:34 PM
*/

public class TicketRun implements Runnable {
    public int index = 1;
    public int max = 50;

    @Override
    public void run() {
        while (index <= max) {
            System.out.println(Thread.currentThread().getName() + " " + (index++));
        }
    }
}
