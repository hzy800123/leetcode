package 双指针.Problem_283_移动零;

/*
https://leetcode.cn/problems/move-zeroes/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入: nums = [0,1,0,3,12]
        // 输出: [1,3,12,0,0]
//        int[] nums = new int[]{0,1,0,3,12};

        // 输入: nums = [0]
        // 输出: [0]
        int[] nums = new int[]{0};

        Solution solution = new Solution();
        solution.moveZeroes(nums);
    }

    static class Solution {

        public void moveZeroes(int[] nums) {

            /*
            1 2 3 0 0 5 6 7
                  L   R
             */
            // 设置 左指针, 左指针的左边 都是已经处理好的非0的数字
            // 左指针 向右移动, 停在第一个0的位置
            int left = 0;

            // 设置 右指针, 右指针的右边, 都是还没有处理的数字
            // 右指针 向右移动, 停在第一个非0的位置
            int right = 0;

            // 用于交换元素的临时保存的变量
            int temp = 0;
            int numsLength = nums.length;

            while (right < numsLength) {
                // 如果 右指针 遇到0, 继续向右移动
                if (nums[right] == 0) {
                    right++;
                    continue;
                }

                // 以下代码, 右指针已经停在第一个非0的位置
                while (left < right) {
                    // 如果 左指针 遇到非0, 继续向右移动
                    if (nums[left] != 0) {
                        left++;
                        continue;
                    }

                    // 以下代码, 左指针已经停在第一个0的位置

                    // 交换 左指针 和 右指针 的2个元素
                    temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;

                    // 左指针 不需要+1, 直接跳出内部循环
                    // 如果 下一次再进入内部循环, 左指针 还会继续向右移动
                    break;
                }

                // 右指针+1, 右指针继续向右移动
                right++;
            }

            return;
        }

    }

}