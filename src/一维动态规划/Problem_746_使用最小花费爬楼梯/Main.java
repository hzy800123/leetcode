package 一维动态规划.Problem_746_使用最小花费爬楼梯;

/*
https://leetcode.cn/problems/min-cost-climbing-stairs/
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
        int[] cost = new int[]{10,15,20};

        // 输入：cost = [1,100,1,1,1,100,1,1,100,1]
        // 输出：6
        // 解释：你将从下标为 0 的台阶开始。
//        int[] cost = new int[]{1,100,1,1,1,100,1,1,100,1};

        Solution solution = new Solution();
        int result0 = solution.minCostClimbingStairs0(cost);
        System.out.println("result0 = " + result0);

        System.out.println(" --- ");

        int result1 = solution.minCostClimbingStairs1(cost);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        int result2 = solution.minCostClimbingStairs2(cost);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public int minCostClimbingStairs0(int[] cost) {

            int costLength = cost.length;

            // 只需要创建 3个变量, 就可以不断向前滚动计算
            // 分别代表:
            // 前1步的花费, 前2步的花费, 当前步的花费
            int preStep1 = 0;
            int preStep2 = 0;
            int curStep = 0;

            // 不断循环, 从 i=2 开始, 滚动计算到 i=n 的值
            for (int i = 2; i <= costLength; i++) {
                curStep = Math.min(preStep1 + cost[i-1], preStep2 + cost[i-2]);
                preStep2 = preStep1;
                preStep1 = curStep;
            }

            return curStep;
        }

        public int minCostClimbingStairs1(int[] cost) {

            int costLength = cost.length;

            // 动态规划
            // 创建长度为 n+1 的数组 dp
            // 其中 dp[i] 表示达到下标 i 的最小花费
            int[] dp = new int[costLength + 1];

            dp[0] = 0;
            dp[1] = 0;

            // 不断循环, 从 i=2 开始, 滚动计算到 i=n 的值
            for (int i = 2; i <= costLength; i++) {
                int p1 = dp[i-1] + cost[i-1];
                int p2 = dp[i-2] + cost[i-2];
                dp[i] = Math.min(p1, p2);
            }

            return dp[costLength];
        }

        public int minCostClimbingStairs2(int[] cost) {

            int costLength = cost.length;
            int[] dp = new int[costLength + 1];

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