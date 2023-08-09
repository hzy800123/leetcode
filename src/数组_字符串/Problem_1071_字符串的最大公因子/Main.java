package 数组_字符串.Problem_1071_字符串的最大公因子;

/*
https://leetcode.cn/problems/greatest-common-divisor-of-strings/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：str1 = "ABCABC", str2 = "ABC"
        // 输出："ABC"
        String str1 = new String("ABCABC");
        String str2 = new String("ABC");

        // 输入：str1 = "ABABAB", str2 = "ABAB"
        // 输出："AB"
//        String str1 = new String("ABABAB");
//        String str2 = new String("ABAB");

        // 输入：str1 = "LEET", str2 = "CODE"
        // 输出：""
//        String str1 = new String("LEET");
//        String str2 = new String("CODE");

        // 输入：str1 = "ABCDEF", str2 = "ABC"
        // 输出：""
//        String str1 = new String("ABCDEF");
//        String str2 = new String("ABC");

        Solution solution = new Solution();
        String result = solution.gcdOfStrings(str1, str2);
        System.out.println("result = " + result);
    }

    static class Solution {

        public String gcdOfStrings(String str1, String str2) {

            int str1Length = str1.length();
            int str2Length = str2.length();
            int minLength = Math.min(str1Length, str2Length);

            // 6 和 4 的最大公约数 为: 2
            int maxCommentLength = calculateMaxCommenLenth(str1Length, str2Length);

            // 最大公约数的子字符串
            String sampleStr = str1.substring(0, maxCommentLength);

            String subStr1 = "";
            String subStr2 = "";
            int i = 0;

            // 先遍历 str1 和 str2 的公共字符串 (长度为较小一个的长度)
            while (i < minLength) {
                subStr1 = str1.substring(i, i + maxCommentLength);
                subStr2 = str2.substring(i, i + maxCommentLength);

                if (!subStr1.equals(sampleStr) || !subStr2.equals(sampleStr)) {
                    return "";
                }

                i = i + maxCommentLength;
            }

            // 再继续遍历剩余的字符串
            if (str1Length < str2Length) {
                while (i < str2Length) {
                    subStr2 = str2.substring(i, i + maxCommentLength);

                    if (!subStr2.equals(sampleStr)) {
                        return "";
                    }

                    i = i + maxCommentLength;
                }
            } else {
                while (i < str1Length) {
                    subStr1 = str1.substring(i, i + maxCommentLength);

                    if (!subStr1.equals(sampleStr)) {
                        return "";
                    }

                    i = i + maxCommentLength;
                }
            }

            return sampleStr;
        }

        /*
            求最大公约数的 "辗转相除法"
         */
        public int calculateMaxCommenLenth(int x, int y) {
            int temp = 0;

            // 如果 x < y, 交换 x 和 y
            if (x < y) {
                temp = x;
                x = y;
                y = temp;
            }

            // 此时, x > y
            // 如果, x 可以被 y 整除, 返回 y
            if (x % y == 0) {
                return y;
            }

            return calculateMaxCommenLenth(x - y, y);
        }

    }
}