package 数组_字符串.Problem_605_种花问题;

/*
https://leetcode.cn/problems/can-place-flowers/
 */
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：flowerbed = [1,0,0,0,1], n = 1
        // 输出：true
//        int[] flowerbed = new int[]{1,0,0,0,1};
//        int n = 1;

        // 输入：flowerbed = [1,0,0,0,1], n = 2
        // 输出：false
//        int[] flowerbed = new int[]{1,0,0,0,1};
//        int n = 2;

        // 输入：flowerbed = [0,0,1,0,1], n = 1
        // 输出：true
//        int[] flowerbed = new int[]{0,0,1,0,1};
//        int n = 1;

        // 输入：flowerbed = [1,0,0,0,1,0,0], n = 2
        // 输出：true
//        int[] flowerbed = new int[]{1,0,0,0,1,0,0};
//        int n = 2;

        Solution solution = new Solution();
        boolean result = solution.canPlaceFlowers(flowerbed, n);
        System.out.println("result = " + result);
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {

            int flowerbedLength = flowerbed.length;
            // 记录每次遇到连续0的长度, 此位置可能可以种花
            // 因为从数组第一位开始, 就可以考虑种花, 所以zeroSum初始值设为1
            int zeroSum = 1;
            // 记录当前可以种花的总数量
            int count = 0;

            // 遍历数组 (数组 只包含0或1)
            for (int i = 0; i < flowerbedLength; i++) {
                // 如果遇到0, zeroSum+1
                if (flowerbed[i] == 0) {
                    zeroSum++;

                } else {
                    // 如果遇到1, 判断zeroSum是否>=3, 才进行计算可以种花的数量
                    // 如果zeroSum<=2, 不可能种花
                    if (zeroSum >= 3) {
                        count = count + (zeroSum - 1)/2;
                    }

                    // 计算完毕, 重置zeroSum为0
                    zeroSum = 0;
                }
            }

            // 因为 如果数组的最后2位为0, 那么最后的1位, 也可以种花
            if (zeroSum >= 2) {
                zeroSum++;
                count = count + (zeroSum - 1)/2;
            }

            // 如果 可以种花的数量 >= n, 返回true, 否则返回false
            boolean result = (count >= n) ? true : false;

            return result;
        }
    }
}