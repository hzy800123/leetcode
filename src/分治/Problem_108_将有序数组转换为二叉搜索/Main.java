package 分治.Problem_108_将有序数组转换为二叉搜索;

/*
https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        // nums = [-10,-3,0,5,9]
        int nums[] = new int[]{-10,-3,0,5,9};

        Solution solution = new Solution();
        TreeNode result = solution.sortedArrayToBST(nums);
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

        public TreeNode sortedArrayToBST(int[] nums) {

            int length = nums.length;
            int midLegth = length/2;
            int val = nums[midLegth];
            TreeNode root = new TreeNode(val);

            // 因为是平衡二叉树, 所以每一次都可以采用 二分法:
            // 对数组里的元素平均分为2份
            // 对较小的区间的数字, 构建左子树
            // 对较大的区间的数字, 构建右子树
            process(nums, 0, midLegth, root, true);
            process(nums, midLegth + 1, length, root, false);

            return root;
        }

        public void process(int[] nums, int start, int end, TreeNode tree, boolean isLeft) {

            // 如果 start == end,直接返回
            if (start == end) {
                return;
            }
            // 创建一个新的子节点,并挂到原来的父节点的下面
            int midLegth = (start + end) / 2;
            int val = nums[midLegth];
            TreeNode node = new TreeNode(val);
            if (isLeft) {
                tree.left = node;
            } else {
                tree.right = node;
            }

            // 对数组里的元素平均分为2份
            // 对较小的区间的数字, 构建左子树
            // 对较大的区间的数字, 构建右子树
            process(nums, start, midLegth, node, true);
            process(nums, midLegth + 1, end, node, false);

            return;
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