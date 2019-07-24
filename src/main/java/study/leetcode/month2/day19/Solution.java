package study.leetcode.month2.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangqiaowei
 * @date 2019-07-23 22:57
 **/
public class Solution {

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     *
     * 示例:
     *
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums 给定的数组
     * @return 结果
     */
    public List<List<Integer>> permuteUnique(int[] nums) {

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
        for (int i = 0; i < temp.size(); i++) {
            if (isFilter(i,temp,nums)){
                continue;
            }
            result.add(nums[temp.get(i)]);
            List<Integer> objects = new ArrayList<>();
            objects.addAll(temp);
            objects.remove(temp.get(i));
            backtracking(list, objects, result, nums);
            result.remove(result.size() - 1);
        }
    }

    public boolean isFilter(int i, List<Integer> temp,int[] nums){
        if (i == 0) {
            return false;
        }
        for (int j = 0; j < i; j++) {
            if (nums[temp.get(i)] == nums[temp.get(j)]){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permuteUnique(new int[]{1,1,2,2});
    }


}
