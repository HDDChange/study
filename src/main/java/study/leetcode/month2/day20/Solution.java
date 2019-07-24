package study.leetcode.month2.day20;

/**
 * @author huangqiaowei
 * @date 2019-07-24 23:39
 **/
public class Solution {

    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * <p>
     * 将图像顺时针旋转 90 度。
     * <p>
     * 说明：
     * <p>
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     * <p>
     * 示例 1:
     * <p>
     * 给定 matrix =
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix 给定的数组
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return;
        }
        int hn = n % 2 == 0 ? n / 2 : (n / 2 + 1);
        int rowI = 0, colI = 0;
        int nrowI, ncolI, tempI;
        int temp, preTemp;
        while (colI < n - 1 && rowI < n - 1) {
            nrowI = rowI;
            ncolI = colI;
            preTemp = matrix[nrowI][ncolI];
            //旋转遍历四次
            for (int i = 0; i < 4; i++) {
                //取旋转的位置
                tempI = nrowI;
                nrowI = ncolI;
                ncolI = n - 1 - tempI;
                temp = matrix[nrowI][ncolI];
                matrix[nrowI][ncolI] = preTemp;
                preTemp = temp;
            }
            //取下一位循环位置
            colI++;
            if (colI - rowI > n - rowI * 2 - 2) {
                rowI++;
                colI = rowI;
                if (rowI >= hn) {
                    break;
                }
            }
        }
    }
}
