package study.leetcode.month1.day2;

/**
 * 第二天
 *
 * @author huangqiaowei
 * @create 2019-04-18 20:34
 **/
public class Solution {

    /**
     *
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5 输出: 2
     *
     * @param nums 数组
     * @param target 目标值
     * @return 返回目标值的数组下标
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        int mid = (end - start) >> 1;
        while (true) {
            if (nums[mid] < target) {
                start = mid;

                if (mid + 1 >= end) {
                    return end;
                }
                if (target < nums[mid + 1]) {
                    return mid + 1;
                }
                mid = mid + ((end - start) >> 1);
            } else if (nums[mid] > target) {
                end = mid;
                // 特殊值判断
                if (mid == 1) {
                    if (target > nums[0]) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else if (mid == 0) {
                    return 0;
                }
                mid = mid - ((end - start) >> 1);
            } else {
                return mid;
            }
        }
    }

    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public int oneSearchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l <= r) {
            mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[mid] < target ? l : mid;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int twoSearchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                if (nums[mid + 1] > target) {
                    return mid + 1;
                } else if (nums[mid + 1] == target) {
                    return mid + 1;
                } else {
                    low = mid + 1;
                }
            } else {
                return mid;
            }
        }

        if (nums[low] >= target) {
            return low;
        } else {
            return low + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] demo = { 1, 3, 5, 6 };
        int i = solution.searchInsert(demo, -1);
        System.out.println(i);
    }
}
