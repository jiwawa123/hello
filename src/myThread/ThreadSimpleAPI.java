package myThread;/*
    user ji
    data 2019/2/27
    time 6:55 PM
*/

import java.util.Optional;

public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            Optional.of("hello").ifPresent(System.out::println);
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        },"t1");
        Optional.of(t1.getName()).ifPresent(System.out::println);
        Optional.of(t1.getId()).ifPresent(System.out::println);
        Optional.of(t1.getPriority()).ifPresent(System.out::println);

    }
}
