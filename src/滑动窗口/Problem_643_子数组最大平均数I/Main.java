package 滑动窗口.Problem_643_子数组最大平均数I;

/*
https://leetcode.cn/problems/maximum-average-subarray-i/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：
        // nums = [1,12,-5,-6,50,3], k = 4
        // 输出：
        // 12.75
//        int[] nums = new int[]{1,12,-5,-6,50,3};
//        int k = 4;

        // 输入：nums = [5], k = 1
        // 输出：5.00000
//        int[] nums = new int[]{5};
//        int k = 1;

        // 输入：nums = [0,4,0,3,2], k = 1
        // 输出：4.0
//        int[] nums = new int[]{0,4,0,3,2};
//        int k = 1;

        // 输入：nums = [4,2,1,3,3], k = 2
        // 输出：3.0
        int[] nums = new int[]{4,2,1,3,3};
        int k = 2;

        Solution solution = new Solution();
        double result = solution.findMaxAverage(nums, k);

        System.out.println("result = " + result);
    }

    static class Solution {

        public double findMaxAverage(int[] nums, int k) {

            int numsLength = nums.length;
            int curSum = 0;

            // 先计算 从0开始, 到k-1, 一共k个数字的总和
            for (int i = 0; i <= k - 1; i++) {
                curSum = curSum + nums[i];
            }

            // 根据数组的元素, 向前滚动, 计算k个数字的总和
            // 然后, 打擂台的方式, 比较后得到最大的总和
            int maxSum = curSum;
            for (int j = 1; j <= numsLength - k; j++) {
                curSum = curSum - nums[j-1] + nums[j-1+k];
                maxSum = Math.max(maxSum, curSum);
            }

            // 返回 平均数 = 总和 * 1.0 / k
            return (maxSum*1.0/k);
        }
    }


}