package myThread;

public class MyTh implements Runnable {
    public void run(){
        System.out.println("this is a test");
    }

    public static void main(String[] args) {
        new MyTh().run();
    }
}
