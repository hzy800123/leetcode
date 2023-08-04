package 数组_字符串.Problem_169_多数元素;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [3,2,3]
        // 输出：3
//        int[] nums = new int[]{3,2,3};

        // 输入：nums = [2,2,1,1,1,2,2]
        // 输出：2
        int[] nums = new int[]{2,2,1,1,1,2,2};

        Solution solution = new Solution();
        int result = solution.majorityElement(nums);
        System.out.println("result = " + result);
    }

    static class Solution {
        public int majorityElement(int[] nums) {

            int numsLength = nums.length;
            int count = numsLength / 2;
            int currentCount = 0;
            // 建立一个HashMap, 保存对应的数字和出现的次数 (key-value)
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            // 遍历数组
            for (int i = 0; i < numsLength; i++) {

                // 如果元素不再 HashMap中, 放入里面, 次数为1
                if (!hashMap.containsKey(nums[i])) {
                    hashMap.put(nums[i], 1);
                    currentCount = 1;
                } else {
                    // 如果元素已经在 HashMap中, 次数+1
                    currentCount = hashMap.get(nums[i]) + 1;
                    hashMap.put(nums[i], currentCount);
                }

                // 比较该元素的出现次数, 是否大于n/2
                // 如果大于, 立即返回该元素的值
                if (currentCount > count) {
                    return nums[i];
                }
            }

            return 0;
        }
    }
}