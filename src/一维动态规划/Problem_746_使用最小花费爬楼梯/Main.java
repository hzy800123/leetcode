package 一维动态规划.Problem_746_使用最小花费爬楼梯;

import java.time.Duration;
import java.time.Instant;

/*
https://leetcode.cn/problems/climbing-stairs
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：cost = [10,15,20]
        // 输出：15
        // 解释：你将从下标为 1 的台阶开始。
        // - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
        // 总花费为 15 。
//        int[] cost = new int[]{10,15,20};

        // 输入：cost = [1,100,1,1,1,100,1,1,100,1]
        // 输出：6
        // 解释：你将从下标为 0 的台阶开始。
        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};

//        Instant start1 = Instant.now();
//        LocalDateTime start = LocalDateTime.now();
        Solution1 solution1 = new Solution1();
        int result1 = solution1.minCostClimbingStairs(cost);
//        Instant end1 = Instant.now();
//        LocalDateTime end = LocalDateTime.now();
//        Duration costTime1 = Duration.between(start1, end1);
        System.out.println("result1 = " + result1);
//        System.out.println("Cost Time 1 : " + costTime1);
    }

    static class Solution1 {
        public int minCostClimbingStairs(int[] cost) {

            int costLength = cost.length;
            int[] dp = new int[1000];

            int p1 = process(cost, costLength - 1, dp) + cost[costLength - 1];
            int p2 = process(cost, costLength - 2, dp) + cost[costLength - 2];

            return Math.min(p1, p2);
        }

        public int process(int[] cost, int n, int[] dp) {

            // 先查找缓存dp数组, 如果找到, 立即返回缓存的值
            // 如果找不到, 继续计算
            if (dp[n] != 0) {
                return dp[n];
            }

            if (n == 0) {
                // 返回之前, 保存在缓存中
                dp[0] = 0;
                return 0;
            }

            if (n == 1) {
                // 返回之前, 保存在缓存中
                dp[1] = 0;
                return 0;
            }

            // 计算 前一步的值
            int preStep1 = n - 1;
            int p1 = process(cost, preStep1, dp) + cost[preStep1];

            // 计算 前两步的值
            int preStep2 = n - 2;
            int p2 = process(cost, preStep2, dp) + cost[preStep2];

            // 返回之前, 把计算结果较小的值, 保存在缓存中
            dp[n] = Math.min(p1, p2);

            return Math.min(p1, p2);
        }

    }

}