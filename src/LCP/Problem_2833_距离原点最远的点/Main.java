package LCP.Problem_2833_距离原点最远的点;

/*
https://leetcode.cn/contest/weekly-contest-360/problems/furthest-point-from-origin/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：moves = "L_RL__R"
        // 输出：3
//        String moves = "L_RL__R";

        // 输入：moves = "_R__LL_"
        // 输出：5
//        String moves = "_R__LL_";

        // 输入：moves = "_______"
        // 输出：7
        String moves = "_______";

        Solution solution = new Solution();
        int result = solution.furthestDistanceFromOrigin(moves);

        System.out.println("result = " + result);
    }


    static class Solution {

        public int furthestDistanceFromOrigin(String moves) {

            char[] chars = moves.toCharArray();
            int countL = 0;
            int countR = 0;
            int countUnderLine = 0;
            int resultDistance = 0;

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'L') {
                    countL ++;
                }

                if (chars[i] == 'R') {
                    countR ++;
                }

                if (chars[i] == '_') {
                    countUnderLine ++;
                }
            }

            if (countL > countR) {
                resultDistance = countL - countR + countUnderLine;
            } else {
                resultDistance = countR - countL + countUnderLine;
            }

            return resultDistance;
        }
    }
}