package 位运算.Problem_136_只出现一次的数字;

import java.util.*;

/*
https://leetcode.cn/problems/single-number/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // Input: nums = [2,2,1]
        // Output: 1
//        int[] nums = new int[]{2,2,1};

        // Input: nums = [4,1,2,1,2]
        // Output: 4
//        int[] nums = new int[]{4,1,2,1,2};

        // Input: nums = [1]
        // Output: 1
        int[] nums = new int[]{1};

        Solution solution = new Solution();
        int result = solution.singleNumber(nums);
        System.out.println("result = " + result);
    }

    static class Solution {
        public int singleNumber(int[] nums) {

            // 使用 HashSet, 保存出现的数字
            HashSet<Integer> hashSet = new HashSet<>();

            // 如果 数字不在 HashSet 中, 加入进去
            // 如果 数字已经在 HashSet 中, 可以删除
            // 最后, HashSet 中, 余下的数字即出现一次的数字
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (hashSet.contains(num)) {
                    hashSet.remove(num);
                } else {
                    hashSet.add(num);
                }
            }

            Iterator<Integer> iterator = hashSet.iterator();
            Integer result = iterator.next();

            return result.intValue();
        }

    }
}