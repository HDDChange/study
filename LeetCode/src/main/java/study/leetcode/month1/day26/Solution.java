package study.leetcode.month1.day26;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqiaowei
 * @date 2019-06-27 11:06
 **/
public class Solution {
    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/generate-parentheses 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n n位
     * @return 目标链表
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(n);
        // 回溯
        init(result, 1, n, "(");
        return result;
    }

    public void init(List<String> list, int value, int n, String str) {
        if (value == 0 && 2 * n == str.length()) {
            list.add(str);
            return;
        }
        if (value < 0 || 2 * n < str.length()) {
            return;
        }

        if (value < n) {
            init(list, value + 1, n, str + "(");
        }
        if (value > 0) {
            init(list, value - 1, n, str + ")");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }
}
