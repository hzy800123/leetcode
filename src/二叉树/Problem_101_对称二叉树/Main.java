package 二叉树.Problem_101_对称二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        // Input: root = [1,2,2,3,4,4,3]
        // Output: true

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(4);
//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(3);
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//        treeNode3.left = treeNode6;
//        treeNode3.right = treeNode7;

        // [1,0]
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(0);
//        treeNode1.left = treeNode2;

        // [1]
        TreeNode treeNode1 = new TreeNode(1);

        treeNode = treeNode1;

        Solution solution = new Solution();
        boolean result = solution.isSymmetric1(treeNode);
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

        public boolean isSymmetric1(TreeNode root) {

            // 根节点为空
            if (root == null) {
                return true;
            }

            return checkSame(root.left, root.right);
        }

        // 递归调用
        public boolean checkSame(TreeNode leftTree, TreeNode rightTree) {

            if (leftTree == null && rightTree == null) {
                return true;
            }

            if (leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
                return false;
            }

            if (leftTree.val != rightTree.val) {
                return false;
            }

            // 递归调用，检查左节点的左子树 和 右节点的右子树
            boolean result1 = checkSame(leftTree.left, rightTree.right);

            // 递归调用，检查左节点的右子树 和 右节点的左子树
            boolean result2 = checkSame(leftTree.right, rightTree.left);

            return result1 && result2;
        }


        // 使用队列，广度优先，搜索二叉树的节点
        public boolean isSymmetric2(TreeNode root) {

            // 广度优先 搜索二叉树，使用队列 Queue - LinkedList
            Queue<TreeNode> queue = new LinkedList<>();

            // 根节点为空
            if (root == null) {
                return true;
            }

            // 左节点 入队列
            // 右节点 入队列
            queue.add(root.left);
            queue.add(root.right);

            while(!queue.isEmpty()) {
                TreeNode leftNode = queue.poll();
                TreeNode rightNode = queue.poll();

                // 如果 左节点为空，右节点为空，继续循环
                if (leftNode == null && rightNode == null) {
                    continue;
                }

                // 如果 左节点为空，右节点不为空，返回false
                // 或 如果 左节点不为空，右节点为空，返回false
                if (leftNode == null && rightNode != null || leftNode != null && rightNode == null) {
                    return false;
                }

                // 如果2个节点都不为空，比较它们的值，如不相等，返回false
                if (leftNode.val != rightNode.val) {
                    return false;
                }

                // 左节点的左子树 入队列
                // 右节点的右子树 入队列
                queue.add(leftNode.left);
                queue.add(rightNode.right);

                // 左节点的右子树 入队列
                // 右节点的左子树 入队列
                queue.add(leftNode.right);
                queue.add(rightNode.left);
            }

            return true;
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