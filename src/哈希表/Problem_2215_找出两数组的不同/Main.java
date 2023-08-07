package 哈希表.Problem_2215_找出两数组的不同;

import java.util.*;

/*
https://leetcode.cn/problems/find-the-difference-of-two-arrays/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums1 = [1,2,3], nums2 = [2,4,6]
        // 输出：[[1,3],[4,6]]
//        int[] nums1 = new int[]{1,2,3};
//        int[] nums2 = new int[]{2,4,6};

        // 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
        // 输出：[[3],[]]
        int[] nums1 = new int[]{1,2,3,3};
        int[] nums2 = new int[]{1,1,2,2};

        Solution solution = new Solution();
        List<List<Integer>> result = solution.findDifference(nums1, nums2);
        System.out.println("result = " + result);
    }

    static class Solution {

        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

            // 建立 2个 HashSet, 分别保存数组 nums1 和 nums2 的数字, 并且去重
            HashSet<Integer> hashSet1 = new HashSet<>();
            HashSet<Integer> hashSet2 = new HashSet<>();

            // 建立 3个list, 保存结果, 并返回
            List<Integer> resultList1 = new ArrayList<>();
            List<Integer> resultList2 = new ArrayList<>();
            List<List<Integer>> resultLists = new ArrayList<>();

            int nums1Length = nums1.length;
            int nums2Length = nums2.length;

            // 遍历数组, 加入集合 HashSet1 中
            for (int i = 0; i < nums1Length; i++) {
                hashSet1.add(nums1[i]);
            }

            // 遍历数组, 加入集合 HashSet2 中
            for (int j = 0; j < nums2Length; j++) {
                hashSet2.add(nums2[j]);
            }

            // 遍历结合 HashSet1, 找出nums1 中所有 不存在于 nums2 中的 不同整数
            Iterator<Integer> iterator1 = hashSet1.iterator();
            int tempNum1 = 0;
            while (iterator1.hasNext()) {
                tempNum1 = iterator1.next();
                if (!hashSet2.contains(tempNum1)) {
                    resultList1.add(tempNum1);
                }
            }

            // 遍历结合 HashSet2, 找出nums2 中所有 不存在于 nums1 中的 不同整数
            Iterator<Integer> iterator2 = hashSet2.iterator();
            int tempNum2 = 0;
            while (iterator2.hasNext()) {
                tempNum2 = iterator2.next();
                if (!hashSet1.contains(tempNum2)) {
                    resultList2.add(tempNum2);
                }
            }

            // 返回结果 list
            resultLists.add(resultList1);
            resultLists.add(resultList2);

            return resultLists;
        }

    }
}