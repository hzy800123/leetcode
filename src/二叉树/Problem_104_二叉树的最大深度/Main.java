package 二叉树.Problem_104_二叉树的最大深度;

/*
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        // Input: root = [1,null,2]
        // Output: 2
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        treeNode1.right = treeNode2;
//        treeNode = treeNode1;

        // Input: root = [3,9,20,null,null,15,7]
        // Output: 3

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode = treeNode1;

        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(treeNode);
        System.out.println("maxDepth = " + maxDepth);
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int depthLeft = 0;
            int depthRight = 0;

            // 递归调用, 查找左节点的最大深度
            depthLeft = maxDepth(root.left);
            // 递归调用, 查找右节点的最大深度
            depthRight = maxDepth(root.right);

            // 最后结果, 是左右节点的取最大值, 再加1
            return Math.max(depthLeft, depthRight) + 1;
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