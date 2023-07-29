package 二分查找.Problem_35_搜索插入位置;

import java.util.ArrayList;
import java.util.List;

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

            int midLength = (start + end) / 2;
            if (nums[midLength] == target) {
                return midLength;
            }

            if (nums[midLength] > target) {
                return process(nums, start, midLength, target);
            } else {
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