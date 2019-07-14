package study.leetcode.month2.day14;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangqiaowei
 * @date 2019-07-13 21:17
 **/
public class Solution {

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates 给定都数组
     * @param target     给定的值
     * @return 结果
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        // 回溯法求解 对数组排序减少无效对压栈
        Arrays.sort(candidates);
        backtracking(result, target, candidates, new LinkedList<>(), 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, int taget, int[] candidates, List<Integer> temp, int start) {
        for (int i = start; i < candidates.length; i++) {
            if (i > start) {
                if (candidates[i] == candidates[i - 1]) {
                    continue;
                }
            }
            if (taget - candidates[i] == 0) {
                temp.add(candidates[i]);
                result.add(temp);
                return;
            } else if (taget - candidates[i] < 0) {
                temp = null;
                return;
            } else {
                List<Integer> demo = new LinkedList<>(temp);
                demo.add(candidates[i]);
                backtracking(result, taget - candidates[i], candidates, demo, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combinationsum = solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.printf("ok");
    }

}
