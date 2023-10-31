package LCP.Problem_2859_计算K置位下标对应元素的和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.cn/contest/weekly-contest-363/problems/sum-of-values-at-indices-with-k-set-bits/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [5,10,1,5,2], k = 1
        // 输出：13
        List<Integer> nums = new ArrayList<>(Arrays.asList(5,10,1,5,2));
        int k = 1;

        // 输入：nums = [4,3,2,1], k = 2
        // 输出：1
//        List<Integer> nums = new ArrayList<>(Arrays.asList(4,3,2,1));
//        int k = 2;

        Solution solution = new Solution();
        int result = solution.sumIndicesWithKSetBits1(nums, k);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int sumIndicesWithKSetBits1(List<Integer> nums, int k) {
            int length = nums.size();
            int sumResult = 0;

            for (int i = 0; i < length; i++) {
                if (Integer.bitCount(i) == k) {
//                if (calOneCount(i, k) == k) {
                    sumResult = sumResult + nums.get(i);
                }
            }

            return sumResult;
        }

        public int sumIndicesWithKSetBits2(List<Integer> nums, int k) {

            int length = nums.size();
            int sumResult = 0;

            for (int i = 0; i < length; i++) {
                if (calOneCount(i, k) == k) {
                    sumResult = sumResult + nums.get(i);
                }
            }

            return sumResult;
        }

        private int calOneCount(int i, int k) {
            int temp = i;
            int countOne = 0;

            while (temp > 0) {
                if (temp % 2 == 1) {
                    countOne++;
                    if (countOne > k) {
                        break;
                    }
                }
                temp = temp / 2;
            }

            return countOne;
        }
    }
}