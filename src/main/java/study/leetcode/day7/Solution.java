package study.leetcode.day7;

import java.util.ArrayList;
import java.util.List;

/**
 * 第7天
 *
 * @author huangqiaowei
 * @date 2019-06-14 21:22
 **/
public class Solution {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
     *
     * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
     *
     * 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param s 目标字符传
     * @return 符合条件子串第长度
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        int value = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length - 1; i++) {
            list.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                if (list.contains(chars[j])) {
                    break;
                } else {
                    list.add(chars[j]);
                }
            }
            value = list.size() > value ? list.size() : value;
            list.clear();
        }
        return value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = solution.lengthOfLongestSubstring(" ");
        System.out.println(length);
    }
}
