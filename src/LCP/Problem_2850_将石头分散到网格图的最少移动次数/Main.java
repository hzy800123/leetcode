package LCP.Problem_2850_将石头分散到网格图的最少移动次数;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.cn/problems/minimum-moves-to-spread-stones-over-grid/description/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：grid = [[1,1,0],[1,1,1],[1,2,1]]
        // 输出：3
//        int[][] grid = new int[][]{{1,1,0}, {1,1,1}, {1,2,1}};

        // 输入：grid = [[1,3,0],[1,0,0],[1,0,3]]
        // 输出：4
//        int[][] grid = new int[][]{{1,3,0}, {1,0,0}, {1,0,3}};

        // 输入：grid = [[1,0,0],[4,1,1],[0,2,0]]
        // 输出：7
//        int[][] grid = new int[][]{{1,0,0}, {4,1,1}, {0,2,0}};

        // 输入：grid = [[0,1,4],[0,3,0],[0,1,0]]
        // 输出：8
        int[][] grid = new int[][]{{0,1,4}, {0,3,0}, {0,1,0}};

        Solution solution = new Solution();
        int result = solution.minimumMoves(grid);

        System.out.println("result = " + result);

        char[] data = "ABC".toCharArray();
        solution.f(data, 0);
    }


    static class Solution {

        // 递归函数：
        // k表示当前的交换位置。
        public void f(char[] data,int k){

            // 如果集合所有元素被标记：
            // 将临时储存添加到结果集中
            if(k == data.length){
                for(int i=0;i<data.length;i++){
                    System.out.print((data[i]+" "));
                } System.out.println();
            }

            // 否则：
            // 从集合中未标记的元素中选取一个存储到临时集合中
            // 标记该元素被使用
            for(int i = k; i < data.length; i++){
                {char t = data[k]; data[k] = data[i]; data[i] = t;}
                // 下一层递归函数
                f(data,k+1);
                // (这层递归结束)标记该元素未被使用
                {char t = data[k]; data[k] = data[i]; data[i] = t;} //回溯
            }
        }


        public int minimumMoves(int[][] grid) {

            List<Pair<Integer, Integer>> zeroPointList = new ArrayList<>();
            List<Pair<Integer, Integer>> moreThanOneList = new ArrayList<>();

//            int[][] newGrid = new int[3][3];
//            for (int k = 0; k < 3; k++) {
//                for (int l = 0; l < 3; l++) {
//                    newGrid[k][l] = grid[k][l];
//                }
//            }

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == 0) {
                        zeroPointList.add(new Pair<>(i, j));
                    }

                    if (grid[i][j] > 1) {
                        for (int k = 0; k < grid[i][j] - 1; k++) {
                            moreThanOneList.add(new Pair<>(i, j));
                        }
                    }
                }
            }


            f(data, 0);
            zeroPointList.set()
//            List<Pair<Integer, Integer>> newZeroPointList = new ArrayList<>(zeroPointList);
//            Collections.reverse(newZeroPointList);

            int countResult1 = 0;

            int step = 1;
            while (zeroPointList.size() > 0) {
                for (int m = 0; m < zeroPointList.size(); m++) {
                    Pair<Integer, Integer> zeroPointItem = zeroPointList.get(m);
                    int x = zeroPointItem.getKey();
                    int y = zeroPointItem.getValue();

                    boolean result = findNearbyMoreThanOnePoint(grid, x, y, step, zeroPointList, m);
                    if (result) {
                        countResult1 = countResult1 + step;
                        m--;
                    }
                }

                step++;
            }

//            int countResult2 = 0;
//
//            int step2 = 1;
//            while (newZeroPointList.size() > 0) {
//                for (int m = 0; m < newZeroPointList.size(); m++) {
//                    Pair<Integer, Integer> zeroPointItem = newZeroPointList.get(m);
//                    int x = zeroPointItem.getKey();
//                    int y = zeroPointItem.getValue();
//
//                    boolean result = findNearbyMoreThanOnePoint(newGrid, x, y, step2, newZeroPointList, m);
//                    if (result) {
//                        countResult2 = countResult2 + step2;
//                        m--;
//                    }
//                }
//
//                step2++;
//            }

//            return Math.min(countResult1, countResult2);
            return countResult1;
        }

        private boolean findNearbyMoreThanOnePoint(int[][] grid, int x, int y, int step,
                                                List<Pair<Integer, Integer>> zeroPointList, int m) {
            if (step == 1) {
                if (y - 1 >= 0) {
                    if (grid[x][y-1] > 1) {
                        grid[x][y-1]--;
                        zeroPointList.remove(m);
                        return true;
                    }
                }
                if (y + 1 <= 2) {
                    if (grid[x][y+1] > 1) {
                        grid[x][y+1]--;
                        zeroPointList.remove(m);
                        return true;
                    }
                }
                if (x - 1 >= 0) {
                    if (grid[x-1][y] > 1) {
                        grid[x-1][y]--;
                        zeroPointList.remove(m);
                        return true;
                    }
                }
                if (x + 1 <= 2) {
                    if (grid[x+1][y] > 1) {
                        grid[x+1][y]--;
                        zeroPointList.remove(m);
                        return true;
                    }
                }
            }

            if (step > 1) {
                if (y - 1 >= 0) {
                    if (findNearbyMoreThanOnePoint(grid, x, y-1, step-1,
                            zeroPointList, m)) {
                        return true;
                    }
                }
                if (y + 1 <= 2) {
                    if (findNearbyMoreThanOnePoint(grid, x, y+1, step-1,
                            zeroPointList, m)) {
                        return true;
                    }
                }
                if (x - 1 >= 0) {
                    if (findNearbyMoreThanOnePoint(grid, x-1, y, step-1,
                            zeroPointList, m)) {
                        return true;
                    }
                }
                if (x + 1 <= 2) {
                    if (findNearbyMoreThanOnePoint(grid, x+1, y, step-1,
                            zeroPointList, m)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}