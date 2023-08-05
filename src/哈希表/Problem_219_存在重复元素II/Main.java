package 哈希表.Problem_219_存在重复元素II;

import java.util.HashMap;

/*
https://leetcode.cn/problems/contains-duplicate-ii/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        int[] nums = new int[]{1,2,3,1,2,3};
        int k = 3;

        Solution solution = new Solution();
        boolean result = solution.containsNearbyDuplicate(nums, k);
        System.out.println("result = " + result);
    }

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {

            // 建立一个 HashMap, 保存 各个数字 和 它的下标位置 (key-value)
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            // 遍历数组的元素
            for (int i = 0; i < nums.length; i++) {
                // 如果 HashMap 中没有该数字, 把数字和它的下标, 保存在 HashMap 中
                if (!hashMap.containsKey(nums[i])) {
                    hashMap.put(Integer.valueOf(nums[i]), i);
                } else {
                    // 如果 HashMap 中已经有该数字, 获取它上次保存的下标
                    // 计算 当前下标 和 之前保存的下标 的差, 如果 <= K, 返回true
                    // 否则, 把当前的下标值 覆盖原来的下标值, 继续遍历数组
                    Integer oldValue = hashMap.get(Integer.valueOf(nums[i]));
                    if (i - oldValue <= k) {
                        return true;
                    } else {
                        hashMap.put(Integer.valueOf(nums[i]), i);
                    }
                }
            }

            return false;
        }
    }
}