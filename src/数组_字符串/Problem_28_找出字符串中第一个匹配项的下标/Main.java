package 数组_字符串.Problem_28_找出字符串中第一个匹配项的下标;

/*
https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：haystack = "sadbutsad", needle = "sad"
        // 输出：0
//        String haystack = new String("sadbutsad");
//        String needle = new String("sad");

        // 输入：haystack = "leetcode", needle = "leeto"
        // 输出：-1
//        String haystack = new String("leetcode");
//        String needle = new String("leeto");

        // 输入：haystack = "aaa", needle = "aaaa"
        // 输出：-1
//        String haystack = new String("aaa");
//        String needle = new String("aaaa");

        // 输入：haystack = "mississippi", needle = "issipi"
        // 输出：-1
        String haystack = new String("mississippi");
        String needle = new String("issipi");

        Solution solution = new Solution();
        int result = solution.strStr(haystack, needle);

        System.out.println("result = " + result);
    }

    static class Solution {

        public int strStr(String haystack, String needle) {
            int lengthA = haystack.length();
            int lengthB = needle.length();
            char a = ' ';
            char b = ' ';
            int resultIndex = -1;
            boolean sameStr = false;

            // 如果 字符串A的长度 < 字符串B的长度,直接返回-1
            if (lengthA < lengthB) {
                return -1;
            }

            // 遍历字符串A的各个字符,下标从 0 到 (lengthA - lengthB),依次遍历
            for (int i = 0; i <= lengthA - lengthB; i++) {
                sameStr = true;

                for (int j = 0; j < lengthB; j++) {

                    a = haystack.charAt(i + j);
                    b = needle.charAt(j);

                    // 如果字符一样,继续检查下一个字符
                    // 如果不一样,立即退出循环
                    if (a == b) {
                        continue;
                    } else {
                        sameStr = false;
                        break;
                    }
                }

                // 如果发现有相同的字符串,立即返回下标位置
                if (sameStr) {
                    resultIndex = i;
                    break;
                } else {
                    continue;
                }
            }

            return resultIndex;
        }
    }


}