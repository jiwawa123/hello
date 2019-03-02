package myThread;/*
    user ji
    data 2019/3/2
    time 9:32 AM
*/

public class SynchronizedStatic {
    static {
        synchronized (SynchronizedStatic.class){
            System.out.println("static "+Thread.currentThread().getName());
            try{
                Thread.sleep(10_000L);
            }catch (Exception e){

            }
        }
    }
    public synchronized static  void m1(){
        System.out.println("m1 "+Thread.currentThread().getName());
        try{
            Thread.sleep(10_000L);
        }catch (Exception e){

        }
    }
    public synchronized static  void m2(){
        System.out.println("m1 "+Thread.currentThread().getName());
        try{
            Thread.sleep(10_000L);
        }catch (Exception e){

        }
    }
}
