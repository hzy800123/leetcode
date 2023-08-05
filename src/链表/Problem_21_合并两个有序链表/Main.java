package 链表.Problem_21_合并两个有序链表;

/*
https://leetcode.cn/problems/merge-two-sorted-lists/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // Input: list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]

        ListNode list1_1 = new ListNode(1, null);
        ListNode list1_2 = new ListNode(2, null);
        ListNode list1_3 = new ListNode(4, null);
        list1_1.next = list1_2;
        list1_2.next = list1_3;

        ListNode list2_1 = new ListNode(1, null);
        ListNode list2_2 = new ListNode(3, null);
        ListNode list2_3 = new ListNode(4, null);
        list2_1.next = list2_2;
        list2_2.next = list2_3;

        ListNode list1 = list1_1;
        ListNode list2 = list2_1;

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(list1, list2);

        while(result != null) {
            System.out.println("result = " + result.val);
            result = result.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode resultList = null;
            ListNode resultTemp = null;
            // 定义2个指针, 分别指向2个链表
            ListNode l1Temp = list1;
            ListNode l2Temp = list2;

            // 先选择第一个头节点
            if (l1Temp != null && l2Temp != null) {
                if (l1Temp.val <= l2Temp.val) {
                    resultList = l1Temp;
                    l1Temp = l1Temp.next;
                } else {
                    resultList = l2Temp;
                    l2Temp = l2Temp.next;
                }
                resultTemp = resultList;
            }

            // 循环遍历 2个链表, 并根据各个节点的值, 比较大小, 然后选择较小的加入到新的链表
            while (l1Temp != null && l2Temp != null) {
                if (l1Temp.val <= l2Temp.val) {
                    resultTemp.next = l1Temp;
                    resultTemp = l1Temp;
                    l1Temp = l1Temp.next;
                } else {
                    resultTemp.next = l2Temp;
                    resultTemp = l2Temp;
                    l2Temp = l2Temp.next;
                }
            }

            // 处理list2剩余的节点
            if (l1Temp == null && l2Temp != null) {
                if (resultList == null) {
                    resultList = l2Temp;
                } else {
                    resultTemp.next = l2Temp;
                }
            }

            // 处理list1剩余的节点
            if (l2Temp == null && l1Temp != null) {
                if (resultList == null) {
                    resultList = l1Temp;
                } else {
                    resultTemp.next = l1Temp;
                }
            }

            return resultList;
        }
    }


     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}