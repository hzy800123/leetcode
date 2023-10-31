package LCP.Problem_2906_构造乘积矩阵;

/*
https://leetcode.cn/contest/weekly-contest-367/problems/construct-product-matrix/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：grid = [[1,2],[3,4]]
        // 输出：[[24,12],[8,6]]
//        int[][] grid = new int[][]{{1,2},{3,4}};

        // 输入：grid = [[12345],[2],[1]]
        // 输出：[[2],[0],[0]]
//        int[][] grid = new int[][]{{12345,2,1}};

        //  输入：grid = [[4,3,9],[3,9,10],[9,7,8],[8,4,7],[6,1,3]]
        // 输出：[[3255,225,75],[225,75,11178],[75,1860,7800],[7800,3255,1860],[6285,675,225]]
//        int[][] grid = new int[][]{{4,3,9},{3,9,10},{9,7,8},{8,4,7},{6,1,3}};

        // 输入：[[10,20],[18,16],[17,14],[16,9],[14,6],[16,5],[14,8],[20,13],[16,10],[14,17]]
        // 输出：[[345,6345],[7050,4845],[4560,2010],[4845,1755],[2010,8805],[4845,690],[2010,9690],[6345,1215],[4845,345],[2010,4560]]
//        int[][] grid = new int[][]{{10,20},{18,16},{17,14},{16,9},{14,6},{16,5},{14,8},{20,13},{16,10},{14,17}};

        // 输入：[[31,29,9,19],[32,24,9,11],[11,11,7,18],[31,21,34,29],[34,12,29,14],[26,11,6,33],[3,17,2,28],[30,11,32,26],[8,8,10,33],[11,20,10,32],[11,29,9,33],[12,20,32,22],[21,10,22,19],[4,32,3,11],[30,15,31,29],[2,13,18,23],[16,6,26,23]]
        // 输出：[[585,6585,10245,12000],[7125,5385,10245,7260],[7260,7260,9645,11295],[585,11445,3075,6585],[3075,10770,6585,10995],[6870,7260,9195,10650],[6045,6150,2895,11670],[11715,7260,7125,6870],[3810,3810,10455,10650],[7260,11400,10455,7125],[7260,6585,10245,10650],[10770,11400,7125,3630],[11445,10455,3630,12000],[7620,7125,6045,7260],[11715,11085,585,6585],[2895,1395,11295,12060],[1905,9195,6870,12060]]
//        int[][] grid = new int[][]{{31,29,9,19},{32,24,9,11},{11,11,7,18},{31,21,34,29},{34,12,29,14},{26,11,6,33},{3,17,2,28},{30,11,32,26},{8,8,10,33},{11,20,10,32},{11,29,9,33},{12,20,32,22},{21,10,22,19},{4,32,3,11},{30,15,31,29},{2,13,18,23},{16,6,26,23}};

        // 输入： [[1745611,16766797,661698752,284380937,619897726,866046517,920838523,972750105,856911602,751183848,782982127,471659978,524687057,439474821,834741991,740248896,835960599,621443578,218105027,350570600,237303156,720377732,585295552]]
        // 输出：[[1740,5430,8520,675,11700,4860,9420,2685,4485,5520,1425,4875,8730,1080,1380,8895,5070,6375,10215,10350,3645,7815,9915]]
        int[][] grid = new int[][]{{1745611,16766797,661698752,284380937,619897726,866046517,920838523,972750105,856911602,751183848,782982127,471659978,524687057,439474821,834741991,740248896,835960599,621443578,218105027,350570600,237303156,720377732,585295552}};

        Solution solution = new Solution();
        int[][] result = solution.constructProductMatrix(grid);

        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + ", ");
            }
            System.out.println("");
        }
    }


    static class Solution {

        public int[][] constructProductMatrix(int[][] grid) {

            int rowsCount = grid.length;
            int colCount = grid[0].length;
            int[][] numResults = new int[rowsCount][colCount];

            // 前缀的乘积，保存在一个数组里
            long[] prefixMulResult = new long[rowsCount * colCount];
            // 后缀的乘积，保存在一个数组里
            long[] suffixMulResult = new long[rowsCount * colCount];

            // 先求 前缀的乘积（左边的连续的数组数字的乘积）
            int index = 0;
            long temp = 1;
            for (int i = 0; i < rowsCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    temp = temp * (grid[i][j] % 12345);
                    if (temp > 12345) {
                        temp = temp % 12345;
                    }
                    prefixMulResult[index] = temp;
                    index++;
                }
            }

            // 再求 后缀的乘积 （右边的连续的数组数字的乘积）
            index = 0;
            temp = 1;
            for (int i = 0; i < rowsCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    temp = temp * (grid[rowsCount - 1 - i][colCount - 1 - j] % 12345);
                    if (temp > 12345) {
                        temp = temp % 12345;
                    }
                    suffixMulResult[rowsCount * colCount - 1 - index] = temp;
                    index++;
                }
            }

            // 最后，求结果数组的每个数字，根据题意：resultNum = prefixMulResult[index - 1] * suffixMulResult[index + 1]
            // 注意：边界的情况 index - 1 < 0, index + 1 > 数组的边界 (rowsCount * colCount - 1)
            index = 0;
            long resultNum = 1;
            long prefixResult = 1;
            long suffixResult = 1;
            for (int m = 0; m < rowsCount; m++) {
                for (int n = 0; n < colCount; n++) {
                    prefixResult = (index - 1 < 0) ? 1 : prefixMulResult[index - 1];
                    suffixResult = ((index + 1) > (rowsCount * colCount - 1)) ? 1 : suffixMulResult[index + 1];

                    resultNum = (prefixResult * suffixResult) % 12345;
                    numResults[m][n] = (int) resultNum;
                    index++;
                }
            }

            return numResults;
        }
    }
}