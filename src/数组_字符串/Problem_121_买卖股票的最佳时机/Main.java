package 数组_字符串.Problem_121_买卖股票的最佳时机;

/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：[7,1,5,3,6,4]
        // 输出：5
//        int[] prices = new int[]{7,1,5,3,6,4};

        // 输入：prices = [7,6,4,3,1]
        // 输出：0
//        int[] prices = new int[]{7,6,4,3,1};

        // 输入：prices = [2,4,1]
        // 输出：2
//        int[] prices = new int[]{2,4,1};

        // 输入：prices = [7, 4, 5, 6, 7, 3, 4, 5]
        // 输出：3
//        int[] prices = new int[]{7, 4, 5, 6, 7, 3, 4, 5};

        // 输入：prices = [1,2]
        // 输出：1
        int[] prices = new int[]{1,2};

        Solution solution = new Solution();
        int result = solution.maxProfit(prices);
        System.out.println("result = " + result);
    }

    static class Solution {

        public int maxProfit(int prices[]) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;

            // 只需要遍历1次数组 prices
            for (int i = 0; i < prices.length; i++) {

                // 如果遇到最低的价格, 记录最低的价格, 保存在minprice
                if (prices[i] < minprice) {
                    minprice = prices[i];

                    // 如果不是低于最低的价格, 立即比较 当前价格 和 最低价格 的差
                    // 如果 价格差 > maxprofit, 记录获取的最大的利润值
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }

        public int maxProfit2(int[] prices) {

            int length = prices.length;
            // 设置2个新的临时数组 minBuyPrices 和 maxSellPrices
            // minBuyPrices[i] 表示 在第i天或之前 出现的最低价格
            // maxSellPrices[j] 表示 在第j天或之后 出现的最高价格
            int[] minBuyPrices = new int[length];
            int[] maxSellPrices = new int[length];
            int minPrice = Integer.MAX_VALUE;
            int maxPrice = Integer.MIN_VALUE;
            int curMaxProfit = 0;

            // 遍历数组 prices, 获取 minBuy 数组的每个元素的值
            // minBuyPrices[i] 表示 在第i天或之前出现的最低价格
            for (int i = 0; i < length - 1; i++) {
                if (minPrice > prices[i]) {
                    minPrice = prices[i];
                }
                minBuyPrices[i] = minPrice;
            }

            // 因为最后一天 不可以买入, 所以设置买入价格为Max_Value
            minBuyPrices[length - 1] = Integer.MAX_VALUE;

            // 遍历数组 prices, 获取 maxSell 数组的每个元素的值
            // maxSellPrices[j] 表示 在第j天或之后出现的最高价格
            for (int j = length - 1; j > 0; j--) {
                if (maxPrice < prices[j]) {
                    maxPrice = prices[j];
                }
                maxSellPrices[j] = maxPrice;
            }

            // 因为第一天 不可以卖出, 所以设置卖出价格为0
            maxSellPrices[0] = 0;

            /*
            数组 prices:     7 4 5 6 7 3 4 5
            数组 minBuy:     7 4 4 4 4 3 3 Max
            数组 maxSell:    0 7 7 7 7 5 5 5
            =>  Result:     0 3 3 3 1 2 2 null // maxSellPrices[k + 1] - minBuyPrices[k]
             */
            // 通过打擂台方式, 查找 前后至少2天 的最大利润的值, k天买入股票, k+1天或之后卖出股票
            for (int k = 0; k < length - 1; k++) {
                curMaxProfit = Math.max(curMaxProfit,
                        maxSellPrices[k + 1] - minBuyPrices[k]);
            }

            // 返回 最大的利润值
            return curMaxProfit;
        }
    }
}