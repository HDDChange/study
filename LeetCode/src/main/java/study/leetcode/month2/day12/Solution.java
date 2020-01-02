package study.leetcode.month2.day12;

import java.util.Arrays;

/**
 * @author huangqiaowei
 * @date 2019-07-12 18:34
 **/
public class Solution {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[queries.length];
        Integer sum = Arrays.stream(A).filter(value -> value%2 ==0).sum(), index,temp,add;
        for (int i = 0; i < queries.length; i++) {
            index = queries[i][1];
            temp = queries[i][0];
            add = A[index] + temp;
            if (A[index] %2 == 0){
                if (add %2 == 0){
                    sum += temp;
                }else{
                    sum -= A[i];
                }
            }else {
                if (add %2 == 0){
                    sum += add;
                }
            }
            result[i] = sum;
            A[index] = add;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = -4;
        boolean temp = i%2 == 0;
        System.out.println(temp);
    }
}
