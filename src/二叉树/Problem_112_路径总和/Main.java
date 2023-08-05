package 二叉树.Problem_112_路径总和;

/*
https://leetcode.cn/problems/path-sum/
 */
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

            // 此节点已经是叶子节点, 可以判断节点的值, 是否等于传入的参数targetSum
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    return true;
                } else {
                    return false;
                }
            }

            // 此节点不为叶子节点，继续检查 左子节点 和 右子节点
            boolean leftResult = false;
            boolean rightResult = false;

            // sum 等于传入的参数targetSum, 减去当前节点的值
            // 再用递归调用, 把sum继续传下去
            int sum = targetSum - root.val;

            // 左节点, 继续递归调用检查
            leftResult = hasPathSum(root.left, sum);

            // 右节点, 继续递归调用检查
            rightResult = hasPathSum(root.right, sum);

            // 左子树 和 右子树, 都需要进行检查
            // 返回的结果, 为 (左子树的结果 || 右子树的结果)
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