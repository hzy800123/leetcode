package 数学.Problem_66.加一;

/*
https://leetcode.cn/problems/plus-one/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：digits = [1,2,3]
        // 输出：[1,2,4]
//        int[] digits = new int[]{1,2,3};

        // 输入：digits = [4,3,2,1]
        // 输出：[4,3,2,2]
//        int[] digits = new int[]{4,3,2,1};

        // 输入：digits = [0]
        // 输出：[1]
//        int[] digits = new int[]{0};

        // 输入：digits = [9]
        // 输出：[1,0]
//        int[] digits = new int[]{9};

        // 输入：digits = [9,9]
        // 输出：[1,0,0]
        int[] digits = new int[]{9,9};


        Solution solution = new Solution();
        int[] result = solution.plusOne(digits);
//        System.out.println("result = " + result);
    }

    static class Solution {

        public int[] plusOne(int[] digits) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = digits.length;
            int[] newDigits = new int[length];

            // 反转 digits数组
            for (int i = 0; i < length; i++) {
                newDigits[i] = digits[length - i - 1];
            }

            int newValue = 0;
            int carry = 0;
            int newTotal = 0;
            // 当前位新的值,为原来的值加1后,再取模10
            newTotal = newDigits[0] + 1;
            newValue = newTotal % 10;
            // 进位的值,为原来的值加1后,再整除10
            carry = newTotal / 10;
            // 直接修改 newDigits数组的值
            newDigits[0] = newValue;

            for (int j = 1; j < length; j++) {

                // 当前位新的值,为原来的值加进位的值之后,再取模10
                newTotal = newDigits[j] + carry;
                newValue = newTotal % 10;

                // 进位的之,为原来的值加进位的值之后,再整除10
                carry = newTotal / 10;

                // 直接修改 newDigits数组的值
                newDigits[j] = newValue;
            }

            int[] resultDigits;
            int start = 0;

            // 如果进位 > 0
            if (carry > 0) {
                resultDigits = new int[length + 1];
                resultDigits[0] = 1;
                start++;
            } else {
                resultDigits = new int[length];
            }

            // 再次,反转 digits数组
            for (int k = start; k < length + start; k++) {
                resultDigits[k] = newDigits[length - k + start - 1];
            }

//            for (int l = 0; l < start + length; l++) {
//                System.out.print(resultDigits[l] + ", ");
//            }

            return resultDigits;
        }
    }
}