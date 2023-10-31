package LCP.Problem_2903_找出满足差值条件的下标_I;

/*
https://leetcode.cn/contest/weekly-contest-367/problems/find-indices-with-index-and-value-difference-i/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
        // 输出：[0,3]
//        int[] nums = new int[]{5,1,4,1};
//        int indexDifference = 2;
//        int valueDifference = 4;

        // 输入：nums = [2,1], indexDifference = 0, valueDifference = 0
        // 输出：[0,0]
//        int[] nums = new int[]{2,1};
//        int indexDifference = 0;
//        int valueDifference = 0;

        // 输入：nums = [1,2,3], indexDifference = 2, valueDifference = 4
        // 输出：[-1,-1]
        int[] nums = new int[]{1,2,3};
        int indexDifference = 2;
        int valueDifference = 4;

        Solution solution = new Solution();
        int[] result = solution.findIndices(nums, indexDifference, valueDifference);
        System.out.println("result = " + result[0] + ", " + result[1]);
    }

    static class Solution {

        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

            int lengthNums = nums.length;
            for(int i = 0; i < lengthNums; i++) {
                int j = i + indexDifference;

                for(; j < lengthNums; j++) {
                    if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                        // Found one result and return the result
                        return new int[]{i, j};
                    }
                }
            }

            // Not found
            return new int[]{-1, -1};
        }
    }

}