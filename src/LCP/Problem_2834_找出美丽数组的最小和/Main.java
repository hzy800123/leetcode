package LCP.Problem_2834_找出美丽数组的最小和;

/*
https://leetcode.cn/contest/weekly-contest-360/problems/find-the-minimum-possible-sum-of-a-beautiful-array/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 2, target = 3
        // 输出：4
//        int n = 2;
//        int target = 3;

        // 输入：n = 3, target = 3
        // 输出：8
//        int n = 3;
//        int target = 3;

        // 输入：n = 1, target = 1
        // 输出：1
//        int n = 1;
//        int target = 1;

        // 输入：n = 1000000000, target = 1000000000
        // 输出：750000042
        int n = 1000000000;
        int target = 1000000000;

        // 输入：n = 45456, target = 10867
        // 输出：250591648
//        int n = 45456;
//        int target = 10867;

        // 输入：n = 3, target = 3
        // 输出：8
//        int n = 3;
//        int target = 3;

        // 输入：n = 100000, target = 100000
        // 输出：499999951
//        int n = 100000;
//        int target = 100000;

        Solution solution = new Solution();
        int result = solution.minimumPossibleSum(n, target);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int minimumPossibleSum(int n, int target) {

            int minExclueNum = target / 2 + 1;
            long MOD_NUM = (long)Math.pow(10, 9) + 7;

            if (n == 1) {
                return 1;
            }

            long resultSum = 0;

            // 如果 n < minExclueNum，则只需要计算第一部分即可
            if (n < minExclueNum) {
                int firstNum = 1;
                int lastNum = n;

                resultSum = (firstNum + lastNum) * lastNum / 2 % MOD_NUM;

                return (int) resultSum;
            }

            // 如果 n >= minExclueNum，需要分开2部分进行计算
            // 先计算 n < minExclueNum 的第1部分
            // 注意公式：
            // 连续数字的和 = （第一个数字 + 最后一个数字）* 数字的个数 / 2     // 类似计算梯形面积的计算公式
            int firstNum = 1;
            int lastNum = minExclueNum - 1;
//             resultSum = (firstNum + lastNum) * lastNum / 2 % MOD_NUM;
            if (lastNum % 2 == 0) {
                resultSum =
                        ((firstNum + lastNum) % MOD_NUM) * (lastNum / 2 % MOD_NUM);
            } else {
                resultSum =
                        ((firstNum + lastNum) / 2 % MOD_NUM) * (lastNum % MOD_NUM);
            }

            resultSum = resultSum % MOD_NUM;

            // 再计算第2部分
            int remain = n - minExclueNum + 1;
            firstNum = target;
            lastNum = target + remain - 1;
//             resultSum = resultSum + (firstNum + lastNum) * remain / 2 % MOD_NUM;
            if (remain % 2 == 0) {
                resultSum = resultSum +
                        (firstNum % MOD_NUM + lastNum % MOD_NUM) * (remain / 2 % MOD_NUM);
            } else {
                resultSum = resultSum +
                        ((firstNum + lastNum) / 2 % MOD_NUM) * (remain % MOD_NUM);
            }

             return (int) (resultSum % MOD_NUM);
        }
    }
}