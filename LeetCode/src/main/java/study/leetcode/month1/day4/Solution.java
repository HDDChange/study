package study.leetcode.month1.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 第4天刷题
 *
 * @author huangqiaowei
 * @date 2019-06-05 19:12
 **/
public class Solution {

    /**
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     *
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     *
     *
     *
     * 示例 1：
     *
     * 输入：A = [1,2,0,0], K = 34 输出：[1,2,3,4] 解释：1200 + 34 = 1234
     *
     *
     * @param A 给定非负整数 X 的数组形式 A
     * @param K 给定非负整数
     * @return 返回整数 X+K 的数组形式。
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        IntStream chars = Integer.valueOf(K).toString().chars();
        int[] ints = chars.map(operand -> operand - '0').toArray();
        return twoAdd(A, ints);
    }

    /**
     * 两个数组相加
     *
     * @param A 给定非负整数 X 的数组形式 A
     * @param B 给定非负整数的数组形式 B
     * @return 返回A、B 的数组形式。
     */
    public List<Integer> twoAdd(int[] A, int[] B) {

        int[] test = new int[A.length > B.length ? A.length : B.length];
        int zero = Math.abs(A.length - B.length);
        int start = 0;
        // 填充0 使两个数组length相等
        if (A.length > B.length) {
            for (int i = 0; i < test.length; i++) {
                if (zero-- > 0) {
                    test[i] = 0;
                } else {
                    test[i] = B[start++];
                }
            }
            return two(test, A);
        } else if (A.length < B.length) {
            for (int i = 0; i < test.length; i++) {
                if (zero-- > 0) {
                    test[i] = 0;
                } else {
                    test[i] = A[start++];
                }
            }
            return two(test, B);
        }
        return two(A, B);

    }

    public List<Integer> two(int[] a, int[] b) {
        Boolean temp = false;
        int length = a.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= a.length; i++) {
            result.add(0);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            int demo;
            if (temp) {
                demo = a[i] + b[i] + 1;
            } else {
                demo = a[i] + b[i];
            }
            temp = demo >= 10;
            if (temp) {
                result.set(length--, demo - 10);
            } else {
                result.set(length--, demo);
            }

        }
        if (temp) {
            result.set(0, 1);
        } else {
            result.remove(0);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 1, 2, 0, 0 };
        System.out.println(solution.addToArrayForm(A, 34).toString());
    }

}
