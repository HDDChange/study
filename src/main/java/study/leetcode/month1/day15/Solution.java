package study.leetcode.month1.day15;

/**
 * 不知道第多少天
 *
 * @author huangqiaowei
 * @date 2019-06-21 22:54
 **/
public class Solution {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
     * 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7] 输出: 49
     *
     *
     * 来源：力扣（LeetCode）<br>
     * 链接：https://leetcode-cn.com/problems/container-with-most-water 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @param height 数组
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1, max = 0;
        while (end > start) {
            max = Math.max(Math.min(height[end], height[start]) * (end - start), max);
            if (height[end] > height[start]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.println(i);
    }
}
