package Problem_219_存在重复元素II;

import java.util.HashMap;

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

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (!hashMap.containsKey(nums[i])) {
                    hashMap.put(Integer.valueOf(nums[i]), i);
                } else {
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