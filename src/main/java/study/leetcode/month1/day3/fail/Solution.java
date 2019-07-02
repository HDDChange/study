package study.leetcode.month1.day3.fail;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 第三天
 *
 * @author huangqiaowei
 * @create 2019-04-19 18:19
 **/
public class Solution {

    /**
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
     *
     * 示例 1:
     *
     * 输入: s = "aaabb", k = 3
     *
     * 输出: 3
     *
     * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。 示例 2:
     *
     * 输入: s = "ababbc", k = 2
     *
     * 输出: 5
     *
     * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
     *
     * @param s 字符串
     * @param k 重复次数
     * @return
     */
    public int longestSubstring(String s, int k) {

        return NumberUtils.INTEGER_ZERO;
    }

    /**
     * 测试
     * 
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int aaabb = solution.longestSubstring("bbaaacbd", 3);
        System.out.println(aaabb);
    }
}
