package myThread.LOCK;/*
    user ji
    data 2019/3/3
    time 5:27 PM
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BooleanLock implements LOCK {
    /*
    false is free,true is the lock have be gotten
     */
    private boolean initValue;
    //定义一个当前锁
    private Thread currentThread;
    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    public BooleanLock() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) {
            //将被阻塞的线程放入阻塞线程队列中
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0)
            lock();
        long hasRemain = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (hasRemain <= 0) {
                throw new TimeOutException("Time out");
            }
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemain =  endTime - System.currentTimeMillis();

        }
        this.initValue = true;
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) {
            this.initValue = false;
            System.out.println(Thread.currentThread().getName() + " has released the monitor");
            this.notifyAll();
        }

    }

    @Override
    public Collection<Thread> getBlockedThread() {
        // 这个时候必须使用不能修改对象
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return 0;
    }
}
