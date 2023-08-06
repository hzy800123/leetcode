package 二分查找.Problem_374_猜数字大小;


/*
https://leetcode.cn/problems/guess-number-higher-or-lower/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入: nums = [1,3,5,6], target = 5
        // 输出: 2
//        int nums[] = new int[]{1,3,5,6};
//        int target = 5;

        // 输入: nums = [1,3,5,6], target = 2
        // 输出: 1
//        int nums[] = new int[]{1,3,5,6};
//        int target = 2;

        // 输入：n = 10, pick = 6
        // 输出：6
        int n = 10;

        Solution solution = new Solution();
        int result = solution.guessNumber(n);
        System.out.println("result = " + result);
    }

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    static class Solution {
        public int guessNumber(int n) {

            int guessResult = 0;
            int start = 1;
            int end = n;
            int mid = 0;

            // 不断循环, 二分查找
            while (start <= end) {
                // 注意: 为了防止数字太大, 发生溢出
                // 不要使用: mid = ( start + end ) / 2
                // 需要使用: mid = start + ( end - start ) / 2
                mid = start + (end - start) / 2;
                guessResult = guess(mid);

                if (guessResult == 0) {
                    return mid;
                }

                if (guessResult > 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return 1;
        }

        public int guess(int temp) {

            return 1;
        }
    }
}