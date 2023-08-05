package 哈希表.Problem_290_单词规律;

import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.cn/problems/word-pattern/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入: pattern = "abba", s = "dog cat cat dog"
        // 输出: true
//        String pattern = new String("abba");
//        String s = new String("dog   cat cat dog");

        // 输入:pattern = "abba", s = "dog cat cat fish"
        // 输出: false
        String pattern = new String("abba");
        String s = new String("dog cat cat fish");

        // 输入: pattern = "aaaa", s = "dog cat cat dog"
        // 输出: false
//        String pattern = new String("aaaa");
//        String s = new String("dog cat cat dog");

        // 输入: pattern = "abba", s = "dog dog dog dog"
        // 输出: false
//        String pattern = new String("abba");
//        String s = new String("dog dog dog dog");

        // 输入: pattern = "aaa", s = "aa aa aa aa"
        // 输出: false
//        String pattern = new String("aaa");
//        String s = new String("aa aa aa aa");

        // 输入: pattern = "jquery", s = "jquery"
        // 输出: false
//        String pattern = new String("jquery");
//        String s = new String("jquery");

        Solution solution = new Solution();
        boolean result0 = solution.wordPattern(pattern, s);
        System.out.println("result0 = " + result0);
    }

    static class Solution {

        public boolean wordPattern(String pattern, String s) {

            // 建立HashMap, 保存对应的映射关系, key-value
            // 因为双向的一一对应关系,所以还需要一个HashSet保存已经建立对应关系的value
            // 避免出现 多对1 或 1对多 的映射关系
            HashMap<String, String> hashMap = new HashMap<>();
            HashSet<String> hashSet = new HashSet<>();

            int pLength = pattern.length();
            String pTempStr = new String();
            String[] sSplitStr = s.split(" ");
            int sSplitStrLength = sSplitStr.length;

//            String[] sSplitStrNew = Arrays.stream(sSplitStr).filter(e -> e.length() > 0).toArray(String[]::new);

            // 如果 pattern的字符串长度 不等于 s拆分为字符串数组的长度,立即返回false
            if (pLength != sSplitStrLength) {
                return false;
            }

            // 遍历 pattern字符串
            for (int i = 0; i < pLength; i++) {
                pTempStr = pattern.substring(i, i+1);

                // 如果在HashMap没有找到对应的字符串,则建立新的对应的key-value
                // 因为双向的一一对应关系,所以还需要一个HashSet保存已经建立对应关系的value
                if (!hashMap.containsKey(pTempStr)) {

                    if (hashSet.contains(sSplitStr[i])) {
                        return false;
                    }

                    hashMap.put(pTempStr, sSplitStr[i]);
                    hashSet.add(sSplitStr[i]);

                } else {
                    // 如果在 HashMap中找到对应的key,则取出来比较s的字符串数组中对应的字符串是否相等
                    if (!hashMap.get(pTempStr).equals(sSplitStr[i])) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}