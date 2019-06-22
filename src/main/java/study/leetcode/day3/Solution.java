package study.leetcode.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 第三天
 *
 * @author huangqiaowei
 * @create 2019-04-19 18:19
 **/
public class Solution {

    public Solution() {
    }

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
        if (k < 2) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int maxLengh = 0;
        int start = -1;
        Map<Character, List<Integer>> map = getNumChar(chars);
        Map<Integer, Character> indexMap = new HashMap<>();
        map.forEach((character, integers) -> {
            if (integers.size() >= k) {
                integers.forEach(integer -> {
                    indexMap.put(integer, character);
                });
            }
        });

        if (indexMap.size() == 0) {
            return maxLengh;
        }
        // 子串 3，4，5
        Set<Character> temp = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (indexMap.containsKey(i)) {
                if (start == -1) {
                    start = i;
                }
                temp.add(indexMap.get(i));
                if (start != -1 && i == chars.length - 1) {
                    if (i - start + 1 >= k * temp.size()) {
                        maxLengh = i - start + 1;
                    }
                }
            } else {
                if ((i - start) >= k * temp.size()) {
                    maxLengh = i - start;
                }
                temp.clear();
                start = i;
                temp.add(indexMap.get(i));
            }

        }
        return maxLengh;
    }

    /**
     * 字符串中所有char的次数map
     * 
     * @param chars 字符串
     * @return 字符串所有char的出现的次数
     */
    public Map<Character, List<Integer>> getNumChar(char[] chars) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.get(chars[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(chars[i], list);
            }
        }
        return map;
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
