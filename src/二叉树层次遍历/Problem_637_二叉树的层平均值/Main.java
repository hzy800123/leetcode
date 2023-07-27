package 二叉树层次遍历.Problem_637_二叉树的层平均值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

//        TreeNode treeNode1 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(9);
//        TreeNode treeNode3 = new TreeNode(20);
//        TreeNode treeNode4 = new TreeNode(15);
//        TreeNode treeNode5 = new TreeNode(7);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;

        // [2147483647,2147483647,2147483647]
        TreeNode treeNode1 = new TreeNode(2147483647);
        TreeNode treeNode2 = new TreeNode(2147483647);
        TreeNode treeNode3 = new TreeNode(2147483647);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode = treeNode1;

        Solution solution = new Solution();
        List<Double> result = solution.averageOfLevels(treeNode);
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
        public List<Double> averageOfLevels(TreeNode root) {

            List<Double> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(null);
            queue.add(root);

            long sum = 0;
            int count = 0;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                // 如果是分隔符null，直接再添加到队列尾部
                if (node == null) {
                    if (queue.isEmpty() && count == 0) {
                        break;
                    } else {
                        queue.add(null);

                        if (count > 0) {
                            // 计算 平均值
                            double aver = sum * 1.0 / count;
                            list.add(aver);
                        }

                        // 重置sum，count为0
                        sum = 0;
                        count = 0;
                        continue;
                    }
                }

                sum = sum + node.val;
                count++;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            return list;
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