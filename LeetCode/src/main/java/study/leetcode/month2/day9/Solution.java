package study.leetcode.month2.day9;

/**
 * @author huangqiaowei
 * @date 2019-07-10 22:23
 **/
public class Solution {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums   数组
     * @param target 目标数
     * @return 坐标
     */
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                // 找到了值
                while (result[0] == -1) {
                    if (mid > 0) {
                        if (nums[mid - 1] == target) {
                            mid--;
                            continue;
                        } else {
                            result[0] = mid;
                        }
                    } else {
                        result[0] = mid;
                    }
                }
                while (result[1] == -1) {
                    if (mid < nums.length - 1) {
                        if (nums[mid + 1] == target) {
                            mid++;
                            continue;
                        } else {
                            result[1] = mid;
                        }
                    } else {
                        result[1] = mid;
                    }
                }
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    }
}
