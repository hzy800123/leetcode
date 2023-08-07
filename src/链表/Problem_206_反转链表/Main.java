package 链表.Problem_206_反转链表;

import java.util.Stack;

/*
https://leetcode.cn/problems/linked-list-cycle/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：head = [1,2,3,4,5]
        // 输出：[5,4,3,2,1]
//        ListNode list1 = new ListNode(1);
//        ListNode list2 = new ListNode(2);
//        ListNode list3 = new ListNode(3);
//        ListNode list4 = new ListNode(4);
//        ListNode list5 = new ListNode(5);
//        list1.next = list2;
//        list2.next = list3;
//        list3.next = list4;
//        list4.next = list5;

        // 输入：head = []
        // 输出：[]
        ListNode list1 = null;

        Solution solution = new Solution();
        ListNode result1 = solution.reverseList1(list1);
        System.out.println("result1 = " + result1);
        while(result1 != null) {
            System.out.println("result1 = " + result1.val);
            result1 = result1.next;
        }

        System.out.println(" --- ");

        ListNode result2 = solution.reverseList2(list1);
        System.out.println("result2 = " + result2);
        while(result2 != null) {
            System.out.println("result2 = " + result2.val);
            result2 = result2.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static class Solution {

        public ListNode reverseList1(ListNode head) {

            // 左指针
            ListNode left = head;

            // 如果 头节点为空, 立即返回null
            if (head == null) {
                return null;
            }

            // 如果头节点不为空, 右指针 指向下一个节点
            ListNode right = left.next;

            // 临时指针, 方便反转链表元素的next值
            ListNode temp = null;
            ListNode resultList = null;

            while (right != null) {
                // 先保存 右指针的next值
                temp = right.next;
                // 修改 右指针的元素的next, 指向左指针的元素 (链表反转)
                right.next = left;
                // 左指针 向右移动一个位置
                left = right;
                // 右指针 向右移动一个位置
                right = temp;
            }

            // 最后, 遍历链表结束, 左指针 就是新的头指针
            resultList = left;

            // 新的链表的最后一个元素的next值, 修改为null
            // 避免出现 链表循环
            if (head != null) {
                head.next = null;
            }

            // 返回新的链表
            return resultList;
        }

        public ListNode reverseList2(ListNode head) {

            // 建立一个栈, 利用栈的先进后出, 达到链表的反转
            Stack<ListNode> stack = new Stack<>();
            ListNode p = head;
            ListNode resultList = null;
            ListNode q = null;

            // 遍历原来的链表, 每个元素都入栈
            while (p != null) {
                stack.push(p);
                p = p.next;
            }

            // 创建新的链表的第一个元素
            if (!stack.isEmpty()) {
                q = stack.pop();
                resultList = q;
            }

            // 栈中的元素, 逐一出栈, 建立新的链表(链表反转)
            while (!stack.isEmpty()) {
                q.next = stack.pop();
                q = q.next;
            }

            // 新的链表的最后一个元素的next值, 修改为null
            // 避免出现 链表循环
            if (q != null) {
                q.next = null;
            }

            // 返回新的链表
            return resultList;
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