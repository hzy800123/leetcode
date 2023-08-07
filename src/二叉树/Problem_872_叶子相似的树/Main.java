package 二叉树.Problem_872_叶子相似的树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.cn/problems/leaf-similar-trees/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：
        // root1 = [3,5,1,6,2,9,8,null,null,7,4],
        // root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        // 输出：true

//        TreeNode root1 = new TreeNode();
//        TreeNode treeNode1_1 = new TreeNode(3);
//        TreeNode treeNode1_2 = new TreeNode(5);
//        TreeNode treeNode1_3 = new TreeNode(1);
//        TreeNode treeNode1_4 = new TreeNode(6);
//        TreeNode treeNode1_5 = new TreeNode(2);
//        TreeNode treeNode1_6 = new TreeNode(9);
//        TreeNode treeNode1_7 = new TreeNode(8);
//        TreeNode treeNode1_8 = new TreeNode(7);
//        TreeNode treeNode1_9 = new TreeNode(4);
//
//        treeNode1_1.left = treeNode1_2;
//        treeNode1_1.right = treeNode1_3;
//        treeNode1_2.left = treeNode1_4;
//        treeNode1_2.right = treeNode1_5;
//        treeNode1_3.left = treeNode1_6;
//        treeNode1_3.right = treeNode1_7;
//        treeNode1_5.left = treeNode1_8;
//        treeNode1_5.right = treeNode1_9;
//        root1 = treeNode1_1;
//
//        TreeNode root2 = new TreeNode();
//        TreeNode treeNode2_1 = new TreeNode(3);
//        TreeNode treeNode2_2 = new TreeNode(5);
//        TreeNode treeNode2_3 = new TreeNode(1);
//        TreeNode treeNode2_4 = new TreeNode(6);
//        TreeNode treeNode2_5 = new TreeNode(7);
//        TreeNode treeNode2_6 = new TreeNode(4);
//        TreeNode treeNode2_7 = new TreeNode(2);
//        TreeNode treeNode2_8 = new TreeNode(9);
//        TreeNode treeNode2_9 = new TreeNode(8);
//
//        treeNode2_1.left = treeNode2_2;
//        treeNode2_1.right = treeNode2_3;
//        treeNode2_2.left = treeNode2_4;
//        treeNode2_2.right = treeNode2_5;
//        treeNode2_3.left = treeNode2_6;
//        treeNode2_3.right = treeNode2_7;
//        treeNode2_7.left = treeNode2_8;
//        treeNode2_7.right = treeNode2_9;
//        root2 = treeNode2_1;

        // 输入：root1 = [1,2,3], root2 = [1,3,2]
        // 输出：false

        TreeNode root1 = new TreeNode();
        TreeNode treeNode1_1 = new TreeNode(1);
        TreeNode treeNode1_2 = new TreeNode(2);
        TreeNode treeNode1_3 = new TreeNode(3);

        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        root1 = treeNode1_1;

        TreeNode root2 = new TreeNode();
        TreeNode treeNode2_1 = new TreeNode(1);
        TreeNode treeNode2_2 = new TreeNode(3);
        TreeNode treeNode2_3 = new TreeNode(2);

        treeNode2_1.left = treeNode2_2;
        treeNode2_1.right = treeNode2_3;
        root2 = treeNode2_1;

        Solution solution = new Solution();
        boolean result = solution.leafSimilar(root1, root2);
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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            process(root1, list1);
            process(root2, list2);

            // list 对象可以直接比较 是否相等
            boolean result = list1.equals(list2);

//            boolean result = true;
//            if (list1.size() != list2.size()) {
//                return false;
//            }
//
//            for (int i = 0; i < list1.size(); i++) {
//                if (list1.get(i) != list2.get(i)) {
//                    return false;
//                }
//            }

            return result;
        }

        public void process(TreeNode root, List<Integer> list) {

            // 如果 子树为空, 立即返回
            if (root == null) {
                return;
            }

            // 如果 遇到叶子节点, 保存val到列表list中
            if (root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }

            // 如果 左子节点不为空, 继续递归调用, 检查左子树
            if (root.left != null) {
                process(root.left, list);
            }

            // 如果 右子节点不为空, 继续递归调用, 检查右子树
            if (root.right != null) {
                process(root.right, list);
            }
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