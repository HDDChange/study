package study.leetcode.month2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-07-25 21:54
 **/
public class Solution {

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs 给定的字符串数组
     * @return 结果
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(map.values());
        }
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        int temp = 1;
        for (int i = 1; i < 27; i++) {
            System.out.println(temp += i);

        }
    }
}
