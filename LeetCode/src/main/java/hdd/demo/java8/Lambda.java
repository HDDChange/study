package hdd.demo.java8;

import java.util.function.Consumer;

/**
 * lambda语法
 *
 * @author huangqiaowei
 * @create 2018-12-19 00:35
 **/
public class Lambda {

    /**
     * 传递代码
     *
     * @param consumer
     */
    public static void test(Consumer<String> consumer) {
        consumer.accept("我是参数");
    }

    public static void main(String[] args) {

        test(s -> {
            System.out.println("我是代码块！");
            System.out.println(s);
            System.out.println("我是代码块！");
        });
    }
}
