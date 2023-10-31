package LCP.Problem_2860_让所有学生保持开心的分组方法数;

import java.util.*;

/*
https://leetcode.cn/contest/weekly-contest-363/problems/happy-students/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [1,1]
        // 输出：2
//        List<Integer> nums = new ArrayList<>(Arrays.asList(1,1));

        // 输入：nums = [6,0,3,3,6,7,2,7]
        // 输出：3
//        List<Integer> nums = new ArrayList<>(Arrays.asList(6,0,3,3,6,7,2,7));

        // 输入：nums = [0,4,4,4,4,4,2]
        // 输出：2
        List<Integer> nums = new ArrayList<>(Arrays.asList(0,4,4,4,4,4,2));

        Solution solution = new Solution();
        int result = solution.countWays(nums);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int countWays(List<Integer> nums) {

            // 增加一个最后的最大值，方便最后一个元素的比较
            nums.add(Integer.MAX_VALUE);

            // 转换为数组，速度更快
            int[] newNums = nums.stream().mapToInt(Integer::intValue).toArray();
            // 排序
            Arrays.sort(newNums);

            int length = nums.size();
            int countResult = 0;

            // 如果第一个最小的元素>0，则存在一种满足条件的可能：全部的学生都不选
            if (newNums[0] > 0) {
                countResult++;
            }

            // 遍历数组，只有当前元素和下一个元素的差 大于1，才可能存在一种可能性，countResult++
            for (int i = 0; i < length - 1; i++) {
                int curNum = newNums[i];
                int nextNum = newNums[i + 1];

                if (curNum + 1 < nextNum) {
                    // currentCount 为 被选中的学生人数
                    int currntCount = i + 1;
                    // 需要满足的条件：
                    // 被选中的学生人数 严格大于 全部当选的学生的 nums[i]
                    // 被选中的学生人数 严格小于 全部没有当选的学生的 nums[i]
                    if (currntCount > curNum && currntCount < nextNum) {
                        countResult++;
                    }
                }
            }

            return countResult;
        }
    }
}