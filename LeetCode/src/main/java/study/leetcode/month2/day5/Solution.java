package study.leetcode.month2.day5;

/**
 * @author huangqiaowei
 * @date 2019-07-04 23:37
 **/
public class Solution {

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * <p>
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-and-say
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n 给定层数
     * @return 结果值
     */
    public String countAndSay(int n) {
        String temp = "1";
        for (int i = 1; i < n; i++) {
            temp = getSay(temp);
        }
        return temp;
    }

    public String getSay(String s) {
        StringBuffer sb = new StringBuffer();
        int size = 0;
        char temp = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (temp == s.charAt(i)) {
                size++;
            } else {
                sb.append(size).append(temp);
                temp = s.charAt(i);
                size = 1;

            }
            if (i == s.length() - 1) {
                sb.append(size).append(temp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(5);
        System.out.printf(s);
    }
}
