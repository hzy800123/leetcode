package 链表.Problem_160_相交链表;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：intersectVal = 8,
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5],
        // skipA = 2, skipB = 3
        // 输出：Intersected at '8'

        ListNode list1_1 = new ListNode(4);
        ListNode list1_2 = new ListNode(1);
        ListNode list1_3 = new ListNode(8);
        ListNode list1_4 = new ListNode(4);
        ListNode list1_5 = new ListNode(5);
        list1_1.next = list1_2;
        list1_2.next = list1_3;
        list1_3.next = list1_4;
        list1_4.next = list1_5;

        ListNode list2_1 = new ListNode(5);
        ListNode list2_2 = new ListNode(6);
        ListNode list2_3 = new ListNode(1);
        list2_1.next = list2_2;
        list2_2.next = list2_3;
        list2_3.next = list1_3;

        Solution solution = new Solution();
        ListNode result = solution.getIntersectionNode1(list1_1, list2_1);

        System.out.println("result = " + result);

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
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public static class Solution {

        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            // 设置2个指针
            // 分别遍历A链表和B链表
            ListNode pA = headA, pB = headB;

            // 如果当前的链表遍历结束, 重新开始遍历另外一条链表
            // (1) 如果2条链表有相同的节点, 2个指针最后必然同时指向相同的节点, 即指针相遇.
            //     例如: A链表: a + c, B链表: b + c
            //     遍历一次后, 再次遍历另外一个链表, 而且指针相遇时, 必然有:
            //     a + c + b = b + c + a
            // (2) 如果没有相同的节点, 最后也可以返回null
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }

            return pA;
        }

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

            ListNode pAList = headA;
            ListNode pBList = headB;
            // 建立一个哈希集合 hashSet, 保存每个节点的位置(指针)
            Set hashSet = new HashSet();

            // 先把A链表的全部节点的位置(指针), 保存在hashSet中
            while (pAList != null) {
                hashSet.add(pAList);
                pAList = pAList.next;
            }

            // 再遍历B链表, 判断是否有相同的位置(指针), 有则返回公共的节点
            // 时间负责度: O(m + n)
            // 空间复杂度: O(n)
            while (pBList != null) {
                if (hashSet.contains(pBList)) {
                    return pBList;
                } else {
                    pBList = pBList.next;
                }
            }

            return null;
        }
    }


     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}