package study.leetcode.month2.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-07-02 21:15
 **/
public class Solution {

    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * <p>
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     * <p>
     * 输入：
     * s = "wordgoodgoodgoodbestword",
     * words = ["word","good","best","word"]
     * 输出：[]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s     字符传
     * @param words 单词组
     * @return 启始位置
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>(words.length);
        if ("".equals(s) || words.length == 0) {
            return list;
        }
        // 所有子串长度都相同
        int length = words[0].length();
        int maxLenth = length * words.length;
        Map<String, Integer> map = initMap(words);
        // 遍历目标字符串
        for (int i = 0; i < s.length() - maxLenth + 1; i++) {
            String temp = s.substring(i, i + length);
            // 如果匹配
            if (map.containsKey(temp)) {
                String subStr = s.substring(i, i + maxLenth);
                for (int j = 0; j < words.length; j++) {
                    String word = subStr.substring(j * length, j * length + length);
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) - 1);
                        if (map.get(word) < 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                    if (j == words.length - 1) {
                        list.add(i);
                    }
                }
                map = initMap(words);
            }
        }
        return list;
    }

    public Map<String, Integer> initMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> barfoothefoobarman = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word",
                "good", "best", "good",});
        System.out.println(barfoothefoobarman.toString());
    }


}
