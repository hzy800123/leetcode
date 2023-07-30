package 数学.Problem_9_回文数;

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
            char[] inputChar = inputStr.toCharArray();
            int len = inputStr.length();
            int halfLen = len / 2;

            for( int i = 0; i < halfLen; i++ ) {
                if(inputChar[i] != inputChar[len - 1 - i]) {
                    return false;
                }
            }

            return true;
        }
    }
}