package 二叉树.Problem_226_翻转二叉树;

/*
https://leetcode.cn/problems/invert-binary-tree/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode treeNode = new TreeNode();

        // Input: root = [2,1,3]
        // Output: [2,3,1]

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode = treeNode1;

        Solution solution = new Solution();
        TreeNode result = solution.invertTree(treeNode);
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode temp = null;

            // 如果节点不为空, 将左右子树 交换位置
            if (root != null) {
                temp = root.left;
                root.left = root.right;
                root.right = temp;
            }

            // 递归调用, 对每一个子树, 都使用类似的方法:
            // 把 左子树 和 右子树, 交换位置
            invertTree(root.left);
            invertTree(root.right);

            return root;
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