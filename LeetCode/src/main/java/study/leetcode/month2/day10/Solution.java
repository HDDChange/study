package study.leetcode.month2.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangqiaowei
 * @date 2019-07-11 22:00
 **/
public class Solution {

    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * <p>
     * 上图是一个部分填充的有效的数独。
     * <p>
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-sudoku
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board 给定的数独
     * @return 是否为合法法的数独
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> col = new HashMap<>(9);
        List<Map<Character, Integer>> rowMap = new ArrayList<>(9);
        List<Map<Character, Integer>> boxsMap = new ArrayList<>(3);
        int temp = 0;
        // 遍历每行
        for (int i = 0; i < 9; i++) {
            // 遍历每列
            for (int j = 0; j < 9; j++) {
                if (rowMap.size() <= j) {
                    Map<Character, Integer> map = new HashMap<>(9);
                    rowMap.add(map);
                }
                temp = j / 3;
                if (boxsMap.size() <= temp) {
                    Map<Character, Integer> map = new HashMap<>(3);
                    boxsMap.add(map);
                }
                if ('.' == board[i][j]) {
                    continue;
                }
                if (col.containsKey(board[i][j])) {
                    return false;
                }
                col.put(board[i][j], j);

                if (boxsMap.get(temp).containsKey(board[i][j])) {
                    return false;
                }
                boxsMap.get(temp).put(board[i][j], j);
                if (rowMap.get(j).containsKey(board[i][j])) {
                    return false;
                }
                rowMap.get(j).put(board[i][j], j);
            }
            col.clear();
            if ((i + 1) % 3 == 0) {
                boxsMap.clear();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = new char[][]{
                {
                        '5', '3', '.', '.', '7', '.', '.', '.', '.'
                },
                {
                        '6', '.', '.', '1', '9', '5', '.', '.', '.'
                },
                {
                        '.', '9', '8', '.', '.', '.', '.', '6', '.'
                },
                {
                        '8', '.', '.', '.', '6', '.', '.', '.', '3'
                },
                {
                        '4', '.', '.', '8', '.', '3', '.', '.', '1'
                },
                {
                        '7', '.', '.', '.', '2', '.', '.', '.', '6'
                },
                {
                        '.', '6', '.', '.', '.', '.', '2', '8', '.'
                },
                {
                        '.', '.', '.', '4', '1', '9', '.', '.', '5'
                },
                {
                        '.', '.', '.', '.', '8', '.', '.', '7', '9'
                }
        };
        boolean validSudoku = solution.isValidSudoku(chars);
        System.out.printf("ok");
    }

}
