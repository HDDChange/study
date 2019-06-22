package study.leetcode.day9.fail;

import java.util.Objects;

/**
 * 暴力法
 *
 * @author huangqiaowei
 * @date 2019-06-17 20:52
 **/
public class Solution {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
     *
     * 输入: "cbbd" 输出: "bb"
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 目标字符串
     * @return 满足条件的回文字符串
     */
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        String value = "";
        // 遍历所有子串
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                sb.append(chars[j]);
                String temp = validateStr(sb);
                if (temp != null) {
                    value = temp.length() > value.length() ? temp : value;
                }
            }
            sb.setLength(0);
        }
        return value;
    }

    /**
     * 双指针判断是否是回文字符串
     *
     * @param chars 子串
     * @return 返回回文子串 不满足 null
     */
    private String validateStr(StringBuffer chars) {
        int start = 0, end = chars.length() - 1;
        for (int i = 0; i < chars.length(); i++) {
            if (start >= end) {
                return chars.toString();
            }
            if (Objects.equals(chars.charAt(start), chars.charAt(end))) {
                start++;
                end--;
            } else {
                return null;
            }
        }
        return null;
    }
}
