package study.leetcode.month2.day15;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-07-13 21:56
 **/
public class Solution {

    /**
     * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     *
     * 示例 1:
     *
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     *
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 给定的数组
     * @return 结果
     */
    public int firstMissingPositive(int[] nums) {
        Map<Integer,Integer> map = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!map.containsKey(i)){
                return i;
            }
        }
        return 0;
    }
}
