package study.leetcode.month1.day18;

/**
 * @author huangqiaowei
 * @date 2019-06-22 17:41
 **/
public class Solution {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
     *
     * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-prefix 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param strs 目标字符串数组
     * @return 最长前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != temp) {
                    return sb.toString();
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }
}
