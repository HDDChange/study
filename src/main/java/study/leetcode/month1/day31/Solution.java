package study.leetcode.month1.day31;

/**
 * @author huangqiaowei
 * @date 2019-07-01 21:42
 **/
public class Solution {

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 目标数组
     * @param val  目标数
     * @return 结果
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int end = 1;
        for (int i = 0; i + end <= nums.length; i++) {
            if (nums[i] == val) {
                while (end + i <= nums.length) {
                    if (nums[nums.length - end] == val) {
                        end++;
                    } else {
                        nums[i] = nums[nums.length - end];
                        end++;
                        break;
                    }
                }
            }
        }
        return nums.length - end + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
    }
}
