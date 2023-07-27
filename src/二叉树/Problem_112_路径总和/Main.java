package 二叉树.Problem_112_路径总和;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        // 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        // 输出：true
//        TreeNode treeNode1 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(8);
//        TreeNode treeNode4 = new TreeNode(11);
//        TreeNode treeNode5 = new TreeNode(13);
//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode8 = new TreeNode(2);
//        TreeNode treeNode9 = new TreeNode(1);
//
//        treeNode1.left = treeNode2;
//
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//
//        treeNode3.left = treeNode5;
//        treeNode3.right = treeNode6;
//
//        treeNode4.left = treeNode7;
//        treeNode4.right = treeNode8;
//
//        treeNode6.right = treeNode9;
//
//        int targetSum = 22;

        // root = [1,2], targetSum = 1
        // false
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        treeNode1.left = treeNode2;
//        int targetSum = 1;

        // root = [1], targetSum = 1
        // true
        TreeNode treeNode1 = new TreeNode(1);
        int targetSum = 1;

        treeNode = treeNode1;

        Solution solution = new Solution();
        boolean result = solution.hasPathSum(treeNode, targetSum);
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
        public boolean hasPathSum(TreeNode root, int targetSum) {

            // 二叉树为空，返回false
            if (root == null) {
                return false;
            }

            // 此节点已经是叶子节点
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    return true;
                } else {
                    return false;
                }
            }

            boolean leftResult = false;
            boolean rightResult = false;
            int sum = targetSum - root.val;

            if (root.left != null) {
                leftResult = process(root.left, sum);
            }

            if (root.right != null) {
                rightResult = process(root.right, sum);
            }

            return leftResult || rightResult;
        }

        public boolean process(TreeNode tree, int sum) {

            // 此节点已经是叶子节点
            if (tree.left == null && tree.right == null) {
                if (tree.val == sum) {
                    return true;
                } else {
                    return false;
                }
            }

            // 此节点不为叶子节点，继续检查 左子节点 和 右子节点
            boolean leftResult = false;
            boolean rightResult = false;
            sum = sum - tree.val;

            if (tree.left != null) {
                leftResult = process(tree.left, sum);
            }

            if (tree.right != null) {
                rightResult = process(tree.right, sum);
            }

            return leftResult || rightResult;
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