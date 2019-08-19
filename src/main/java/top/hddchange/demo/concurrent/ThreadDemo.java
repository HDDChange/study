package top.hddchange.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 学习多线程demo
 *
 * @author huangqiaowei
 * @date 2019-06-23 09:53
 **/
public class ThreadDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        executorService.submit(() -> {
            System.out.printf("ok");
        });
        executorService.submit()
    }

}
