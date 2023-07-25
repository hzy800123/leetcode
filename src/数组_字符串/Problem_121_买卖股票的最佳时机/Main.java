package 数组_字符串.Problem_121_买卖股票的最佳时机;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

//    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//    int[] prices = new int[]{1};
        int[] prices = new int[]{2, 1, 2, 1, 0, 1, 2};

//    int[] prices = new int[]{2,1,2,1,0,1,2,1,2};

        Solution solution = new Solution();
        int result = solution.maxProfit(prices);
        System.out.println("result = " + result);
    }

    static class Solution {
        public int maxProfit(int[] prices) {

            int[] result = new int[2];
            int max = 0;
            int N = prices.length;
//      int dp_L[][] = new int[N][N];
//      int dp_H[][] = new int[N][N];
            int dp[][] = new int[N][N];

            for (int i = 0; i < prices.length - 1; i++) {
//        result = process(prices, i, prices.length - 1, dp_L, dp_H);
                result = process(prices, i, prices.length - 1, dp);
                max = Math.max(result[1] - result[0], max);
            }

            return max;

        }

        //    public int[] process(int[] prices, int start, int end, int[][] dp_L, int[][] dp_H) {
        public int[] process(int[] prices, int start, int end, int[][] dp) {

            int[] result = new int[2];

//      if(dp_L[start][end] != 0 && dp_H[start][end] != 0) {
//        result[0] = dp_L[start][end];
//        result[1] = dp_H[start][end];
//        return result;
//      }

            if (dp[start][end] != 0) {
                result[0] = dp[start][end] / 100000;
                result[1] = dp[start][end] - result[0];
                return result;
            }


            if (start == end) {
                result[0] = prices[start];
                result[1] = prices[start];

//        dp_L[start][end] = result[0];
//        dp_H[start][end] = result[1];
                dp[start][end] = result[0] * 100000;
                dp[start][end] = dp[start][end] + result[1];

                return result;
            }

            if (end - start == 1) {

                if (prices[0] > prices[1]) {
                    result[0] = prices[end];
                    result[1] = prices[end];
                } else {
                    result[0] = prices[start];
                    result[1] = prices[end];
                }

//        dp_L[start][end] = result[0];
//        dp_H[start][end] = result[1];
                dp[start][end] = result[0] * 100000;
                dp[start][end] = dp[start][end] + result[1];

                return result;
            }

//      result = process(prices, start, end - 1, dp_L, dp_H);
            result = process(prices, start, end - 1, dp);

            if (result[1] < prices[end]) {
                result[1] = prices[end];
            }

//      dp_L[start][end] = result[0];
//      dp_H[start][end] = result[1];
            dp[start][end] = result[0] * 100000;
            dp[start][end] = dp[start][end] + result[1];

            return result;
        }
    }
}