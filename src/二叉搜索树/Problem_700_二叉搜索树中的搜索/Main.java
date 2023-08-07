package 二叉搜索树.Problem_700_二叉搜索树中的搜索;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/search-in-a-binary-search-tree/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：root = [4,2,7,1,3], val = 2
        // 输出：[2,1,3]

        TreeNode treeNode = new TreeNode();

//        TreeNode treeNode1 = new TreeNode(4);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(7);
//        TreeNode treeNode4 = new TreeNode(1);
//        TreeNode treeNode5 = new TreeNode(3);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//
//        treeNode2.left = treeNode4;
//        treeNode2.right = treeNode5;
//
//        treeNode = treeNode1;
//        int val = 2;

        // 输入：root = [4,2,7,1,3], val = 5
        // 输出：[]

        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(3);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode = treeNode1;
        int val = 5;

        Solution solution = new Solution();
        TreeNode result = solution.searchBST(treeNode, val);
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
        public TreeNode searchBST(TreeNode root, int val) {

            TreeNode resultRoot = null;

            // 如果 root == null, 表示没有找到, 返回null
            if (root == null) {
                return null;
            }

            // 如果 root.val == val, 返回当前子树的根节点root
            if (root.val == val) {
                return root;
            }

            // 二叉搜索树 递归调用
            // 如果 root.val > val, 继续查找左子树
            // 如果 root.val < val, 继续查找右子树
            if (root.val > val) {
                resultRoot = searchBST(root.left, val);
            } else {
                resultRoot = searchBST(root.right, val);
            }

            return resultRoot;
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