package Problem_205_同构字符串;

import java.util.HashMap;
import java.util.HashSet;

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

            HashMap<String, String> strMap = new HashMap<>();
            HashSet<String> strSet = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(i, i+1);
                String value = t.substring(i, i+1);

                if (!strMap.containsKey(key)) {
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
                        return false;
                    }
                }
            }

            return true;
        }
    }
}