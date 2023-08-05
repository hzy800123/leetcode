package 二叉搜索树.Problem_530_二叉搜索树的最小绝对差;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/minimum-absolute-difference-in-bst
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode = treeNode1;

        Solution solution = new Solution();
        int result = solution.getMinimumDifference(treeNode);
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
        public int getMinimumDifference(TreeNode root) {

            List<Integer> list = new ArrayList<>();

            list = process(root, list);

            // 设置一个临时的min, 初始值是Integer.MAX_VALUE,
            // 用于后面的遍历队列, 每次打擂台, 留下最小值
            int min = Integer.MAX_VALUE;

            // 把 二叉搜索树 进行 中序遍历后, 全部都放入队列中
            // 队列中的元素已经有序, 可以遍历一次, 找出最小的'绝对值差'
            for (int i = 0; i < list.size() - 1; i++) {
                int p = list.get(i);
                int q = list.get(i + 1);

                int result = q - p;
                min = Math.min(min, result);
            }

            return min;
        }

        public List<Integer> process(TreeNode tree, List<Integer> list) {

            if (tree == null) {
                return list;
            }

            // 使用 队列list, 先把 二叉搜索树 进行 中序遍历(左-中-右),
            // 全部的节点都放入队列中
            // 中序遍历: 左子树 -> 根节点 -> 右子树
            process(tree.left, list);
            list.add(tree.val);
            process(tree.right, list);

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