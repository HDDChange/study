package study.leetcode.month2.day21;

/**
 * 排序
 *
 * @author huangqiaowei
 * @date 2019-08-13 21:14
 **/
public class Solution {

    /**
     * 给定一个整数数组 nums，将该数组升序排列。
     *
     * @param nums 给定数组
     * @return 有序数组
     */
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums;
        }
        return quickSort(nums, 0, nums.length - 1);
    }


    /**
     * 快速排序
     *
     * @param nums 数组
     * @return 结果
     */
    public int[] quickSort(int[] nums, int left, int right) {
        //选定数组第一个数字作为key
        int key = nums[left];
        int start = left;
        int end = right;
        while (start < end) {
            //从右向左遍历,找到小于key的,放入下标strat中。
            while (start < end && key <= nums[end]) {
                end--;
            }
            nums[start] = nums[end];

            //从左向右遍历,找到大于key的,放入下标end中。
            while (start < end && key > nums[start]) {
                start++;
            }
            nums[end] = nums[start];
        }
        //此时start==end,这就是所谓的轴，把key放入轴中，轴左边的都<key,轴右边的都>key
        nums[start] = key;
        //此时大家想象一下，轴在数组中间，说明把数组分成两部分，此时要对这两部分分别进行快排。
        if (start > left) {
            quickSort(nums, left, start - 1);
        }
        if (start < right) {
            quickSort(nums, start + 1, right);
        }
        return nums;
    }
}
