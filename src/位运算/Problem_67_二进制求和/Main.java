package 位运算.Problem_67_二进制求和;

import javax.swing.*;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入: a = "11", b = "1"
        // 输出: "100"
        String a = "11";
        String b = "1";

        // 输入：a = "1010", b = "1011"
        // 输出："10101"
//        String a = "1010";
//        String b = "1011";

        // 输入：a = "0", b = "0"
        // 输出："0"
//        String a = "0";
//        String b = "0";

        // 输入：a = "1", b = "111"
        // 输出："1000"
//        String a = "1";
//        String b = "111";

        // 输入：a = "100", b = "110010"
        // 输出："110110"
//        String a = "100";
//        String b = "110010";

        // 输入：a = "101111", b = "10"
        // 输出："110001"
//        String a = "101111";
//        String b = "10";


        // 输入：a = "11", b = "1001"
        // 输出："1100"
//        String a = "11";
//        String b = "1001";

        Solution solution = new Solution();
        String result1 = solution.addBinary1(a, b);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        String result2 = solution.addBinary2(a, b);
        System.out.println("result2 = " + result2);
    }

    static class Solution {
        public String addBinary1(String a, String b) {
            int aLength = a.length();
            int bLength = b.length();
            int minLength = Math.min(aLength, bLength);
            int maxLength = Math.max(aLength, bLength);

            char[] resultChars = new char[maxLength+1];
            char preSum = '0';
            char currentSum = '0';

            for (int i = 1; i <= minLength; i++) {
                char aChar = a.subSequence(aLength - i, aLength - i + 1).charAt(0);
                char bChar = b.subSequence(bLength - i, bLength - i + 1).charAt(0);

                if (aChar == '0' && bChar == '0') {
                    // 之前的进位为 0 或 1
                   if (preSum == '0') {
                       currentSum = '0';
                   } else {
                       currentSum = '1';
                       // 重置进位为 0
                       preSum = '0';
                   }
                }

                if (aChar == '0' && bChar == '1' || aChar == '1' && bChar == '0') {
                    // 之前的进位为 0 或 1
                    if (preSum == '0') {
                        currentSum = '1';
                    } else {
                        currentSum = '0';
                    }
                }

                if (aChar == '1' && bChar == '1') {
                    // 之前的进位为 0 或 1
                    if (preSum == '0') {
                        currentSum = '0';
                        // 设置进位为 1
                        preSum = '1';
                    } else {
                        currentSum = '1';
                    }
                }

                resultChars[( maxLength + 1 ) - i] = currentSum;
            }

            int gapLength = Math.abs(aLength - bLength);

            for (int j = 0; j < gapLength; j++) {
                if (aLength >= bLength) {
                    char aChar = a.subSequence(aLength - minLength - 1 - j, aLength - minLength - 1 - j + 1).charAt(0);
                    if (aChar == '0') {
                        if (preSum == '0') {
                            currentSum = '0';
                        } else {
                            currentSum = '1';
                            // 重置进位为 0
                            preSum = '0';
                        }
                    }

                    if (aChar == '1') {
                        if (preSum == '0') {
                            currentSum = '1';
                        } else {
                            currentSum = '0';
                            // 设置进位为 1
                            preSum = '1';
                        }
                    }

                } else {
                    char bChar = b.subSequence(bLength - minLength - 1 - j, bLength - minLength - 1 - j + 1).charAt(0);

                    if (bChar == '0') {
                        if (preSum == '0') {
                            currentSum = '0';
                        } else {
                            currentSum = '1';
                            // 重置进位为 0
                            preSum = '0';
                        }
                    }

                    if (bChar == '1') {
                        if (preSum == '0') {
                            currentSum = '1';
                        } else {
                            currentSum = '0';
                            preSum = '1';
                        }
                    }
                }

                resultChars[maxLength - minLength - j] = currentSum;

            }

            String resultStr = null;

            if (preSum == '1') {
                resultChars[0] = '1';
                resultStr = String.valueOf(resultChars);
            } else {
                resultChars[0] = '0';
                resultStr = String.valueOf(resultChars);
                resultStr = resultStr.substring(1, resultStr.length());
            }

            return resultStr;
        }

        public String addBinary2(String a, String b) {
            int aLength = a.length();
            int bLength = b.length();

            // 补齐前导零,使 a 和 b 长度一样
            int gapLength = Math.abs(aLength - bLength);
            StringBuffer stringBuffer = new StringBuffer();
            for (int k = 0; k < gapLength; k++) {
                stringBuffer.append("0");
            }

            if (aLength > bLength) {
                stringBuffer.append(b);
                b = stringBuffer.toString();
            } else {
                stringBuffer.append(a);
                a = stringBuffer.toString();
            }

            int maxLength = Math.max(aLength, bLength);
            StringBuffer resultStrBuffer = new StringBuffer();
            int carry = 0;
            int currentSum = 0;
            int threeTotal = 0;
            char aChar = '0';
            char bChar = '0';
            int aIntValue = 0;
            int bIntValue = 0;

            for (int i = 1; i <= maxLength; i++) {
                aChar = a.charAt(maxLength - i);
                bChar = b.charAt(maxLength - i);

                aIntValue = aChar - '0';
                bIntValue = bChar - '0';

                // currentSum 为 3个值的和,再取模2
                threeTotal = aIntValue + bIntValue + carry;
                currentSum = threeTotal % 2;
                // preSum 为 3个值的和,再整除2
                carry = threeTotal / 2;

                resultStrBuffer.append(currentSum == 0 ? '0' : '1');
            }

            if (carry == 1) {
                resultStrBuffer.append("1");
            }

            System.out.println("resultStrBuffer = " + resultStrBuffer.toString());

            resultStrBuffer.reverse();

            return resultStrBuffer.toString();
        }

    }
}