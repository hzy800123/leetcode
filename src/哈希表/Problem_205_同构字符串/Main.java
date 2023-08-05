package 哈希表.Problem_205_同构字符串;

import java.util.HashMap;
import java.util.HashSet;

/*
https://leetcode.cn/problems/isomorphic-strings/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        String s = "badc";
        String t = "baba";

        Solution solution = new Solution();
        boolean result = solution.isIsomorphic(s, t);
        System.out.println("result = " + result);
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            // 建立一个 HashMap, 保存s中的字符 和 t中的字符 的映射关系
            HashMap<String, String> strMap = new HashMap<>();
            // 建立一个 HashSet, 保证s中的字符 和 t中的字符 的映射关系是1对1,
            // 不会出现 多对1 或 1对多 的映射关系
            HashSet<String> strSet = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(i, i+1);
                String value = t.substring(i, i+1);

                if (!strMap.containsKey(key)) {
                    // 如果 HashSet中已经有此value, 就表示出现了多对1的映射, 返回false
                    // 例如:
                    // s = "ab"
                    // t = "11" (存放在 HashSet 中)
                    if (strSet.contains(value)) {
                        return false;
                    } else {
                        strMap.put(key, value);
                        strSet.add(value);
                    }
                } else {
                    String mappingValue = strMap.get(key);
                    if (mappingValue.equals(value)) {
                        continue;
                    } else {
                        // 如果 HashMap 中保存的value, 不等于t中的字符, 就表示出现了1对多的映射
                        // 返回false
                        // 例如:
                        // s = "aa"
                        // t = "12" (存放在 HashSet 中)
                        return false;
                    }
                }
            }

            return true;
        }
    }
}