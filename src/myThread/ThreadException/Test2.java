package myThread.ThreadException;/*
    user ji
    data 2019/3/4
    time 9:03 AM
*/

import java.util.Arrays;

public class Test2 {
    public void test() {
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e->System.out.println(e.getClassName()+":"+e.getMethodName()+":"+e.getLineNumber()));
    }
}
