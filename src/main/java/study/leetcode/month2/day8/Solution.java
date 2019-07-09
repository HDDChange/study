package study.leetcode.month2.day8;

/**
 * @author huangqiaowei
 * @date 2019-07-07 15:47
 **/
public class Solution {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums   给定的数组
     * @param target 目标数
     * @return 索引
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 时间复杂度 log(n)
        int start = 0, end = nums.length - 1, mid;
        while (true) {
            // 中间数
            mid = start + ((end - start) >> 1);
            if (nums[mid] > nums[start]) {
                if (nums[end] == target){
                    return end;
                }
                if (target > nums[mid]) {
                    start = mid;
                } else if (target < nums[mid]) {
                    end = mid;
                } else {
                    return mid;
                }
            } else  {
                if (nums[start] == target){
                    return start;
                }
                if (target > nums[mid]) {
                    end = mid;
                } else if (target < nums[mid]) {
                    start = mid;
                } else {
                    return mid;
                }
            }
            if (start + 1 >= end) {
                if (target == nums[end]) {
                    return end;
                }
                if (target == nums[start]) {
                    return start;
                }
                return -1;
            }
        }

    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int search = solution.search(new int[]{5,1,3}, 3);

        System.out.println(search);
    }
}
