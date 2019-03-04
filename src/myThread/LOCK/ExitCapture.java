package myThread.LOCK;/*
    user ji
    data 2019/3/4
    time 8:27 AM
*/

public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The appliaction will be exit");
            notifyAndRelease();
        }));
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1);
                System.out.println("I am working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            i++;
//            if (i > 5) {
//                throw new RuntimeException("time out");
//            }
        }
    }
    private static void notifyAndRelease(){
        System.out.println("notify to the admin");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("will release the file socket");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
