package study.leetcode.month1.day24;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author huangqiaowei
 * @date 2019-06-26 17:14
 **/
public class Solution {

    /**
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()" 输出: true
     *
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = initMap();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '{' || temp == '(' || temp == '[') {
                stack.push(temp);
            } else {
                if (stack.empty() || map.get(stack.pop()) != temp) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private Map<Character, Character> initMap() {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("{[]}");
        System.out.println(valid);
    }
}
