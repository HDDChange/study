package study.leetcode.concurrent;

/**
 * @author huangqiaowei
 * @date 2019-07-16 18:36
 **/
public class Foo {

    public Foo() {

    }

    public static java.util.concurrent.atomic.AtomicInteger temp = new java.util.concurrent.atomic.AtomicInteger(1);

    public void first(Runnable printFirst) throws InterruptedException {
        while (temp.get() != 1) {
        }
        printFirst.run();
        temp.compareAndSet(1, 2);

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (temp.get() != 2) {
        }
        printSecond.run();
        temp.compareAndSet(2, 3);

    }

    public void third(Runnable printThird) throws InterruptedException {
        while (temp.get() != 3) {
        }
        printThird.run();

    }

    public static void main(String[] args) {
        Foo foo = new Foo();
    }
}
