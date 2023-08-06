package 位运算.Problem_338_比特位计数;

/*
https://leetcode.cn/problems/counting-bits/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 2
        // 输出：[0,1,1]
//        int n = 2;

        // 输入：n = 5
        // 输出：[0,1,1,2,1,2]
        int n = 5;

        Solution solution = new Solution();
        int[] result = solution.countBits(n);

        for (int j = 0; j <= n; j++) {
            System.out.println(result[j]);
        }
    }

    static class Solution {
        // you need treat n as an unsigned value

        public int[] countBits(int n) {

            // 设置数组, 长度是 n+1, 从0到n
            int[] results = new int[n + 1];

            // 遍历计算, 从0到n
            for (int i = 0; i <= n; i++) {
                results[i] = calculateBits(i, results);
            }

            return results;
        }

        /*
        每一个数字, 不需要不断的循环: 除以2, 每次循环判断取模2的余数, 直到除到0
        因为可以使用之前计算的保存结果, 即数组 results[i], 就可以达到时间复杂度O(n):
        每个数字, 只需要一次判断"取模2, 余数是否为0", 就得到结果
         */
        public int calculateBits(int n, int[] results) {

            // 如果是奇数, 模2余1, 结果等于: 除以2之后的数字的结果 + 1
            if (n % 2 != 0) {
                n = n / 2;
                return results[n] + 1;
            } else {
                // 如果是偶数, 模2余0, 结果等于: 除以2之后的数字的结果
                n = n / 2;
                return results[n];
            }
        }
    }
}