package myThread.LOCK;/*
    user ji
    data 2019/3/3
    time 4:42 PM
*/

import java.util.Collection;
import java.util.Collections;

public interface LOCK {
    class TimeOutException extends Exception {
        public TimeOutException(String massage) {
            super(massage);
        }
    }

    //允许中断
    void lock() throws InterruptedException;

    //超时就中断
    void lock(long mills) throws InterruptedException, TimeOutException;

    //释放锁
    void unlock();

    //或者
    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
