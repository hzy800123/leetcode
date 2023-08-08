package 前缀和.Problem_1732_找到最高海拔;

/*
https://leetcode.cn/problems/find-the-highest-altitude/
 */
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：gain = [-5,1,5,0,-7]
        // 输出：1
        int[] nums = new int[]{-5,1,5,0,-7};

        // 输入：gain = [-4,-3,-2,-1,4,3,2]
        // 输出：0
//        int[] nums = new int[]{-4,-3,-2,-1,4,3,2};

        Solution solution = new Solution();
        int result = solution.largestAltitude(nums);
        System.out.println("result = " + result);
    }

    static class Solution {

        public int largestAltitude(int[] gain) {

            int gainLength = gain.length;
            // 前缀和 数组
            int[] sumArr = new int[gainLength];
            int sumPre = 0;
            // 保存 最大的海拔高度值
            int max = 0;

            // 遍历数组的数字, 获取 前缀和 的数组, 并且用打擂台方式, 求最大的前缀和的值
            for (int i = 0; i < gainLength; i++) {
                sumArr[i] = sumPre + gain[i];
                sumPre = sumArr[i];
                max = Math.max(max, sumArr[i]);
            }

            // 或者, 也可以用临时变量, 仅保存每次的前缀和的值, 不需要数组保存全部的前缀和的值
//            int sumCur = 0;
//            for (int i = 0; i < gainLength; i++) {
//                sumCur = sumPre + gain[i];
//                sumPre = sumCur;
//                max = Math.max(max, sumCur);
//            }

            return max;
        }
    }
}