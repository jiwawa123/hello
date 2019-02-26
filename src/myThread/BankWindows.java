package myThread;/*
    user ji
    data 2019/2/26
    time 4:21 PM
*/

public class BankWindows {
    public static void main(String[] args) {
        TicketRun tALL = new TicketRun();
        Thread t1 = new Thread(tALL, "one");
        Thread t2 = new Thread(tALL, "two");
        Thread t3 = new Thread(tALL, "three");
        t1.start();
        t2.start();
        t3.start();

    }
}
