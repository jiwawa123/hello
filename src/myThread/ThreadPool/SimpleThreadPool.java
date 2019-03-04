package myThread.ThreadPool;/*
    user ji
    data 2019/3/4
    time 10:00 AM
*/

import myThread.deadLock.DeadLock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {
    /*
    1.任务队列
    2.拒绝策略【抛出异常，直接丢弃，阻塞，临时队列】
    3.初始化
    4.active
    5.max
    min<active<max
    
     */
    private final int size;
    private final static int DEFAULT_SIZE = 10;
    private static volatile int seq = 0;
    private final static String THREAD_PREFIX = "SIMPLE_THREAD_POOL";
    //定义一个线程组
    private final static ThreadGroup GROUP = new ThreadGroup("POOL_GROUP");
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private final static List<WorkTask> workList = new ArrayList<>();

    public SimpleThreadPool() {
        this.size = DEFAULT_SIZE;
        init();
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void createWorkTask() {
        WorkTask task = new WorkTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        workList.add(task);
    }
    public void shutdown() throws InterruptedException {
        //判断里面是不是为空，如果为空就sleep一段时间
        while(TASK_QUEUE.isEmpty()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int initVal = workList.size();
        //判断工作队列里面是不是还有线程如果没有就直接关闭
        while(initVal>0){
            for (WorkTask task:workList
                 ) {
                if(task.getTaskState()==TaskState.BLOCKED){
                    task.interrupt();
                    task.close();
                    initVal--;
                }else{
                    Thread.sleep(10);
                }
            }
        }
        System.out.println("shutdown");
    }
    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    public void submit(Runnable runnable) {
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    private enum TaskState {FREE, RUNNING, BLOCKED, DEAD}

    private static class WorkTask extends Thread {
        private volatile TaskState taskState = TaskState.FREE;

        public WorkTask(ThreadGroup threadGroup, String name) {
            super(threadGroup, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();

                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool();
        for (int i = 0; i < 40; i++) {
            threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "  started");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +" done");
            });
        }
        threadPool.shutdown();
    }
}

