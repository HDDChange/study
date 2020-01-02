package study.leetcode.month2.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqiaowei
 * @date 2019-07-22 21:38
 **/
public class Solution {

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums 给定的数组
     * @return 全排列结果
     */
    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> temp = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            temp.add(i);
        }
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, temp, new ArrayList<>(nums.length), nums);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> temp, List<Integer> result, int[] nums) {
        if (temp.size() <= 0) {
            List<Integer> real = new ArrayList<>();
            real.addAll(result);
            list.add(real);
            return;
        }
        for (Integer i : temp) {
            result.add(nums[i]);
            List<Integer> objects = new ArrayList<>();
            objects.addAll(temp);
            objects.remove(i);
            backtracking(list, objects, result, nums);
            result.remove(Integer.valueOf(nums[i]));
        }
    }

}
