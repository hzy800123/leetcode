package 数组_字符串.Problem_1431_拥有最多糖果的孩子;

/*
https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：candies = [2,3,5,1,3], extraCandies = 3
        // 输出：[true,true,true,false,true]
//        int[] candies = new int[]{2,3,5,1,3};
//        int extraCandies = 3;

        // 输入：candies = [4,2,1,1,2], extraCandies = 1
        // 输出：[true,false,false,false,false]
        int[] candies = new int[]{4,2,1,1,2};
        int extraCandies = 1;

        Solution solution = new Solution();
        List result = solution.kidsWithCandies(candies, extraCandies);
        System.out.println("result = " + result);
    }

    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            int candiesLength = candies.length;
            // 定义 目前拥有最多糖果的小孩, 所拥有的糖果数量
            int maxCandies = 0;
            List<Boolean> list = new ArrayList<>();

            // 遍历数组, 找到目前拥有最多糖果的小孩, 所拥有的糖果数量
            for (int i = 0; i < candiesLength; i++) {
                maxCandies = Math.max(maxCandies, candies[i]);
            }

            // 再次遍历数组, 判断哪些小孩, 可以给予额外的糖果, 达到最大糖果的数量
            for (int j = 0; j < candiesLength; j++) {
                // 如果 可以达到最大糖果的数量, 标记为true, 否则标记为false
                if (candies[j] + extraCandies >= maxCandies) {
                    list.add(true);
                } else {
                    list.add(false);
                }
            }

            return list;
        }
    }
}