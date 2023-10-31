package LCP.Problem_2904_最短且字典序最小的美丽子字符串;

/*
https://leetcode.cn/contest/weekly-contest-367/problems/shortest-and-lexicographically-smallest-beautiful-string/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：s = "100011001", k = 3
        // 输出："11001"
//        String s = "100011001";
//        int k = 3;

        // 输入：s = "1011", k = 2
        // 输出："11"
//        String s = "1011";
//        int k = 2;

        // 输入：s = "000", k = 1
        // 输出：""
//        String s = "000";
//        int k = 1;

        // 输入："11000111", 1
        // 输出："1"
//        String s = "11000111";
//        int k = 1;

        // 输入："001110101101101111", 10
        // 输出："10101101101111"
        String s = "001110101101101111";
        int k = 10;

        Solution solution = new Solution();
        String result = solution.shortestBeautifulSubstring(s, k);
        System.out.println("result = " + result);
    }

    static class Solution {

        public String shortestBeautifulSubstring(String s, int k) {

            char[] charArr = s.toCharArray();
            int lengthCharArr = charArr.length;
            int count = 0;
            int resultLength = 0;
            int minResultLength = Integer.MAX_VALUE;
            int resultStart = 0;
            // 因为数组里可能不存在字符'1'，所以结束位置初始值为-1
            int resultEnd = -1;

            // 开始位置start，从0开始，依次尝试不同的开始位置
            for(int start = 0; start < lengthCharArr; start++) {

                // 每次循环，重置count为0
                count = 0;

                // 从开始位置start，依次遍历数组的每个字符
                for(int i = start; i < lengthCharArr; i++) {

                    if(charArr[i] == '1') {
                        count++;

                        // 如果字符'1'的个数等于k，则继续记录此次的子字符串的长度和下标位置
                        if(count == k) {
                            resultLength = i - start + 1;

                            if(resultLength < minResultLength) {
                                minResultLength = resultLength;
                                resultStart = start;
                                resultEnd = i;
                            }

                            // 如果新的子字符串 < 旧的子字符串，则结果替换为新的子字符串
                            if(resultLength == minResultLength) {
                                String oldStr = s.substring(resultStart, resultEnd + 1);
                                String newStr = s.substring(start, i + 1);

                                if(oldStr.compareTo(newStr) > 0) {
                                    resultStart = start;
                                    resultEnd = i;
                                }
                            }

                            break;
                        }
                    }
                }
            }

            return s.substring(resultStart, resultEnd + 1);
        }
    }

}