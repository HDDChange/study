package study.leetcode.month1.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * 不知道第几天
 *
 * @author huangqiaowei
 * @date 2019-06-22 17:20
 **/
public class Solution {

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符 数值 I 1 V 5 X 10 L 50 C 100 D 500 M 1000 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII,
     * 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9
     * 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。  C 可以放在 D (500) 和 M (1000)
     * 的左边，来表示 400 和 900。
     *
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/roman-to-integer 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s 字符串
     * @return 目标数
     */
    public int romanToInt(String s) {
        Map<String, Integer> demo = new HashMap<>();
        demo.put("I", 1);
        demo.put("IV", 4);
        demo.put("V", 5);
        demo.put("IX", 9);
        demo.put("X", 10);
        demo.put("XL", 40);
        demo.put("L", 50);
        demo.put("XC", 90);
        demo.put("C", 100);
        demo.put("CD", 400);
        demo.put("D", 500);
        demo.put("CM", 900);
        demo.put("M", 1000);
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length() && demo.containsKey(s.substring(i, i + 2))) {
                ans += demo.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += demo.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }
}
