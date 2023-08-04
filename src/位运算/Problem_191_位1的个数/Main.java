package 位运算.Problem_191_位1的个数;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 00000000000000000000000000001011
        // 输出：3
        // 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
        int n = 11;

        Solution solution = new Solution();
        int result1 = solution.hammingWeight1(n);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        int result2 = solution.hammingWeight2(n);
        System.out.println("result2 = " + result2);
    }

    static class Solution {
        // you need treat n as an unsigned value

        public int hammingWeight1(int n) {

            // 记录1的次数
            int countOne = 0;

            // 遍历32次, 因为输入的是32为的二进制的数字
            for (int i = 0; i < 32; i++) {

                // 如果 与运算&1, 获取最低位为1, countOne加一
                if ((n & 1) == 1) {
                    countOne++;
                }

                // 算术右移1位, 等于 /2
                n = n >> 1;

                // 如果 新的数字 等于0, 可以立即返回 countOne
                if (n == 0) {
                    return countOne;
                }

            }

            return countOne;
        }


        public int hammingWeight2(int n) {

            int tempN = n;
            int current = 0;
            // 记录1的次数
            int countOne = 0;

            // 因为输入的是32位的长度的二进制数字, 循环32次遍历
            for (int i = 0; i < 32; i++) {

                // 与运算 &1, 获取最低位
                current = tempN & 1;
                // 如果 最低位等于1, countOne++
                if (current == 1) {
                    countOne++;
                }
                // 算术右移一位, 等于 /2
                tempN = tempN >> 1;
            }

            return countOne;
        }
    }
}