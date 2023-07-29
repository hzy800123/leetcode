package 二叉树.Problem_94_二叉树的中序遍历;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        // Input: root = [1,null,2,3]
        // Output: [1,3,2]

//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        treeNode1.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode = treeNode1;

        // Input: root = []
        // Output: []

//        TreeNode treeNode1 = null;
//        treeNode = treeNode1;

        // Input: root = [1]
        // Output: [1]

        TreeNode treeNode1 = new TreeNode(1);
        treeNode = treeNode1;

        Solution solution = new Solution();
        List<Integer> result = solution.inorderTraversal(treeNode);
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
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new LinkedList<>();
            list = process(root, list);
            return list;
        }

        public List<Integer> process(TreeNode tree, List<Integer> list) {
            if (tree == null) {
                return list;
            }

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