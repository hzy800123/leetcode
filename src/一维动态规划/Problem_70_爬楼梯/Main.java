package 一维动态规划.Problem_70_爬楼梯;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

/*
https://leetcode.cn/problems/climbing-stairs
 */
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

            // 如果 只剩下的楼梯台阶为 1 或 0, 只有1种方法, 返回1
            // Base Case (递归的停止条件)
            if (n == 1 || n == 0) {
                return 1;
            }

            // 定义2种可能:
            // 第一种,先走1步台阶
            // 第二种,先走2步台阶
            int p1 = 0;
            int p2 = 0;

            // 问题和子问题的关系 (递归的递推公式)
            p1 = process(n - 1);
            p2 = process(n - 2);

            // 问题的解 = 第一种可能 + 第二种可能
            return (p1 + p2);
        }

    }


    static class Solution2 {
        public int climbStairs(int n) {

            // 创建一个缓存数组
            int dp[] = new int[45];
            int result = process(n, dp);
            return result;
        }

        public int process(int n, int[] dp) {
            if (n == 1 || n == 0) {
                // 将0和1的情况,放入缓存数组中
                dp[0] = 1;
                dp[1] = 1;

                return 1;
            }

            int p1 = 0;
            int p2 = 0;

            // 先查找缓存数组中, 是否已经存在值
            // 如果有, 立即获取结果
            if (dp[n - 1] != 0) {
                p1 = dp[n - 1];
            } else {
                // 如果缓存没有, 继续计算
                // 计算后, 将结果放回缓存中
                p1 = process(n - 1, dp);
                dp[n - 1] = p1;
            }

            // 先查找缓存数组中, 是否已经存在值
            // 如果有, 立即获取结果
            if (dp[n - 2] != 0) {
                p2 = dp[n - 2];
            } else {
                // 如果缓存没有, 继续计算
                // 计算后, 将结果放回缓存中
                p2 = process(n - 2, dp);
                dp[n - 2] = p2;
            }

            // 返回 2 中可能的和
            return (p1 + p2);
        }
    }
}