package study.leetcode.month1.day5;

import java.util.HashMap;
import java.util.Objects;

/**
 * 线段树
 *
 * @author huangqiaowei
 * @date 2019-06-12 14:19
 **/
public class Solution {

    private HashMap<Node, Integer> nodes = new HashMap<>();

    private class Node {
        private int l, r, sum;

        public Node(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                Node node = (Node) obj;
                if (this.l == node.l && this.r == node.r) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    private int count = 0;
    private int lower;
    private int upper;

    /**
     * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤
     * j)。
     *
     * 说明: 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
     *
     * 示例:
     *
     * 输入: nums = [-2,5,-1], lower = -2, upper = 2, 输出: 3 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
     *
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-of-range-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * 1. 解法：线段树 适合动态线段树问题 2.
     * 
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        if ((upper - lower) == 0 && nums.length == 0) {
            return 0;
        }
        // 线段树数组
        int[] tree = new int[nums.length << 2];
        init(tree, nums, 2, nums.length, 1);
        init(tree, nums, 1, nums.length - 1, 1);
        init(tree, nums, 1, nums.length, 1);
        pushUp(1, nums.length, 1, nums, tree);
        return count;
    }

    /**
     * 更新节点值（最大值、最小值、区间和）
     * 
     * @param l 区间 左
     * @param r 区间 右
     * @param k 线段树节点
     */
    public void pushUp(int l, int r, int k, int[] nums, int[] tree) {
        int start = l;
        int end = r;
        // 区间和
        int sum = 0;
        while (l <= r) {
            sum += nums[(l++) - 1];
        }
        tree[k] = sum;
        if (sum >= lower && sum <= upper) {
            Node node = new Node(start - 1, end, sum);
            if (Objects.nonNull(nodes.get(node))) {
                return;
            }
            nodes.put(node, sum);
            ++count;
        }
    }

    /**
     * 初始化建树
     */
    public void init(int[] tree, int[] nums, int l, int r, int k) {
        // 如果区间 左 == 右 则为叶子节点
        if (l == r) {
            pushUp(l, r, k, nums, tree);
        } else {
            // 一半的区间
            int min = l + ((r - l) >> 1);
            // 构建左儿子
            init(tree, nums, l, min, k << 1);
            // 构建右儿子
            init(tree, nums, min + 1, r, k << 1 | 1);
            // 填充值
            pushUp(l, r, k, nums, tree);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countRangeSum(new int[] { -2, 5, -1 }, -2, 2);
        System.out.println(i);
    }

}
