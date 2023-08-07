package 前缀和.Problem_724_寻找数组的中心下标;

/*
https://leetcode.cn/problems/find-pivot-index/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [1, 7, 3, 6, 5, 6]
        // 输出：3
//        int[] nums = new int[]{1, 7, 3, 6, 5, 6};

        // 输入：nums = [1, 2, 3]
        // 输出：-1
//        int[] nums = new int[]{1, 2, 3};

        // 输入：nums = [2, 1, -1]
        // 输出：0
//        int[] nums = new int[]{2, 1, -1};

        // 输入：nums = [-1, 1, 2]
        // 输出：2
//        int[] nums = new int[]{-1, 1, 2};

        // 输入：nums = [-1,-1,0,1,1,-1]
        // 输出：0
        int[] nums = new int[]{-1,-1,0,1,1,-1};

        Solution solution = new Solution();
        int result = solution.pivotIndex(nums);
        System.out.println("result = " + result);
    }

    static class Solution {

        public int pivotIndex(int[] nums) {

            int numsLength = nums.length;
            // 建立一个新的临时数组, 保存前缀和
            // sumArr[i] 表示从 开始 到 i位置 的所有数字的和
            int[] sumsArr = new int[numsLength];
            int totalSum = 0;

            // 计算 前缀和 数组的各个值
            sumsArr[0] = nums[0];
            for (int i = 1; i < numsLength; i++) {
                sumsArr[i] = nums[i] +sumsArr [i - 1];
            }

            // 所有数字的总和
            totalSum = sumsArr[numsLength - 1];

            // 如果, 除了第一个数字, 其他的所有数字的和为0, 立即返回下标0
            if (totalSum - nums[0] == 0) {
                return 0;
            }

            // 遍历 前缀和的数组, 查找第一个 满足条件的 中心下标
            // 下标 左边的数字的和 == 下标 右边的数字的和
            for (int j = 1; j < numsLength; j++) {
                if (sumsArr[j - 1] * 2 + nums[j] == totalSum) {
                    return j;
                }
            }

            // 如果 没有符合条件的中心下标, 返回-1
            return -1;
        }

    }
}