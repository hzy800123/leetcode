package LCP.Problem_2905_找出满足差值条件的下标_II;

import java.util.*;

/*
https://leetcode.cn/contest/weekly-contest-367/problems/find-indices-with-index-and-value-difference-ii/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
        // 输出：[0,3]
//        int[] nums = new int[]{5,1,4,1};
//        int indexDifference = 2;
//        int valueDifference = 4;

        // 输入：nums = [2,1], indexDifference = 0, valueDifference = 0
        // 输出：[0,0]
//        int[] nums = new int[]{2,1};
//        int indexDifference = 0;
//        int valueDifference = 0;

        // 输入：nums = [1,2,3], indexDifference = 2, valueDifference = 4
        // 输出：[-1,-1]
//        int[] nums = new int[]{1,2,3};
//        int indexDifference = 2;
//        int valueDifference = 4;

        // 输入：nums = [1]， indexDifference = 1, valueDifference = 0
        // 输出：[-1,-1]
//        int[] nums = new int[]{1};
//        int indexDifference = 1;
//        int valueDifference = 0;

        // 输入：nums = [2,0,9,2]， indexDifference = 2, valueDifference = 4
        // 输出：[0,2]
//        int[] nums = new int[]{2,0,9,2};
//        int indexDifference = 2;
//        int valueDifference = 4;

        // 输入：nums = [5,1,0,7,5,2,0]， indexDifference = 4, valueDifference = 3
        // 输出：[0,5]
        int[] nums = new int[]{5,1,0,7,5,2,0};
        int indexDifference = 4;
        int valueDifference = 3;

        Solution solution = new Solution();
        int[] result = solution.findIndices(nums, indexDifference, valueDifference);
        System.out.println("result = " + result[0] + ", " + result[1]);

        int[] result2 = solution.findIndices2(nums, indexDifference, valueDifference);
        System.out.println("result2 = " + result2[0] + ", " + result2[1]);

    }


    static class Solution {

        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

            int lengthNums = nums.length;

            if (lengthNums <= 60) {
                for(int i = 0; i < lengthNums; i++) {
                    int j = i + indexDifference;

                    for(; j < lengthNums; j++) {
                        if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                            // Found one result and return the result
                            return new int[]{i, j};
                        }
                    }
                }
            }


            TreeMap<Integer, Integer> numsMap = new TreeMap();
            for (int i = 0; i < lengthNums; i++) {
                numsMap.put(i, nums[i]);
            }

            List<Map.Entry<Integer, Integer>> numsList = new ArrayList<Map.Entry<Integer, Integer>>(numsMap.entrySet());

            Collections.sort(
                    numsList,
                    // Sort in ascending order
                    new Comparator<Map.Entry<Integer, Integer>>() {
                        @Override
                        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                            return o1.getValue() - o2.getValue();
                        }
                    }
            );

            for (Map.Entry<Integer, Integer> e : numsList) {
                System.out.println(e.getKey() + ":" + e.getValue());
            }

            for (int start = 0; start < lengthNums; start++) {

                int currentValueDiff = Math.abs(numsList.get(lengthNums-1).getValue() - numsList.get(start).getValue());
                if (currentValueDiff >= valueDifference) {
                    int currentIndexDiff = Math.abs(numsList.get(lengthNums-1).getKey() - numsList.get(start).getKey());

                    if (currentIndexDiff >= indexDifference) {
                        return new int[]{numsList.get(lengthNums-1).getKey(), numsList.get(start).getKey()};
                    }
                } else {
                    break;
                }
            }


            for (int end = 0; end < lengthNums; end++) {

                int currentValueDiff = Math.abs(numsList.get(lengthNums-end-1).getValue() - numsList.get(0).getValue());
                if (currentValueDiff >= valueDifference) {
                    int currentIndexDiff = Math.abs(numsList.get(lengthNums-end-1).getKey() - numsList.get(0).getKey());

                    if (currentIndexDiff >= indexDifference) {
                        return new int[]{numsList.get(lengthNums-end-1).getKey(), numsList.get(0).getKey()};
                    }
                } else {
                    break;
                }
            }

            // Not found
            return new int[]{-1, -1};
        }

        public int[] findIndices2(int[] nums, int indexDifference, int valueDifference) {

            int lengthNums = nums.length;

            int left = 0;
            int right = 0;
            // 记录左指针所遍历的最小的数组元素的下标
            int maxIndex = 0;
            // 记录左指针所遍历的最大的数组元素的下标
            int minIndex = 0;

            // 遍历数组，左指针从0开始遍历，直到 长度-indexDifference 为止
            for (; left < lengthNums - indexDifference; left++) {
                // 右指针 等于 左指针+indexDifference
                right = left + indexDifference;

                // 如果 左指针的数组元素 < 目前遍历的最小的元素，则更新最小元素的下标值
                if (nums[left] < nums[minIndex]) {
                    minIndex = left;
                }

                // 如果 左指针的数组元素 > 目前遍历的最大的元素，则更新最大元素的下标值
                if (nums[left] > nums[maxIndex]) {
                    maxIndex = left;
                }

                // 如果 右指针的数组元素 与 左指针所遍历过的最小的数组元素 的差，大于等于valueDifference，
                // 返回下标结果
                if (Math.abs(nums[right] - nums[minIndex]) >= valueDifference) {
                    return new int[]{minIndex, right};
                }

                // 如果 右指针的数组元素 与 左指针所遍历的最大的数组元素 的差，小于等于valueDifference，
                // 返回下标结果
                if (Math.abs(nums[maxIndex] - nums[right]) >= valueDifference) {
                    return new int[]{maxIndex, right};
                }

            }

            // Not found
            return new int[]{-1, -1};
        }
    }

}