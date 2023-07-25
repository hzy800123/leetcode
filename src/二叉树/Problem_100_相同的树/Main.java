package 二叉树.Problem_100_相同的树;

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

            if (p == null && q != null || p != null && q == null) {
                return false;
            }

            if (p == null && q == null) {
                return true;
            }

            if (p.val != q.val) {
                return false;
            }

            if (!isSameTree(p.left, q.left)) {
               return false;
            }
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