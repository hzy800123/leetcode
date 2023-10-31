package LCP.Problem_2910_合法分组的最少组数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.cn/contest/weekly-contest-368/problems/minimum-sum-of-mountain-triplets-ii/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [3,2,3,2,3]
        // 输出：2
//        int[] nums = new int[]{3,2,3,2,3};

        // 输入：nums = [10,10,10,3,1,1]
        // 输出：4
//        int[] nums = new int[]{10,10,10,3,1,1};

        // 输入：nums = [1,1,1,3]
        // 输出：3
//        int[] nums = new int[]{1,1,1,3};

        // 输入：nums = [1,1,3,3,1,1,2,2,3,1,3,2]
        // 输出：5
//        int[] nums = new int[]{1,1,3,3,1,1,2,2,3,1,3,2};

        // 输入：nums = [10,10,10,3,1,1]
        // 输出：4
//        int[] nums = new int[]{10,10,10,3,1,1};

        // 输入：nums = [1,1,1,3,3,3,1,2,1,1,1,2,1]
        // 输出：5
//        int[] nums = new int[]{1,1,1,3,3,3,1,2,1,1,1,2,1};

        // 输入：nums = [1,3,2,1,1,3,1,2,1,1,1,1,1,3,1]
        // 输出：6
//        int[] nums = new int[]{1,3,2,1,1,3,1,2,1,1,1,1,1,3,1};

        // 输入：nums = [8,12,1,2,2,1,1,5,1,1,5,15,14,14,1,12,2,15,11,1,9,9,5,3,1,8,7,8,3,3,10,4,8,15,4,14,3,11,5,15,8,3,3,10,4,11,5,7,9,11,14,6,8,15,4,6,11,14,10,5,12,1,3,11,1,3,3,7,4,3,5,1,9,1,1,7,11,9,14,8,8,9,10,4,4,3,5,4,9,9,2,3]
        // 输出：36
        int[] nums = new int[]{8,12,1,2,2,1,1,5,1,1,5,15,14,14,1,12,2,15,11,1,9,9,5,3,1,8,7,8,3,3,10,4,8,15,4,14,3,11,5,15,8,3,3,10,4,11,5,7,9,11,14,6,8,15,4,6,11,14,10,5,12,1,3,11,1,3,3,7,4,3,5,1,9,1,1,7,11,9,14,8,8,9,10,4,4,3,5,4,9,9,2,3};

        Solution solution = new Solution();
        int result = solution.minGroupsForValidAssignment(nums);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int minGroupsForValidAssignment(int[] nums) {

            // 数组先进行排序
            Arrays.sort(nums);

            // 如果数组的长度为1，直接返回结果为1
            if (nums.length == 1) {
                return 1;
            }

            // 使用左指针和右指针，遍历有序数组，获得一个新的数组，里面记录每个数组出现的次数
            // 原数组： [1，1，1，3，3，5]
            // 新数组： [3，     2，   1]
            int leftPoint = 0;
            int rightPoint = 1;
            int countCurrent = 0;
            List<Integer> countList = new ArrayList<>();
            while (rightPoint < nums.length) {
                if (nums[leftPoint] == nums[rightPoint]) {
                    rightPoint++;
                } else {
                    countCurrent = rightPoint - leftPoint;
                    countList.add(countCurrent);
                    leftPoint = rightPoint;
                    rightPoint++;
                }
            }

            countCurrent = rightPoint - leftPoint;
            countList.add(countCurrent);

            // 获得新的数组里，最小值
            int minCount = Collections.min(countList);

            // List转为数组，效率更高
            int[] newCountArray = countList.stream().mapToInt(Integer::intValue).toArray();

            // 如果新的数组长度为1，返回结果为1
            if (newCountArray.length == 1) {
                return 1;
            }

            int countResult = 0;

            // 从新的数组的最小值开始，逐一尝试每个k的可能性，从大到小尝试，k = minCount -> k = 1
            for (int k = minCount; k > 0; k--) {
                boolean successful = true;
                countResult = 0;

                // 遍历新的数组里每个元素 newCountArray[m]，尝试是否可以拆分为2组相邻数字的和
                // 例如：13 -> 4 + 3 + 3 + 3 （有相邻的3和4的数字组成）
                for (int m = 0; m < newCountArray.length; m++) {
                    if (k > 1) {

                        /**
                         * To get the minimum number of groups needed for a number having frequency f to be assigned to groups of size x or x + 1,
                         * let a = f / (x + 1) and b = f % (x + 1).
                         * If b == 0, then we can simply create a groups of size x + 1.
                         * If x - b <= a, we can have
                         * a - (x - b) groups of size x + 1 and
                         * x - b + 1 groups of size x.
                         * So, in total, we have a + 1 groups.
                         * Otherwise, it's impossible.
                         */
                        if (newCountArray[m] % (k + 1) == 0) {
                            countResult = countResult + newCountArray[m] / (k + 1);
                            continue;
                        }

                        int remain = newCountArray[m] % (k + 1);
                        int times = newCountArray[m] / (k + 1);

                        if (times >= (k - remain)) {
                            countResult = countResult + times + 1;
                            continue;
                        }

                        remain = newCountArray[m] % (k);
                        times = newCountArray[m] / (k);

                        if (times >= remain) {
                            if (remain == 0 && k < times) {
                                countResult = countResult + times - 1;
                            } else {
                                countResult = countResult + times;
                                continue;
                            }
                        } else {
                            successful = false;
                            break;
                        }

                    } else {
                        // 如果 k == 1，用奇偶的方法计算分组数量
                        countResult = countResult + (newCountArray[m] / 2 + newCountArray[m] % 2);
                    }
                }

                if (successful) {
                    break;
                }
            }

            return countResult;
        }
    }
}