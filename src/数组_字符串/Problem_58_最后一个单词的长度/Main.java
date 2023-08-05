package 数组_字符串.Problem_58_最后一个单词的长度;

/*
https://leetcode.cn/problems/length-of-last-word/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：s = "Hello World"
        // 输出：5
//        String s = "Hello World";

        // 输入：s = "   fly me   to   the moon  "
        // 输出：4
        String s = "   fly me   to   the moon  ";

        // 输入：s = "luffy is still joyboy"
        // 输出：6
//        String s = "luffy is still joyboy";

        Solution solution = new Solution();
        int result1 = solution.lengthOfLastWord1(s);

        System.out.println("result1 = " + result1);
        System.out.println(" --- ");

        int result2 = solution.lengthOfLastWord2(s);
        System.out.println("result2 = " + result2);
    }

    static class Solution {
        public int lengthOfLastWord1(String s) {
            String[] strings = s.split(" ");
            String finalStr = strings[strings.length - 1];

//            System.out.println("strings : " + strings);
//            System.out.println("finalStr : " + finalStr);
            return finalStr.length();
        }

        public int lengthOfLastWord2(String s) {

            StringBuffer strBuffer = new StringBuffer(s);
            int length = s.length();
            // 定义 左指针
            int l = length - 1;
            // 定义 右指针
            int r = length - 1;

            while (r >= 0) {
                if (strBuffer.charAt(r) == ' ') {
                    // 右指针 向左移动
                    r--;
                    continue;
                } else {
                    // 设置 左指针
                    l = r;

                    while (l >= 0) {
                        if (strBuffer.charAt(l) != ' ') {
                            // 左指针 向左移动
                            l--;
                            continue;
                        } else {
                            break;
                        }
                    }

                    break;
                }
            }

            return r - l;
        }

    }


}