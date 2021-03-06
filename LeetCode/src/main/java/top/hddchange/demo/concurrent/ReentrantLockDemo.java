package top.hddchange.demo.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用重入锁实现 3 个线程 顺序输出123
 *
 * @author huangqiaowei
 * @date 2019-06-23 17:50
 **/
public class ReentrantLockDemo extends Thread {

    private int i;

    public ReentrantLockDemo(int i) {
        this.i = i;
    }

    /**
     * 重入锁，传参true表示 锁为公平的
     */
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                REENTRANT_LOCK.lock();
                System.out.println(i);
            } finally {
                REENTRANT_LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo reenterLockDemo1 = new ReentrantLockDemo(1);
        ReentrantLockDemo reenterLockDemo2 = new ReentrantLockDemo(2);
        ReentrantLockDemo reenterLockDemo3 = new ReentrantLockDemo(3);
        REENTRANT_LOCK.lock();
        reenterLockDemo1.start();
        reenterLockDemo2.start();
        reenterLockDemo3.start();
        REENTRANT_LOCK.unlock();
    }
}
