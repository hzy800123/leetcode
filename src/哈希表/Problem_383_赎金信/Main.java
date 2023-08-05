package 哈希表.Problem_383_赎金信;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.cn/problems/ransom-note/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：ransomNote = "a", magazine = "b"
        // 输出：false
        String ransomNote = new String("a");
        String magazine = new String("b");

        // 输入：ransomNote = "aa", magazine = "ab"
        // 输出：false
//        String ransomNote = new String("aa");
//        String magazine = new String("ab");

        // 输入：ransomNote = "aa", magazine = "aab"
        // 输出：true
//        String ransomNote = new String("aa");
//        String magazine = new String("aab");

        Solution solution = new Solution();
        boolean result0 = solution.canConstruct0(ransomNote, magazine);
        System.out.println("result0 = " + result0);

        System.out.println(" --- ");

        boolean result1 = solution.canConstruct1(ransomNote, magazine);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        boolean result2 = solution.canConstruct2(ransomNote, magazine);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public boolean canConstruct0(String ransomNote, String magazine) {
            int ranLength = ransomNote.length();
            int magLength = magazine.length();
            char ranTempChar = ' ';
            char magTempChar = ' ';

            // 新建一个int数组,保存每个小写字母出现的次数
            int[] letters = new int[26];

            // 遍历字符串magazine,记录各个小写字母出现的次数
            for (int i = 0; i < magLength; i++) {
                magTempChar = magazine.charAt(i);
                letters[magTempChar - 'a']++;
            }

            // 遍历字符串ransomNote,检查int数组中小写字母,
            // 出现的次数是否可以满足提供给ransomNote的每个字母
            for (int j = 0; j < ranLength; j++) {
                ranTempChar = ransomNote.charAt(j);

                // 不足以提供,立即返回false
                if (letters[ranTempChar - 'a'] <= 0) {
                    return false;
                } else {
                    letters[ranTempChar - 'a']--;
                }
            }

            return true;
        }

        public boolean canConstruct1(String ransomNote, String magazine) {

            int ranLength = ransomNote.length();
            int magLength = magazine.length();
            char ranTempChar = ' ';
            char magTempChar = ' ';
            int count = 0;

            // 新建一个HashMap,保存每个对应的字符(字母),以及出现的次数
            HashMap<Character, Integer> magHashMap = new HashMap();

            // 遍历magazine字符串,记录全部的字符和出现的次数
            for (int m = 0; m < magLength; m++) {
                magTempChar = magazine.charAt(m);

                // 如果字符不存在,新建一个key-value
                // 如果字符已经存在,次数+1
                if (!magHashMap.containsKey(magTempChar)) {
                    magHashMap.put(magTempChar, 1);
                } else {
                    count = magHashMap.get(magTempChar);
                    magHashMap.put(magTempChar, count + 1);
                }
            }

            // 遍历ransomNote字符串,检查每个字符,是否在HashMap中可以足够提供
            for (int r = 0; r < ranLength; r++) {
                ranTempChar = ransomNote.charAt(r);

                // 如果HashMap中不存在,立即返回false
                if(!magHashMap.containsKey(ranTempChar)) {
                    return false;
                } else {
                    count = magHashMap.get(ranTempChar);
                    // 如果次数为1,直接删除key
                    if (count == 1) {
                        magHashMap.remove(ranTempChar);
                    } else {
                        // 如果次数>1,次数-1
                        magHashMap.put(ranTempChar, count - 1);
                    }
                }
            }

            return true;
        }

        public boolean canConstruct2(String ransomNote, String magazine) {

            int ranLength = ransomNote.length();
            int magLength = magazine.length();
            char[] ranChars = new char[ranLength];
            char[] magChars = new char[magLength];
            char ranTempChar = ' ';
            char magTempChar = ' ';
            int magPostion = 0;
            boolean findSameChar = false;

            // 遍历字符串ransomNote,转为字符数组
            for (int r = 0; r < ranLength; r++) {
                ranChars[r] = ransomNote.charAt(r);
            }

            // 遍历字符串magazine,转为字符数组
            for (int m = 0; m < magLength; m++) {
                magChars[m] = magazine.charAt(m);
            }

            // 使用Arrays.sort(),将字符数组按照字母顺序排序
            Arrays.sort(ranChars);
            Arrays.sort(magChars);

            // 遍历字符数组ranChars,逐一检查每个字符,是否在字符数组magChars中,
            // 可以找到相同的字符
            for (int i = 0; i < ranLength; i++) {
                ranTempChar = ranChars[i];
                findSameChar = false;

                // 每次找到相同的字符,记录字符数组magChars的对应位置,下一次从此位置开始向后遍历
                for (int j = magPostion; j < magLength; j++) {
                    magTempChar = magChars[j];

                    if (ranTempChar == magTempChar) {
                        findSameChar = true;
                        magPostion = j + 1;
                        break;
                    }
                }

                if (!findSameChar) {
                    return false;
                }
            }

            return true;
        }
    }
}