package study.leetcode.day11;

/**
 * 第7天
 *
 * @author huangqiaowei
 * @date 2019-06-18 22:12
 **/
public class Solution {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123 输出: 321  示例 2:
     *
     * 输入: -123 输出: -321 示例 3:
     *
     * 输入: 120 输出: 21
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param x 参数x
     * @return 目标值
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if (sb.length() == 0 && chars[i] == '0') {
                continue;
            } else {
                sb.append(chars[i]);
            }
        }
        int value;
        try {
            if (chars[0] == '-') {
                value = -Integer.valueOf(sb.toString());
            } else {
                if (chars[0] != '0') {

                    value = Integer.valueOf(sb.append(chars[0]).toString());

                } else {
                    value = Integer.valueOf(sb.toString());
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverse(2147483647);
    }
}
