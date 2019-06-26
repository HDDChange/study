package study.leetcode.day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-06-24 20:54
 **/
public class Solution {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例:
     *
     * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = initMap();
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuffer sb = new StringBuffer();
        append(result, 0, sb, digits, map);
        return result;
    }

    public void append(List<String> list, int i, StringBuffer sb, String digits, Map<Character, String> map) {
        String s = map.get(digits.charAt(i));
        if (i == digits.length() - 1) {
            for (int j = 0; j < s.length(); j++) {
                list.add(new StringBuffer(sb).append(s.charAt(j)).toString());
            }
        } else {
            for (int j = 0; j < s.length(); j++) {
                int start = i;
                if (j != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(s.charAt(j));
                append(list, start + 1, sb, digits, map);
                if (j == s.length() - 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    /**
     * 初始化电话号码，数字对应字符的map
     * 
     * @return map
     */
    public Map<Character, String> initMap() {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("234");
        System.out.println(strings.toString());
    }
}
