package study.leetcode.month1.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-06-22 21:38
 **/
public class Solution {

    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 目标数组
     * @return 满足题意的数的组合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(-nums[i], i);
        }
        int start = 0;
        while (start <= nums.length - 3) {
            if (start > 0 && nums[start - 1] == nums[start]) {
                start++;
                continue;
            }
            if (nums[start] + nums[start + 1] > 0) {
                return lists;
            }
            List<Integer> demo = new ArrayList<>();
            for (int i = start + 1; i < nums.length; i++) {
                if (map.containsKey(nums[start] + nums[i])) {
                    Integer temp = map.get(nums[start] + nums[i]);
                    if (temp != start && temp != i) {
                        if (!demo.contains(temp) && temp > i) {
                            lists.add(Arrays.asList(nums[start], nums[i], nums[temp]));
                            demo.add(i);
                            // 去重
                            for (int j = i + 1; j < nums.length - 1; j++) {
                                if (nums[i] == nums[j]) {
                                    demo.add(j);
                                    i++;
                                }
                            }
                        }
                    }

                }

            }
            start++;
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(new int[] { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 });
        System.out.println(lists.toString());

    }
}
