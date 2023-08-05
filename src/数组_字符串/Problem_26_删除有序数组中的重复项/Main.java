package 数组_字符串.Problem_26_删除有序数组中的重复项;

/*
https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [1,1,2]
        // 输出：2, nums = [1,2,_]
//        int[] nums = new int[]{1,1,2};

        // 输入：nums = [0,0,1,1,1,2,2,3,3,4]
        // 输出：5, nums = [0,1,2,3,4]
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        // 输入：nums = [1,1]
        // 输出：1, nums = [1,_]
//        int[] nums = new int[]{1,1};

        Solution solution = new Solution();
        int result = solution.removeDuplicates(nums);

        System.out.println("result = " + result);
    }

    static class Solution {

        public int removeDuplicates(int[] nums) {
            // 定义 左指针
            int l = 0;
            // 定义 右指针
            int r = 1;

            while (l < nums.length) {

                while (r < nums.length) {
                    if (nums[l] == nums[r]) {
                        r++;
                    } else {
                        // 如果 右指针的数 > 左指针的数,把值搬到左指针的位置.
                        nums[l+1] = nums[r];
                        // 左右指针,向前移动
                        l++;
                        r++;
                        break;
                    }
                }

                // 如果 右指针超过了总长度,退出循环
                if (r >= nums.length) {
                    break;
                }
            }

            return l + 1;
        }
    }
}