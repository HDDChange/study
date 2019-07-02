package study.leetcode.month1.day8;

/**
 * 第四天
 *
 * @author huangqiaowei
 * @date 2019-06-15 09:58
 **/
public class Solution {

    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * 示例 1:
     *
     * nums1 = [1, 3] nums2 = [2]
     *
     * 则中位数是 2.0 示例 2:
     *
     * nums1 = [1, 2] nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     * 
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] max, min;
        if (nums1.length > nums2.length) {
            max = nums1;
            min = nums2;
        } else {
            max = nums2;
            min = nums1;
        }
        int resultLength = max.length + min.length;
        int[] temp = new int[resultLength];
        int mid = resultLength / 2;
        if (min.length == 0) {
            // 如果有一个数组为空，则不用循环，直接返回大数组的中间值
            return resultLength % 2 == 0 ? (max[mid] + max[mid - 1]) / 2.0 : max[mid];
        }
        // 循环拼接两个数组 m + n次
        int start = 0, end = 0;
        while ((start + end) < resultLength) {
            if (start >= min.length) {
                temp[start + end] = max[end++];
                continue;
            }
            if (end >= max.length) {
                temp[start + end] = min[start++];
                continue;
            }
            if (max[end] > min[start]) {
                temp[start + end] = min[start++];
            } else {
                temp[start + end] = max[end++];
            }
        }
        return resultLength % 2 == 0 ? (temp[mid] + temp[mid - 1]) / 2.0 : temp[mid];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[] { 3 }, new int[] { -2, -1 });
        System.out.println(medianSortedArrays);
    }
}
