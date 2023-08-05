package 数组_字符串.Problem_88_合并两个有序数组;

/*
https://leetcode.cn/problems/merge-sorted-array/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // 输出：[1,2,2,3,5,6]
        // 解释：需要合并 [1,2,3] 和 [2,5,6] 。
//        int[] nums1 = new int[]{1,2,3,0,0,0};
//        int[] nums2 = new int[]{2,5,6};
//        int m = 3;
//        int n = 3;

        // 输入：nums1 = [1], m = 1, nums2 = [], n = 0
        // 输出：[1]
        // 解释：需要合并 [1] 和 [] 。
//        int[] nums1 = new int[]{1};
//        int[] nums2 = new int[]{};
//        int m = 1;
//        int n = 0;

        // 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
        // 输出：[1]
        // 解释：需要合并的数组是 [] 和 [1] 。
//        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{1};
//        int m = 0;
//        int n = 1;

        // 输入：nums1 = [2,0], m = 1, nums2 = [1], n = 1
        // 输出：[1,2]
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        int m = 1;
        int n = 1;

        Solution solution = new Solution();
        solution.merge1(nums1, m, nums2, n);

        solution.merge2(nums1, m, nums2, n);
    }

    static class Solution {

        public void merge1(int[] nums1, int m, int[] nums2, int n) {

            // 定义3个指针, 指向数组的尾部, 从尾部开始,把较大的元素搬运到数组nums1的尾部
            int tailNums1 = m - 1;
            int tailNums2 = n - 1;
            int tailResult = m + n -1;

            // 如果 m=0, 就是直接把数组 nums2 的元素全部搬运到数组 nums1中
            if (m == 0) {
                while (tailNums2 >= 0) {
                    nums1[tailResult] = nums2[tailNums2];
                    tailResult--;
                    tailNums2--;
                }
            }

            // 同时遍历 2个数组nums1 和 nums2, 从后向前遍历
            while (tailNums1 >= 0 && tailNums2 >= 0) {

                // 把较大的元素, 搬运到数组nums1的尾部
                if (nums1[tailNums1] <= nums2[tailNums2]) {
                    nums1[tailResult] = nums2[tailNums2];
                    tailResult--;
                    tailNums2--;
                } else {
                    nums1[tailResult] = nums1[tailNums1];
                    tailResult--;
                    tailNums1--;
                }
            }

            // 如果 数组 nums2中, 还剩余元素, 继续搬运到数组nums1中
            while (tailNums2 >= 0) {
                nums1[tailResult] = nums2[tailNums2];
                tailResult--;
                tailNums2--;
            }

        }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {

            int positionNums1 = 0;
            int positionNums2 = 0;

            // 定义一个新的临时数组, 保存排序好的全部元素
            int[] tempNums = new int[m + n];
            int positionTempNums = 0;

            // 同时遍历数组 nums1 和 nums2
            while (positionNums1 < m & positionNums2 < n) {

                // 比较 nums1的元素 和 nums2的元素, 把较小的元素复制到新的临时数组tempNums
                if (nums1[positionNums1] <= nums2[positionNums2]) {
                    tempNums[positionTempNums] = nums1[positionNums1];
                    positionNums1++;
                    positionTempNums++;
                } else {
                    tempNums[positionTempNums] = nums2[positionNums2];
                    positionNums2++;
                    positionTempNums++;
                }
            }

            // 如果 数组nums1 还剩下元素,继续复制到新的数组
            while (positionNums1 < m) {
                tempNums[positionTempNums] = nums1[positionNums1];
                positionNums1++;
                positionTempNums++;
            }

            // 如果 数组nums2 还剩下元素,继续复制到新的数组
            while (positionNums2 < n) {
                tempNums[positionTempNums] = nums2[positionNums2];
                positionNums2++;
                positionTempNums++;
            }

            // 最后, 把临时数组的元素,全部再复制回 nums1中
            for (int i = 0; i < m + n; i++) {
                nums1[i] = tempNums[i];
            }

            return;
        }
    }
}