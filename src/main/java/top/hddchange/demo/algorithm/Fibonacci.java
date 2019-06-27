package top.hddchange.demo.algorithm;

import java.util.Arrays;

/**
 * 斐波那契数列
 *
 * @author huangqiaowei
 * @date 2019-06-27 17:54
 **/
public class Fibonacci {

    public int[] initFibonacci(int n) {
        int[] result = new int[n];
        init(result, 0);
        return result;
    }

    /**
     * 斐波那契数列: 第n个数 是 它前两个数的和
     * 
     * @param result 结果
     * @param n n位
     */
    public void init(int[] result, int n) {
        if (n == 0 || n == 1) {
            result[n] = 1;
            init(result, n + 1);
        } else if (n >= 2 && n < result.length) {
            result[n] = result[n - 1] + result[n - 2];
            init(result, n + 1);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int[] ints = fibonacci.initFibonacci(5);
        System.out.println(Arrays.toString(ints));
    }
}
