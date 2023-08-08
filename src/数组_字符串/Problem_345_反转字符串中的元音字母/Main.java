package 数组_字符串.Problem_345_反转字符串中的元音字母;

/*
https://leetcode.cn/problems/reverse-vowels-of-a-string/
 */
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：s = "hello"
        // 输出："holle"
//        String s = new String("hello");

        // 输入：s = "leetcode"
        // 输出："leotcede"
        String s = new String("leetcode");

        Solution solution = new Solution();
        String result = solution.reverseVowels(s);
        System.out.println("result = " + result);
    }

    static class Solution {
        public String reverseVowels(String s) {

            int sLength = s.length();
            // 建立一个字符串数组, 便于交换里面的字符
            char[] sCharArr = s.toCharArray();

            // 建立一个集合 HashSet, 保存元音字母的集合
            HashSet<Character> hashSet = new HashSet<>();
            hashSet.add('a');
            hashSet.add('e');
            hashSet.add('i');
            hashSet.add('o');
            hashSet.add('u');

            hashSet.add('A');
            hashSet.add('E');
            hashSet.add('I');
            hashSet.add('O');
            hashSet.add('U');

            // 定义 左指针, 从0开始, 向右遍历
            int left = 0;
            // 定义 右指针, 从 长度-1 开始, 向左遍历
            int right = sLength - 1;
            // 定义 临时变量, 便于交换元素
            char temp = ' ';

            // 如果 左指针 < 右指针, 继续遍历
            while (left < right) {

                // 左指针 向右移动, 不可以超过右指针
                while (left < right) {
                    // 如果集合 HashSet 里没有找到, 继续向右移动
                    if (!hashSet.contains(sCharArr[left])) {
                        left++;
                    } else {
                        // 如果 找到, 输入元音字母, 跳出内循环
                        break;
                    }
                }

                // 右指针 向右移动, 也不可以超过左指针
                while (left < right) {
                    // 如果集合 HashSet 里没有找到, 继续向左移动
                    if (!hashSet.contains(sCharArr[right])) {
                        right--;
                    } else {
                        // 如果 找到, 输入元音字母, 跳出内循环
                        break;
                    }
                }

                // 如果 左指针 和 右指针 指向不同的元素, 才需要进行交换
                if (left < right) {
                    temp = sCharArr[left];
                    sCharArr[left] = sCharArr[right];
                    sCharArr[right] = temp;
                }

                // 左指针 继续向右移动
                left++;
                // 右指针 继续向左移动
                right--;
            }

            // 最后, 字符串数组 转为字符串, 返回
            String resultStr = String.valueOf(sCharArr);

            return resultStr;
        }
    }
}