package 哈希表.Problem_1207_独一无二的出现次数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
https://leetcode.cn/problems/unique-number-of-occurrences/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：arr = [1,2,2,1,1,3]
        // 输出：true
//        int[] arr = new int[]{1,2,2,1,1,3};

        // 输入：arr = [1,2]
        // 输出：false
//        int[] arr = new int[]{1,2};

        // 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
        // 输出：true
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};

        Solution solution = new Solution();
        boolean result = solution.uniqueOccurrences(arr);
        System.out.println("result = " + result);
    }

    static class Solution {

        public boolean uniqueOccurrences(int[] arr) {

            // 建立一个 HashMap, 保存各个数字 和 各自出现的次数 (key-value)
            HashMap<Integer, Integer> hashMap = new HashMap();

            // 建立一个 HashSet, 统计 各个数字出现的次数, 是否独一无二
            HashSet<Integer> hashSet = new HashSet<>();

            int arrLength = arr.length;
            int count = 0;

            // 统计 各个数字 和 出现的次数
            for (int i = 0; i < arrLength; i++) {
                if (!hashMap.containsKey(arr[i])) {
                    hashMap.put(arr[i], 1);
                } else {
                    count = hashMap.get(arr[i]);
                    hashMap.put(arr[i], count + 1);
                }
            }

            // 统计 出现的次数, 是否唯一
            Iterator<Integer> iterator = hashMap.values().iterator();
            while (iterator.hasNext()) {
                count = iterator.next();
                if (hashSet.contains(count)) {
                    return false;
                } else {
                    hashSet.add(count);
                }
            }

            return true;
        }
    }
}