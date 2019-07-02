package study.leetcode.month1.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * 第6天
 *
 * @author huangqiaowei
 * @date 2019-06-17 20:54
 **/
public class Solution {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L C I R E T O E S I I G E D H N 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows); 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN" 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释: L D R E O E I I E C I H N T S G
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zigzag-conversion 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param s 目标字符串
     * @param numRows 给定行数
     * @return 值
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Map<Integer, StringBuffer> temp = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            temp.put(i, new StringBuffer());
        }
        int i = 0;
        int a = 1;
        char[] chars = s.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            temp.put(i, temp.get(i).append(chars[j]));
            if (i == 0) {
                a = 1;
            }
            if (i == numRows - 1) {
                a = -1;
            }
            i = i + a;
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer sb : temp.values()) {
            result.append(sb);
        }
        return result.toString();
    }

}
