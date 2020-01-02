package study.leetcode.month1.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一天第一题
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9 输出: [1,2] 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author huangqiaowei
 * @create 2019-04-17 19:00
 **/
public class Solution {

    /**
     * 总体思路
     *
     * @param numbers 有序数组
     * @param target 目标值
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            String index = findIndex(numbers, target - numbers[i], i + 1, numbers.length);
            if ("".equals(index)) {
                continue;
            } else {
                int[] result = { i + 1, Integer.parseInt(index) + 1 };
                return result;
            }
        }
        return null;
    }

    /**
     * 二分法找预期值
     *
     * @param temp 升序数组
     * @param value 特定值
     * @return 特定值下标
     */
    public String findIndex(int[] temp, int value, int start, int end) {
        int big = start + ((end - start) >> 1);
        // 边缘值
        if (value > temp[big]) {
            if (big == start || big + 1 == temp.length) {
                return "";
            }
            return findIndex(temp, value, big, temp.length);
        } else if (value < temp[big]) {
            if (big == start || big + 1 == temp.length) {
                return "";
            }
            return findIndex(temp, value, start, big - 1);
        } else {
            return String.valueOf(big);
        }
    }

    /**
     * hash
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] hashTwoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            int x = target - numbers[i];
            if (map.containsKey(x)) {
                return new int[] { map.get(x) + 1, i + 1 };
            }
            map.put(numbers[i], i);
        }
        return new int[] {};
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] demo = { 3, 24, 50, 79, 88, 150, 345 };
        Solution study = new Solution();
        int[] test = study.twoSum(demo, 200);
        System.out.println(test[0]);
        System.out.println(test[1]);
    }
}
