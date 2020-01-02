package study.leetcode.month1.day20;

import java.util.Arrays;

/**
 * @author huangqiaowei
 * @date 2019-06-23 21:08
 **/
public class Solution {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 目标数组
     * @param target 目标数
     * @return 满足题意的结果
     */
    public int threeSumClosest(int[] nums, int target) {
        // 先对数组排序
        Arrays.sort(nums);
        int sum = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 求中间值
            int newTarget = target - nums[i];
            int start = i + 1, end = nums.length - 1;
            while (end > start) {
                int value = nums[start] + nums[end];
                if (temp > Math.abs(value - newTarget)) {
                    temp = Math.abs(value - newTarget);
                    sum = nums[i] + value;
                }
                if (value > newTarget) {
                    end--;
                } else if (value == newTarget) {
                    return sum;
                } else {
                    start++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.threeSumClosest(new int[] { 1, -3, 3, 5, 4, 1 }, 1);
        System.out.println(i);
    }
}
