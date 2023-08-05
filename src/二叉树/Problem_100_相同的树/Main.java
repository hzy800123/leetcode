package 二叉树.Problem_100_相同的树;

/*
https://leetcode.cn/problems/same-tree/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        TreeNode p = new TreeNode();
        TreeNode q = new TreeNode();

        // Input: p = [1,2,3], q = [1,2,3]
        // Output: true

        TreeNode treeNode1_1 = new TreeNode(1);
        TreeNode treeNode1_2 = new TreeNode(2);
        TreeNode treeNode1_3 = new TreeNode(1);
        TreeNode treeNode2_1 = new TreeNode(1);
        TreeNode treeNode2_2 = new TreeNode(1);
        TreeNode treeNode2_3 = new TreeNode(2);
        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        treeNode2_1.left = treeNode2_2;
        treeNode2_1.right = treeNode2_3;
        p = treeNode1_1;
        q = treeNode2_1;

        Solution solution = new Solution();
        boolean result = solution.isSameTree(p, q);
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
        public boolean isSameTree(TreeNode p, TreeNode q) {

            // 先判断 第一棵树 和 第二棵树, 自己根节点的各种情况
            // p 为空, q 不为空
            // p 不为空, q 为空
            if (p == null && q != null || p != null && q == null) {
                return false;
            }

            // p 为空, q 为空
            if (p == null && q == null) {
                return true;
            }

            // p 不为空, q 不为空
            // 但是 它们的值 不相等
            if (p.val != q.val) {
                return false;
            }

            // 递归调用, 判断 第一棵树的左子树 和 第二棵树的左子树, 是否相同
            if (!isSameTree(p.left, q.left)) {
               return false;
            }

            // 递归调用, 判断 第一棵树的右子树 和 第二棵树的右子树, 是否相同
            if (!isSameTree(p.right, q.right)) {
                return false;
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