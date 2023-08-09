package 数组_字符串.Problem_1768_交替合并字符串;

/*
https://leetcode.cn/problems/merge-strings-alternately/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：word1 = "abc", word2 = "pqr"
        // 输出："apbqcr"
//        String word1 = new String("abc");
//        String word2 = new String("pqr");

        // 输入：word1 = "abcd", word2 = "pq"
        // 输出："apbqcd"
        String word1 = new String("abcd");
        String word2 = new String("pq");

        Solution solution = new Solution();
        String result = solution.mergeAlternately(word1, word2);
        System.out.println("result = " + result);
    }

    static class Solution {

        public String mergeAlternately(String word1, String word2) {

            int word1Length = word1.length();
            int word2Length = word2.length();

            char[] word1CharArr = word1.toCharArray();
            char[] word2CharArr = word2.toCharArray();

            // 定义一个保存结果的字符串数组, 长度为 word1 和 word2 的长度的总和
            char[] resultCharArr = new char[word1Length + word2Length];

            // 定义 3个下标, 分别指向word1, word2, resultCharArr的3个数组
            int i = 0;
            int j = 0;
            int k = 0;

            // 遍历 word1 和 word2 数组, 不断搬运字符到结果字符数组 resultCharArr 中
            while (i < word1Length || j < word2Length) {
                if (i < word1Length) {
                    resultCharArr[k] = word1CharArr[i];
                    i++;
                    k++;
                }

                if (j < word2Length) {
                    resultCharArr[k] = word2CharArr[j];
                    j++;
                    k++;
                }
            }

            // 字符串数组, 转为字符串, 返回结果
            return String.valueOf(resultCharArr);
        }
    }
}