package LCP.Problem_2908_元素和最小的山形三元组_I;

/*
https://leetcode.cn/contest/weekly-contest-368/problems/minimum-sum-of-mountain-triplets-i/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [8,6,1,5,3]
        // 输出：9
//        int[] nums = new int[]{8,6,1,5,3};

        // 输入：nums = [5,4,8,7,10,2]
        // 输出：13
//        int[] nums = new int[]{5,4,8,7,10,2};

        // 输入：nums = [6,5,4,3,4,5]
        // 输出：-1
        int[] nums = new int[]{6,5,4,3,4,5};

        Solution solution = new Solution();
        int result = solution.minimumSum(nums);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int minimumSum(int[] nums) {

            int[] minLeftNums = new int[nums.length];
            int[] minRightNums = new int[nums.length];

            // 正向遍历数组，minLeftNums数组保存每个下标位置的左边数字的最小值
            int tempMin = nums[0];
            for (int i = 0; i < nums.length; i++) {
                minLeftNums[i] = (nums[i] <= tempMin) ? nums[i] : tempMin;
                tempMin = Math.min(nums[i], tempMin);
            }

            // 反向遍历数组，minRightNums数组保存每个下标位置的右边数字的最小值
            tempMin = nums[nums.length - 1];
            for (int i = 0; i < nums.length; i++) {
                minRightNums[nums.length - 1 - i ] =
                        (nums[nums.length - 1 - i] <= tempMin) ?
                        nums[nums.length - 1 - i] : tempMin;
                tempMin = Math.min(nums[nums.length - 1 - i], tempMin);
            }

            // 再一次遍历原数组，从下标1到length-2。
            // 如果原数组的各个数字，大于对应的下标-1的minLeftNums数组中的数字，并且
            // 大于对应的下标+1的minRightNums数组中的数字。
            // 则符合 "山形三元组"。
            // 最后打擂台，求出 元素和最小的"山形三元组"，并返回最小的元素和。
            int minTempSum = Integer.MAX_VALUE;
            int tempSum = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > minLeftNums[i - 1] && nums[i] > minRightNums[i + 1]) {
                    tempSum = minLeftNums[i - 1] + nums[i] + minRightNums[i + 1];
                    minTempSum = Math.min(tempSum, minTempSum);
                }
            }

            return (minTempSum == Integer.MAX_VALUE) ? -1 : minTempSum;
        }
    }
}