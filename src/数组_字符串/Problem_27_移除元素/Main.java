package 数组_字符串.Problem_27_移除元素;

/*
https://leetcode.cn/problems/remove-element/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [3,2,2,3], val = 3
        // 输出：2, nums = [2,2]
        int[] nums = new int[]{3,2,2,3};
        int val = 3;

        // 输入：nums = [0,1,2,2,3,0,4,2], val = 2
        // 输出：5, nums = [0,1,4,0,3]
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
//        int val = 2;

        // 输入：nums = [2], val = 3
        // 输出：[2]
//        int[] nums = new int[]{2};
//        int val = 3;

        // 输入：nums = [2,1], val = 3
        // 输出：[2,1]
//        int[] nums = new int[]{2,1};
//        int val = 3;

        // 输入：nums = [3,3], val = 3
        // 输出：[]
//        int[] nums = new int[]{3,3};
//        int val = 3;

        Solution solution = new Solution();
        int result = solution.removeElement(nums, val);

        System.out.println("result = " + result);
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int length = nums.length;
            int temp = 0;

            // i为左指针
            int i = 0;
            // j 为右指针
            int j = length - 1;


            while (i <= j) {
                if (nums[i] != val) {
                    i++;
                    continue;
                }

                // 如果等于val,需要使用右指针,进行交换元素
                if (nums[i] == val) {
                    if (i == j) {
                        break;
                    }

                    while (i < j) {
                        // 如果右指针的值等于val,右指针向左移动
                        if (nums[j] == val) {
                            j--;
                            continue;
                        } else {
                            // 交换元素
                            temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            i++;
                            j--;
                            break;
                        }
                    }
                }
            }

            return i;
        }
    }


}