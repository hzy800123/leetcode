package LCP.Problem_2849_判断能否在给定时间到达单元格;

/*
https://leetcode.cn/problems/determine-if-a-cell-is-reachable-at-a-given-time/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：sx = 2, sy = 4, fx = 7, fy = 7, t = 6
        // 输出：true
//        int sx = 2;
//        int sy = 4;
//        int fx = 7;
//        int fy = 7;
//        int t = 6;

        // 输入：sx = 3, sy = 1, fx = 7, fy = 3, t = 3
        // 输出：false
//        int sx = 3;
//        int sy = 1;
//        int fx = 7;
//        int fy = 3;
//        int t = 3;

        // 输入：sx = 1, sy = 2, fx = 1, fy = 2, t = 1
        // 输出：false
        int sx = 1;
        int sy = 2;
        int fx = 1;
        int fy = 2;
        int t = 1;

        Solution solution = new Solution();
        boolean result = solution.isReachableAtTime(sx, sy, fx, fy, t);

        System.out.println("result = " + result);
    }


    static class Solution {

        public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {

            // 如果 开始和结束的位置的横坐标的差 大于 t，则返回false
            if (Math.abs(fx - sx) > t) {
                return false;
            }

            // 如果 开始和结束的位置的纵坐标的差 大于 t，则返回false
            if (Math.abs(fy - sy) > t) {
                return false;
            }

            // 如果 开始和结束的位置相同，而且t==1，则放回false
            if (sx == fx && sy == fy && t == 1) {
                return false;
            }

            // 其他情况，返回true
            return true;
        }
    }
}