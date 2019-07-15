package study.leetcode.month2.day16;

/**
 * @author huangqiaowei
 * @date 2019-07-14 21:43
 **/
public class Soution {


    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height 数组
     * @return 能接的雨水的数量
     */
    public int trap(int[] height) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height.length; i++) {
            min = Integer.min(height[i], min);
        }
        return backtracking(height, min, 0);
    }

    /**
     * 算出每一层能接雨水的数量
     *
     * @param height 给定的数组
     * @param i      给定的高度
     * @return 能接的雨水
     */
    public int backtracking(int[] height, int i, int sum) {
        int start = -1, end = -1;
        for (int j = 0; j < height.length; j++) {
            if (height[j] > i) {
                if (start == -1) {
                    start = j;
                    continue;
                }
                end = j;
                sum = sum + end - start - 1;
                start = end;
            }
        }
        if (start == -1 && end == -1) {
            return sum;
        } else {
            return backtracking(height, i + 1, sum);
        }
    }

    /**
     * 标准答案，双指针
     *
     * @param height 给定的数组
     * @return 能接的雨滴数
     */
    public int answer(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += (rightMax - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Soution soution = new Soution();
        int trap = soution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
}
