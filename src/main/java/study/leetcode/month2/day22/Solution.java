package study.leetcode.month2.day22;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-07-26 20:18
 **/
public class Solution {

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     * <p>
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     * <p>
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     * 说明:
     * <p>
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/powx-n
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x 底数
     * @param n 幂
     * @return 结果
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        Map<Integer, Double> map = new HashMap<>();
        double result = 1;
        int temp = 1;
        while (n <= 0) {

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(9).length());
    }
}
