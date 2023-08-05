package 数学.Problem_9_回文数;

/*
https://leetcode.cn/problems/palindrome-number/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：x = 121
        // 输出：true
        int x = 121;

        Solution solution = new Solution();
        boolean result1 = solution.isPalindrome1(x);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");
        boolean result2 = solution.isPalindrome2(x);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public boolean isPalindrome1(int x) {
            String str = String.valueOf(x);
            StringBuffer stringBuffer1 = new StringBuffer(str);

            // 利用 StringBuffer 的反转方法 reverse(), 可以方便的比较2个字符串是否互相反转
            stringBuffer1.reverse();
            String result1 = stringBuffer1.toString();

            StringBuffer stringBuffer2 = new StringBuffer(str);
            String result2 = stringBuffer2.toString();

            boolean compareResult = result1.equals(result2);

//            System.out.println("stringBuffer1 = " + stringBuffer1);
//            System.out.println("stringBuffer2 = " + stringBuffer2);
//            System.out.println("compareResult = " + compareResult);

            return compareResult;
        }

        public boolean isPalindrome2(int x) {
            boolean result = false;

            if (x < 0) {
                return false;
            } else {
                String tempStr = String.valueOf(x);
                // System.out.println("tempStr : " + x);
                result = reverseCompare(tempStr);
            }

            return result;
        }

        static boolean reverseCompare(String inputStr) {
            // 先将字符串, 转为字符数组
            char[] inputChar = inputStr.toCharArray();
            int len = inputStr.length();
            int halfLen = len / 2;

            // 然后, 头指针 和 尾指针 的元素, 进行比较, 判断是否相等
            for( int i = 0; i < halfLen; i++ ) {
                if(inputChar[i] != inputChar[len - 1 - i]) {
                    return false;
                }
            }

            return true;
        }
    }
}