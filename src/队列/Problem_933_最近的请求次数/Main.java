package 队列.Problem_933_最近的请求次数;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/number-of-recent-calls/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：
        // ["RecentCounter", "ping", "ping", "ping", "ping"]
        // [[], [1], [100], [3001], [3002]]
        // 输出：
        // [null, 1, 2, 3, 3]

        int n1 = 1;
        int n2 = 100;
        int n3 = 3001;
        int n4 = 3002;

        RecentCounter recentCounter1 = new RecentCounter();
        int result1 = recentCounter1.ping1(n1);
        int result2 = recentCounter1.ping1(n2);
        int result3 = recentCounter1.ping1(n3);
        int result4 = recentCounter1.ping1(n4);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);

        System.out.println(" --- ");

        RecentCounter recentCounter2 = new RecentCounter();
        result1 = recentCounter2.ping2(n1);
        result2 = recentCounter2.ping2(n2);
        result3 = recentCounter2.ping2(n3);
        result4 = recentCounter2.ping2(n4);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

    static class RecentCounter {

        List<Integer> list = null;

        public RecentCounter() {
            list = new ArrayList<>();
        }


        public int ping1(int t) {
            list.add(t);

            int target = t - 3000;

            int countMatch = 0;
            int listLength = list.size();

            int start = 0;
            int end = listLength - 1;
            int mid = 0;

            // 采用二分搜索
            while (start < end) {
                mid = start + (end - start) / 2;

                if (list.get(mid) >= target) {
                    // 因为mid可能是答案(符合范围内的最小值),
                    // 所以这里 end = mid, 而不是 end = mid - 1
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            countMatch = listLength - end;

            return countMatch;
        }

        public int ping2(int t) {
            list.add(t);

            int target = t - 3000;

            int countMatch = 0;
            int listLength = list.size();

            // 从后向前, 遍历列表, 查找 元素时间 >= target 时间, 记录元素个数
            for (int i = listLength - 1; i >= 0; i--) {
                if (list.get(i) >= target) {
                    countMatch++;
                } else {
                    break;
                }
            }

            // 返回找到的元素个数
            return countMatch;
        }
    }
}