package 二叉树层次遍历.Problem_637_二叉树的层平均值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.cn/problems/average-of-levels-in-binary-tree/
 */
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

            // 使用 list, 保存每一层的节点的平均值
            List<Double> list = new ArrayList<>();

            // 使用 队列queue, 先进先出, 遍历二叉树的每一层的节点
            Queue<TreeNode> queue = new LinkedList<>();

            // 先如队一个分割符 null, 用于分割在queue中的每一层的节点
            queue.add(null);
            // 再把根节点 入队
            queue.add(root);

            // 保存值累加的和
            long sum = 0;
            // 保存元素的个数
            int count = 0;

            while (!queue.isEmpty()) {
                // 取出队列queue中的元素, 判断是否为分割副null
                // 如果遇到分割符, 可以计算一层的平均值
                // 如果不是分割符, 可以继续累 加节点的和 以及 节点的个数
                TreeNode node = queue.poll();

                // 如果是分隔符null，直接再添加到队列尾部
                if (node == null) {

                    // 如果队列为空，而且count为0，直接返回
                    if (queue.isEmpty() && count == 0) {
                        break;
                    } else {
                        queue.add(null);

                        // 如果元素的个数 > 0
                        if (count > 0) {
                            // 计算 平均值
                            double aver = sum * 1.0 / count;
                            list.add(aver);

                            // 计算完一层的结果之后, 重置sum，count为0
                            sum = 0;
                            count = 0;
                        }

                        continue;
                    }
                }

                // 以下逻辑, 代表 没有遇到分割符号null, 继续累加
                sum = sum + node.val;
                count++;

                // 每次处理完一个节点, 都需要把它的2个子结点 入队queue, 方便后续处理
                // 如果左节点不为空, 左节点 入队queue
                if (node.left != null) {
                    queue.add(node.left);
                }

                // 如果右节点不为空, 右节点 入队queue
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