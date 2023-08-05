package 二分查找.Problem_35_搜索插入位置;


/*
https://leetcode.cn/problems/search-insert-position
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入: nums = [1,3,5,6], target = 5
        // 输出: 2
//        int nums[] = new int[]{1,3,5,6};
//        int target = 5;

        // 输入: nums = [1,3,5,6], target = 2
        // 输出: 1
//        int nums[] = new int[]{1,3,5,6};
//        int target = 2;

        // 输入: nums = [1,3,5,6], target = 7
        // 输出: 4
        int nums[] = new int[]{1,3,5,6};
        int target = 7;

        Solution solution = new Solution();
        int result = solution.searchInsert(nums, target);
        System.out.println("result = " + result);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    static class Solution {
        public int searchInsert(int[] nums, int target) {

            int length = nums.length;
            int result = process(nums, 0, length, target);

            return result;
        }

        public int process(int[] nums, int start, int end, int target) {

            if (start == end) {
                return start;
            }

            // 使用 二分查找 方法
            int midLength = (start + end) / 2;

            // 如果 二分之后, 已经找到, 则立即返回
            if (nums[midLength] == target) {
                return midLength;
            }

            // 如果 二分之后, 中间的值 > target, 就是 target 应该较小的区间内
            // 修改开始和结束的位置, 继续二分查找下去
            if (nums[midLength] > target) {
                return process(nums, start, midLength, target);
            } else {
                // 如果 二分之后, 中间的值 <= target, 就是 target 应该较大的区间内
                // 修改开始和结束的位置, 继续二分查找下去
                return process(nums, midLength + 1, end, target);
            }

        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}