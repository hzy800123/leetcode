package 链表.Problem_141_环形链表;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：head = [3,2,0,-4], pos = 1
        // 输出：true

        ListNode list1 = new ListNode(3);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(0);
        ListNode list4 = new ListNode(-4);
        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list2;

        Solution solution = new Solution();
        boolean result = solution.hasCycle(list1);

        System.out.println("result = " + result);

//        while(result != null) {
//            System.out.println("result = " + result.val);
//            result = result.next;
//        }
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
        public boolean hasCycle(ListNode head) {

            ListNode p = head;
            HashSet<ListNode> hashSet = new HashSet();

            // 如果为空, 返回false
            if (p == null) {
                return false;
            }

            // 遍历链表的节点
            while (p != null) {
                // 如果 hashSet中包含p, 则返回true
                // 否则,把p加入hashSet,继续遍历后续的节点
                if (hashSet.contains(p)) {
                    return true;
                } else {
                    hashSet.add(p);
                    p = p.next;
                }
            }

            return false;
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