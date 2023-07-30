package 数学.Problem_69_x的平方根;

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
        // 输出：2147395598
        int x = 2147395599;

        Solution solution = new Solution();
        int result0 = solution.mySqrt0(x);
        System.out.println("result0 = " + result0);

        System.out.println(" --- ");

        int result1 = solution.mySqrt1(x);
        System.out.println("result1 = " + result1);
    }

    static class Solution {

        public int mySqrt0(int x) {
            int l = 0, r = x, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return ans;

        }
        public int mySqrt1(int x) {

            if (x == 1) {
                return 1;
            }

            int half = 0;
            int start = 0;
            int end = x;
            int result = 0;

            while(start <= end) {
                half = start + (end - start) / 2;
                long halfSqrt = (long)half * half;

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
            int halfSqrt = half * half;

            if (halfSqrt == x) {
                return half;
            }

            int halfPlusOneSqrt = (half + 1) * (half + 1);
            if (halfSqrt < x && halfPlusOneSqrt > x) {
                return half;
            }

            if (halfSqrt < x) {
                return process(half + 1, end, x);
            } else {
                return process(start, half, x);
            }

        }
    }
}