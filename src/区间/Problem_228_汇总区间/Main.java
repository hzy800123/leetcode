package 区间.Problem_228_汇总区间;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/summary-ranges/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：nums = [0,1,2,4,5,7]
        // 输出：["0->2","4->5","7"]
//        int[] nums = new int[]{0,1,2,4,5,7,8};

        // 输入：nums = [0,2,3,4,6,8,9]
        // 输出：["0","2->4","6","8->9"]
//        int[] nums = new int[]{0,2,3,4,6,8,9};

        // 输入：nums = []
        // 输出：[]
        int[] nums = new int[]{};

        Solution solution = new Solution();
        List result = solution.summaryRanges(nums);
        System.out.println("result = " + result);
    }

    static class Solution {

        public List<String> summaryRanges(int[] nums) {

            List<String> list = new ArrayList<>();
            int numsLength = nums.length;
            // 如果 nums的长度为0, 返回空list
            if (nums.length == 0) {
                return list;
            }

            // 保存 左指针对应的值,以及右指针对应的值
            int leftValue = nums[0];
            int rightValue = nums[0];
            StringBuffer stringBuffer = null;

            // 遍历int数组,查找连续的区间
            for (int i = 0; i < numsLength - 1; i++) {
                if (nums[i+1] > rightValue + 1) {
                    stringBuffer = new StringBuffer();
                    stringBuffer.append(leftValue);
                    // 如果 左值和右值相等,只需要输出一个值
                    if (leftValue < rightValue) {
                        stringBuffer.append("->");
                        stringBuffer.append(rightValue);
                    }
                    list.add(stringBuffer.toString());
                    leftValue = nums[i+1];
                    rightValue = nums[i+1];
                } else {
                    rightValue = nums[i+1];
                }
            }

            // 循环之后,还需要把最后的值,一起输出.
            stringBuffer = new StringBuffer();
            stringBuffer.append(leftValue);
            if (leftValue < rightValue) {
                stringBuffer.append("->");
                stringBuffer.append(rightValue);
            }
            list.add(stringBuffer.toString());

            return list;
        }
    }
}