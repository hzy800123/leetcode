package Problem_70_爬楼梯;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        int n = 45; // result = 1836311903

        Instant start2 = Instant.now();
        Solution2 solution2 = new Solution2();
        int result2 = solution2.climbStairs(n);
        Instant end2 = Instant.now();
        Duration costTime2 = Duration.between(start2, end2);

        System.out.println("result2 = " + result2);
        System.out.println("Cost Time 2 : " + costTime2);

        System.out.println(" --- ");

        Instant start1 = Instant.now();
//        LocalDateTime start = LocalDateTime.now();
        Solution1 solution1 = new Solution1();
        int result1 = solution1.climbStairs(n);
        Instant end1 = Instant.now();
//        LocalDateTime end = LocalDateTime.now();
        Duration costTime1 = Duration.between(start1, end1);
        System.out.println("result1 = " + result1);
        System.out.println("Cost Time 1 : " + costTime1);
    }

    static class Solution1 {
        public int climbStairs(int n) {
            int result = process(n);
            return result;
        }

        public int process(int n) {
            if (n == 1 || n == 0) {
                return 1;
            }

            int p1 = 0;
            int p2 = 0;

            p1 = process(n - 1);
            p2 = process(n - 2);

            return (p1 + p2);
        }

    }


    static class Solution2 {
        public int climbStairs(int n) {

            int dp[] = new int[45];
            int result = process(n, dp);
            return result;
        }

        public int process(int n, int[] dp) {
            if (n == 1 || n == 0) {
                dp[0] = 1;
                dp[1] = 1;

                return 1;
            }

            int p1 = 0;
            int p2 = 0;

            if (dp[n - 1] != 0) {
                p1 = dp[n - 1];
            } else {
                p1 = process(n - 1, dp);
                dp[n - 1] = p1;
            }

            if (dp[n - 2] != 0) {
                p2 = dp[n - 2];
            } else {
                p2 = process(n - 2, dp);
                dp[n - 2] = p2;
            }

            return (p1 + p2);
        }
    }
}