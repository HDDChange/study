package hdd.demo.java8.util;

import java.util.Random;

/**
 * demo
 *
 * @author huangqiaowei
 * @create 2018-12-03 14:46
 **/
public class DemoUtil {

    /**
     * 生成 [min，max]的随机数
     *
     * @param min
     * @param max
     * @return
     */
    public static int random(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
