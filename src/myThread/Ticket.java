package myThread;/*
    user ji
    data 2019/2/26
    time 4:18 PM
*/

public class Ticket extends Thread{
    static  int index = 0;
    @Override
    public void run() {
        while(index<500){
            System.out.println(Thread.currentThread().getName()+" "+(index++));
        }
    }
}
