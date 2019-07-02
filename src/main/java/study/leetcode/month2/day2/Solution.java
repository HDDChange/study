package study.leetcode.month2.day2;

/**
 * @author huangqiaowei
 * @date 2019-07-02 15:35
 **/
public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE) {
            return divisor == dividend ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean flag1 = (dividend >>> 31) != (divisor >>> 31);
        boolean flag2 = false;
        if (dividend == Integer.MIN_VALUE) {
            flag2 = true;
            dividend += Math.abs(divisor);
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ret = 0;
        for (int i = 31; i >= 0; i--) {
            if ((dividend >> i) >= divisor) {
                ret += 1 << i;
                dividend -= divisor << i;
            }
        }
        ret = flag2 ? ret + 1 : ret;
        return flag1 ? -ret : ret;
    }

}
