package 哈希表.Problem_1_两数之和;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [2,7,11,15], target = 9
        // 输出：[0,1]
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;

        // 输入：nums = [3,2,4], target = 6
        // 输出：[1,2]
        int[] nums = new int[]{3,2,4};
        int target = 6;

        // 输入：nums = [3,3], target = 6
        // 输出：[0,1]
//        int[] nums = new int[]{3,3};
//        int target = 6;

        Solution solution = new Solution();
        int[] result1 = solution.twoSum1(nums, target);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        int[] result2 = solution.twoSum2(nums, target);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public int[] twoSum1(int[] nums, int target) {

            int numsLength = nums.length;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int matchPostion1 = 0;
            int matchPostion2 = 0;

            for (int i = 0; i < numsLength; i++) {

                // 如果 hashMap中不包含 target - nums[i] 的 key,则新建一个 key-value
                if (!hashMap.containsKey(target - nums[i])) {
                    hashMap.put(nums[i], i);
                } else {
                    // 如果 hashMap已经包含 target - nums[i] 的 key
                    matchPostion1 = hashMap.get(target - nums[i]);
                    matchPostion2 = i;

                }
            }

            return new int[]{matchPostion1, matchPostion2};
        }

        public int[] twoSum2(int[] nums, int target) {

            int numsLength = nums.length;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int matchPostion1 = 0;
            int matchPostion2 = 0;

            // 遍历数组元素, 先建立一个hashMap, key为数组元素的值, value为数组元素的下标
            for (int i = 0; i < numsLength; i++) {
                hashMap.put(nums[i], i);
            }

            // 再次遍历数组元素, 查找hashMap中,是否存在对应的值,
            // 如果找到, 返回它对应的下标
            for (int j = 0; j < numsLength; j++) {
                if (hashMap.containsKey(target - nums[j])) {
                    matchPostion1 = j;
                    matchPostion2 = hashMap.get(target - nums[j]);

                    // 避免自己和自己匹配
                    if (matchPostion1 != matchPostion2) {
                        break;
                    }
                }
            }

            return new int[]{matchPostion1, matchPostion2};
        }
    }
}