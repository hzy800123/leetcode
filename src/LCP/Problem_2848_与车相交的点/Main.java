package LCP.Problem_2848_与车相交的点;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.cn/problems/points-that-intersect-with-cars/submissions/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [[3,6],[1,5],[4,7]]
        // 输出：7
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(3,6));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,5));
//        List<Integer> list3 = new ArrayList<>(Arrays.asList(4,7));
//        List<List<Integer>> nums = new ArrayList<>();
//        nums.add(list1);
//        nums.add(list2);
//        nums.add(list3);


        // 输入：nums = [[1,3],[5,8]]
        // 输出：7
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,3));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,8));
//        List<List<Integer>> nums = new ArrayList<>();
//        nums.add(list1);
//        nums.add(list2);

        // 输入：nums = [[1,3],[5,8],[2,6]]
        // 输出：8
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(2,6));
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);

        Solution solution = new Solution();
        int result = solution.numberOfPoints(nums);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int numberOfPoints(List<List<Integer>> nums) {

            // 关键是先找到最大值和最小值，方便定义一个新的数字数组，里面的值初始为0
            int minNum = Integer.MAX_VALUE;
            int maxNum = 0;

            // 先遍历2维数组，找到最大的数 和 最小的数
            for (List<Integer> subList : nums) {
                for (Integer numItem : subList) {
                    if (numItem < minNum) {
                        minNum = numItem;
                    }

                    if (numItem > maxNum) {
                        maxNum = numItem;
                    }
                }
            }

            // 定义一个数字的数组，长度等于：最大数 - 最小数 + 1
            // 数字的数组里，初始值为0
            int length = maxNum - minNum + 1;
            int[] numsArray = new int[length];

            // 再次遍历2维数组，把数字数组的下标在起点和终点所对应的位置设为1
            for (List<Integer> subList : nums) {
                int numFirst = subList.get(0);
                int numSecond = subList.get(1);

                for (int i = numFirst - minNum; i <= numSecond - minNum; i++) {
                    numsArray[i] = 1;
                }
            }

            // 最后，遍历数字数组，累计1的个数，即为结果
            int countResult = 0;
            for (int i = 0; i < length; i++) {
                countResult = countResult + numsArray[i];
            }

            return countResult;
        }
    }
}