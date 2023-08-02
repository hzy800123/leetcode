package 哈希表.Problem_202_快乐数;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 19
        // 输出：true
        /*
            解释：
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1
         */
        int n = 19;

        // 输入：n = 2
        // 输出：false
//        int n = 2;

        Solution solution = new Solution();
        boolean result = solution.isHappy(n);
        System.out.println("result = " + result);
    }

    static class Solution {

        public boolean isHappy(int n) {
            String str = String.valueOf(n);
            int currentInt = 0;
            int tempSum = 0;
            int strLength = 0;
            // 建立一个 HashSet,保存出现过的数字(字符)
            HashSet<String> hashSet = new HashSet<>();

            for (int j = 0; j < 100; j++) {

                tempSum = 0;
                strLength = str.length();
                for (int i = 0; i < strLength; i++) {
                    currentInt = Integer.valueOf(str.substring(i, i+1));
                    tempSum = tempSum + currentInt * currentInt;
                }

                str = String.valueOf(tempSum);

                // 如果之前的计算,没有出现过这个数字(字符),加入HashSet中
                // 如果已经出现过这个数字(字符),可以返回false
                if (!hashSet.contains(str)) {
                    hashSet.add(str);
                } else {
                    System.out.println("Already contain string : " + str);
                    return false;
                }

                System.out.println("tempSum = " + tempSum);

                if (tempSum == 1) {
                    return true;
                }
            }

            return false;
        }
    }
}