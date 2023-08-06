package 一维动态规划.Problem_1137_第N个泰波那契数;

/*
https://leetcode.cn/problems/n-th-tribonacci-number/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 4
        // 输出：4
//        int n = 4;

        // 输入：n = 25
        // 输出：1389537
//        int n = 25;

        // 输入：n = 35
        // 输出：615693474
        int n = 35;

        Solution solution = new Solution();
        int result0 = solution.tribonacci0(n);
        System.out.println("result0 = " + result0);

        System.out.println(" --- ");

        int result1 = solution.tribonacci1(n);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        int result2 = solution.tribonacci2(n);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public int tribonacci0(int n) {

            // 定义 4个临时变量, 用于向前滚动计算
            // 分别代表:
            // 前1个的数字, 前2个的数字, 前3个的数字, 当前的数字
            int preNum1 = 1;
            int preNum2 = 1;
            int preNum3 = 0;
            int curNum = 0;

            if (n == 0) {
                return 0;
            }

            if (n == 1 || n == 2) {
                return 1;
            }

            // 从 数字3 开始, 直到 数字n, 向前滚动计算
            for (int i = 3; i <= n; i++) {
                curNum = preNum1 + preNum2 + preNum3;
                preNum3 = preNum2;
                preNum2 = preNum1;
                preNum1 = curNum;
            }

            return curNum;
        }

        public int tribonacci1(int n) {

            // 创建一个临时数组, 长度是38, 因为题目规定: 0 <= n <= 37
            int[] answers = new int[38];

            // 初始化 数组的前3个元素的值
            answers[0] = 0;
            answers[1] = 1;
            answers[2] = 1;

            // 从 数字3开始, 到 数字n, 向前滚动计算
            for (int i = 3; i <= n; i++) {
                answers[i] = answers[i - 3] + answers[i - 2] + answers[i - 1];
            }

            return answers[n];
        }

        public int tribonacci2(int n) {

            int[] answers = new int[38];
            answers[0] = 0;
            answers[1] = 1;
            answers[2] = 1;

            int result = calculate(n, answers);

            return result;
        }

        public int calculate(int n, int[] answers) {

            if (answers[n] != 0) {
                return answers[n];
            }

            //  Tn+3 = Tn + Tn+1 + Tn+2
            if (n == 0) {
                return 0;
            }

            if (n == 1 || n == 2) {
                return 1;
            }

            int preN1 = calculate(n - 1, answers);
            int preN2 = calculate(n - 2, answers);
            int preN3 = calculate(n - 3, answers);

            answers[n] = preN1 + preN2 + preN3;

            return preN1 + preN2 + preN3;
        }

    }

}