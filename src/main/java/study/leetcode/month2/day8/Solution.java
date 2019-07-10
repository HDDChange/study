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
        int start = 0, end = nums.length - 1, div = nums[nums.length - 1];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //如果在同一边，按照正常的二分搜索方向
            if ((nums[mid] > div && target > div) || (nums[mid] <= div && target <= div)) {
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                //如果在翻转的不同边，反转二分搜索的方向
                if (nums[mid] > target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;

    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int search = solution.search(new int[]{5, 1, 3}, 3);

        System.out.println(search);
    }
}
