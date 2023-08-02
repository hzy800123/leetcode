package 哈希表.Problem_242_有效的字母异位词;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入: s = "anagram", t = "nagaram"
        // 输出: true
//        String s = new String("anagram");
//        String t = new String("nagaram");

        // 输入: s = "rat", t = "car"
        // 输出: false
//        String s = new String("rat");
//        String t = new String("car");

        // 输入: s = "ab", t = "a"
        // 输出: false
        String s = new String("ab");
        String t = new String("a");

        Solution solution = new Solution();
        boolean result = solution.isAnagram(s, t);
        System.out.println("result = " + result);
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {

            // 建立一个int数组,保存26个小写字母的出现次数
            int[] letters = new int[26];
            int sLength = s.length();
            int tLength = t.length();

            // 如果2个字符串的长度不等,返回false
            if (sLength != tLength) {
                return false;
            }

            // 遍历字符串s,出现的字母所对应的数组位置+1
            for (int i = 0; i < sLength; i++) {
                letters[s.charAt(i) - 'a']++;
            }

            // 遍历字符串t,字母所对应的数组位置-1
            for (int j = 0; j < tLength; j++) {
                // 如果之前已经减为0,返回false
                if (letters[t.charAt(j) - 'a'] <= 0) {
                    return false;
                } else {
                    letters[t.charAt(j) - 'a']--;
                }
            }

            return true;
        }
    }
}