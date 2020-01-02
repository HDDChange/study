package study.leetcode.month2.day17;

/**
 * @author huangqiaowei
 * @date 2019-07-15 22:50
 **/
public class Solution {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num1 数1
     * @param num2 数2
     * @return 积
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arrayInt = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int z = length2 - 1; z >= 0; z--) {
                int number1 = num1.charAt(i) - 48;
                int number2 = num2.charAt(z) - 48;
                arrayInt[i + z] += number1 * number2;
                if (arrayInt[i + z] >= 10 && (i + z) != 0) {
                    arrayInt[i + z - 1] += arrayInt[i + z] / 10;
                    arrayInt[i + z] = arrayInt[i + z] % 10;
                }
            }
        }
        for (int i = 0; i <= length1 + length2 - 2; i++) {
            str.append(arrayInt[i]);
        }
        return str.toString();
    }
}
