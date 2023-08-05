package 数学.Problem_69_x的平方根;

/*
https://leetcode.cn/problems/sqrtx/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：x = 4
        // 输出：2
//        int x = 4;

        // 输入：x = 8
        // 输出：2
//        int x = 8;

        // 输入：x = 1
        // 输出：1
//        int x = 1;

        // 输入：x = 6
        // 输出：2
//        int x = 6;

        // 输入：x = 2147395599
        // 输出：46339
        int x = 2147395599;

        Solution solution = new Solution();
        int result1 = solution.mySqrt1(x);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        int result2 = solution.mySqrt2(x);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public int mySqrt1(int x) {

            if (x == 1) {
                return 1;
            }

            int half = 0;
            int start = 0;
            int end = x;
            int result = 0;

            // 采用 二分法, 查找合适的数, 从而找到x的平方根
            while(start <= end) {
                half = start + (end - start) / 2;
                long halfSqrt = (long)half * half;

                // 根据尝试的结果, 修改下一次循环查找的 开始和结束 的位置
                if (halfSqrt <= x) {
                    result = half;
                    start = half + 1;
                } else {
                    end = half - 1;
                }
            }

            return result;
        }

        public int mySqrt2(int x) {

            if (x == 1) {
                return 1;
            }

            int start = 0;
            int end = x;
            int result = process(start, end, x);

            return result;
        }

        public int process(int start, int end, int x) {

            int half = (start + end) / 2;
            long halfSqrt = (long)half * half;

            if (halfSqrt == x) {
                return half;
            }

            long halfPlusOneSqrt = (long)(half + 1) * (half + 1);
            if (halfSqrt < x && halfPlusOneSqrt > x) {
                return half;
            }

            // 递归调用, 采取 二分法, 每次修改查找的开始和结束位置
            if (halfSqrt < x) {
                return process(half + 1, end, x);
            } else {
                return process(start, half, x);
            }

        }
    }
}