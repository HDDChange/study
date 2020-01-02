package study.leetcode.month1.day22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangqiaowei
 * @date 2019-06-25 21:32
 **/
public class Solution {

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 注意：
     *
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/4sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 目标数组
     * @param target 目标数
     * @return 结果
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        // 双指针
        int start = 0;
        while (start < nums.length - 3) {
            for (int i = start + 1; i < nums.length - 2; i++) {
                if (nums[start] + nums[i] + nums[i + 1] + nums[i + 2] > target) {
                    break;
                }
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int end = j;
                    while (end < nums.length - 1) {
                        if (nums[start] + nums[i] + nums[j] + nums[end + 1] == target) {
                            result.add(Arrays.asList(nums[start], nums[i], nums[j], nums[end + 1]));
                        }
                        if (nums[start] + nums[i] + nums[j] + nums[end + 1] > target) {
                            break;
                        }
                        end++;
                        while (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                            end++;
                        }
                    }
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            while (start < nums.length - 1 && nums[start] == nums[start + 1]) {
                start++;
            }
            start++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[] { -1, -5, -5, -3, 2, 5, 0, 4 }, -7);
        System.out.println(lists.toString());
    }

}
