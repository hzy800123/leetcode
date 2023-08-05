package 位运算.Problem_190_颠倒二进制位;

/*
https://leetcode.cn/problems/reverse-bits/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 00000010100101000001111010011100
        // 输出：964176192 (00111001011110000010100101000000)
        // 解释：
        // 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
        // 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
        int n = 43261596;

        // 输入：n = 11111111111111111111111111111101
        // 输出：3221225471 (10111111111111111111111111111111)
        // 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
        // 因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
//        int n = 4294967293;

        Solution solution = new Solution();
        int result = solution.reverseBits(n);
        System.out.println("result = " + result);
    }

    static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {

            // 十进制的整数的反转
//            int ret = 0;
//            for (int i = 0; i < 32; i++) {
//                ret = (ret * 2) + (n % 2);
//                n = n / 2;
//            }
//            return ret;

            // 二进制的数的反转
            int result = 0;
            int p1 = 0;
            int p2 = 0;

            // 遍历循环32次,每次都是:
            // (1) n 先模2, 获取最低位的值, 再不断右移 /2
            // (2) 结果不断 *2, 再加上模2的结果
            for (int i = 0; i < 32; i++) {
                // 算术左移一位, 等于: result * 2
                p1 = result << 1;

                // 与运算:&1, 等于除以2,求余数 (模2-%2), 或者获取最低位的值
                p2 = n & 1;

                // 加上 模2的结果
                result = p1 + p2;

                // 算术右移一位, 等于 /2
                n = n >> 1;
            }

            return result;
        }
    }

}