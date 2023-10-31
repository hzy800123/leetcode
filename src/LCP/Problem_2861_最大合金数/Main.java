package LCP.Problem_2861_最大合金数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.cn/contest/weekly-contest-363/problems/maximum-number-of-alloys/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,0], cost = [1,2,3]
        // 输出：2
//        int n = 3;
//        int k = 2;
//        int budget = 15;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(1,1,1));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(1,1,10));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(0,0,0));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(1,2,3));

        // 输入：n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,100], cost = [1,2,3]
        // 输出：5
//        int n = 3;
//        int k = 2;
//        int budget = 15;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(1,1,1));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(1,1,10));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(0,0,100));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(1,2,3));

        // 输入：n = 2, k = 3, budget = 10, composition = [[2,1],[1,2],[1,1]], stock = [1,1], cost = [5,5]
        // 输出：2
//        int n = 2;
//        int k = 3;
//        int budget = 10;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(2,1));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(1,2));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(1,1));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(1,1));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(5,5));

        // 输入：n = 4, k = 4, budget = 17, composition = [[10,10,1,5],[9,7,7,1],[6,3,5,9],[2,10,2,7]], stock = [9,8,2,7], cost = [9,2,6,10]
        // 输出：1
//        int n = 4;
//        int k = 4;
//        int budget = 17;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(10,10,1,5));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(9,7,7,1));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(6,3,5,9));
//        List<Integer> com4 = new ArrayList<>(Arrays.asList(2,10,2,7));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//        composition.add(com4);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(9,8,2,7));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(9,2,6,10));

        // 输入：n = 1, k = 3, budget = 90, composition = [[5],[3],[9]], stock = [5], cost = [10]
        // 输出：4
//        int n = 1;
//        int k = 3;
//        int budget = 90;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(5));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(3));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(9));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(5));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(10));

        // 输入：n = 1, k = 7, budget = 48, composition = [[1],[5],[9],[6],[4],[2],[4]], stock = [6], cost = [1]
        // 输出：54
//        int n = 1;
//        int k = 7;
//        int budget = 48;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(1));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(5));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(9));
//        List<Integer> com4 = new ArrayList<>(Arrays.asList(6));
//        List<Integer> com5 = new ArrayList<>(Arrays.asList(4));
//        List<Integer> com6 = new ArrayList<>(Arrays.asList(2));
//        List<Integer> com7 = new ArrayList<>(Arrays.asList(4));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//        composition.add(com4);
//        composition.add(com5);
//        composition.add(com6);
//        composition.add(com7);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(6));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(1));



        // 输入：n = 12, k = 13, budget = 4259719,
        // composition =
        // [[3,65,3,71,44,32,59,19,48,49,53,41],
        // [49,3,74,40,85,8,87,87,65,88,78,88],
        // [17,27,72,83,46,33,13,1,9,63,50,99],
        // [38,18,32,20,29,49,64,34,55,3,60,8],
        // [78,14,72,2,93,5,92,76,41,64,17,92],
        // [52,53,88,23,100,24,37,37,89,27,47,95],
        // [79,98,4,61,13,81,54,52,5,87,47,59],
        // [83,36,44,81,58,55,43,9,54,98,84,72],
        // [4,97,15,79,93,84,53,14,67,86,51,18],
        // [3,13,74,11,4,30,24,13,22,22,74,4],
        // [29,77,53,100,33,90,45,23,1,89,91,66],
        // [52,69,29,14,20,85,10,12,77,46,50,29],
        // [25,71,78,23,57,44,71,95,86,57,18,17]],

        // stock = [0,2,95,63,61,7,75,40,2,55,45,68],
        // cost = [33,40,34,38,42,74,14,14,84,73,86,19]
        // 输出：261
//        int n = 12;
//        int k = 13;
//        int budget = 4259719;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(3,65,3,71,44,32,59,19,48,49,53,41));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(49,3,74,40,85,8,87,87,65,88,78,88));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(17,27,72,83,46,33,13,1,9,63,50,99));
//        List<Integer> com4 = new ArrayList<>(Arrays.asList(38,18,32,20,29,49,64,34,55,3,60,8));
//        List<Integer> com5 = new ArrayList<>(Arrays.asList(78,14,72,2,93,5,92,76,41,64,17,92));
//        List<Integer> com6 = new ArrayList<>(Arrays.asList(52,53,88,23,100,24,37,37,89,27,47,95));
//        List<Integer> com7 = new ArrayList<>(Arrays.asList(79,98,4,61,13,81,54,52,5,87,47,59));
//        List<Integer> com8 = new ArrayList<>(Arrays.asList(83,36,44,81,58,55,43,9,54,98,84,72));
//        List<Integer> com9 = new ArrayList<>(Arrays.asList(4,97,15,79,93,84,53,14,67,86,51,18));
//        List<Integer> com10 = new ArrayList<>(Arrays.asList(3,13,74,11,4,30,24,13,22,22,74,4));
//        List<Integer> com11 = new ArrayList<>(Arrays.asList(29,77,53,100,33,90,45,23,1,89,91,66));
//        List<Integer> com12 = new ArrayList<>(Arrays.asList(52,69,29,14,20,85,10,12,77,46,50,29));
//        List<Integer> com13 = new ArrayList<>(Arrays.asList(25,71,78,23,57,44,71,95,86,57,18,17));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//        composition.add(com4);
//        composition.add(com5);
//        composition.add(com6);
//        composition.add(com7);
//        composition.add(com8);
//        composition.add(com9);
//        composition.add(com10);
//        composition.add(com11);
//        composition.add(com12);
//        composition.add(com13);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(0,2,95,63,61,7,75,40,2,55,45,68));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(33,40,34,38,42,74,14,14,84,73,86,19));


        // 输入：n = 14, k = 10, budget = 79869793,
        // composition =
        // [[40,89,95,46,38,73,89,2,20,90,95,74,89,97],
        // [91,85,10,27,60,26,39,27,66,80,99,4,45,6],
        // [77,85,63,52,60,77,64,46,75,53,99,54,80,76],
        // [82,73,65,40,41,80,7,72,73,60,41,77,3,99],
        // [91,46,36,56,55,92,1,2,93,45,54,98,35,55],
        // [6,44,11,85,52,83,13,49,48,5,55,16,7,72],
        // [38,96,93,61,63,10,8,21,23,8,31,46,3,16],
        // [85,33,94,28,69,67,100,14,25,30,56,27,7,25],
        // [10,73,15,49,8,45,67,62,19,80,99,69,66,21],
        // [56,30,79,49,59,11,33,41,45,77,29,17,84,80]],
        // stock = [92,42,100,20,66,5,11,22,72,88,56,3,96,92],
        // cost = [15,46,59,76,36,39,47,85,84,40,6,96,6,96]
        // 输出：???
//        int n = 14;
//        int k = 10;
//        int budget = 79869793;

//        List<Integer> com1 = new ArrayList<>(Arrays.asList(40,89,95,46,38,73,89,2,20,90,95,74,89,97));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(91,85,10,27,60,26,39,27,66,80,99,4,45,6));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(77,85,63,52,60,77,64,46,75,53,99,54,80,76));
//        List<Integer> com4 = new ArrayList<>(Arrays.asList(82,73,65,40,41,80,7,72,73,60,41,77,3,99));
//        List<Integer> com5 = new ArrayList<>(Arrays.asList(91,46,36,56,55,92,1,2,93,45,54,98,35,55));
//        List<Integer> com6 = new ArrayList<>(Arrays.asList(6,44,11,85,52,83,13,49,48,5,55,16,7,72));
//        List<Integer> com7 = new ArrayList<>(Arrays.asList(38,96,93,61,63,10,8,21,23,8,31,46,3,16));
//        List<Integer> com8 = new ArrayList<>(Arrays.asList(85,33,94,28,69,67,100,14,25,30,56,27,7,25));
//        List<Integer> com9 = new ArrayList<>(Arrays.asList(10,73,15,49,8,45,67,62,19,80,99,69,66,21));
//        List<Integer> com10 = new ArrayList<>(Arrays.asList(56,30,79,49,59,11,33,41,45,77,29,17,84,80));

//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//        composition.add(com4);
//        composition.add(com5);
//        composition.add(com6);
//        composition.add(com7);
//        composition.add(com8);
//        composition.add(com9);
//        composition.add(com10);


//        List<Integer> stock = new ArrayList<>(Arrays.asList(6));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(1));

//        List<Integer> stock = new ArrayList<>(Arrays.asList(92,42,100,20,66,5,11,22,72,88,56,3,96,92));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(15,46,59,76,36,39,47,85,84,40,6,96,6,96));

        // 输入：n = 15, k = 17, budget = 80884895,
        // composition =
        // [[53,57,69,73,13,41,70,74,50,74,64,54,93,86,66],
        // [73,85,78,31,68,34,65,70,58,92,54,24,5,94,79],
        // [19,12,21,48,18,62,37,38,94,16,30,88,23,18,48],
        // [62,74,62,77,57,23,42,90,46,88,76,22,60,1,62],
        // [99,37,97,67,51,97,75,40,49,40,77,12,27,62,37],
        // [27,9,32,20,2,36,95,30,96,51,67,23,29,56,39],
        // [69,83,34,27,75,42,14,59,20,34,75,3,56,53,43],
        // [33,42,26,21,10,25,6,94,7,64,65,58,94,83,7],
        // [88,11,62,92,90,69,1,54,6,44,82,5,28,46,47],
        // [61,16,58,87,5,95,23,93,14,58,77,32,37,72,39],
        // [64,14,55,81,60,52,36,9,97,84,55,41,28,75,37],
        // [5,5,97,92,18,3,65,69,95,70,61,7,47,100,19],
        // [90,66,53,17,94,70,53,42,34,19,94,29,31,58,11],
        // [44,77,21,33,98,84,28,74,39,49,57,47,72,95,29],
        // [89,68,13,47,29,57,36,47,46,69,97,81,23,33,45],
        // [27,63,96,44,22,1,59,31,87,54,10,66,62,54,88],
        // [87,25,6,46,44,3,31,97,83,58,6,46,92,57,45]]

        // stock = [24,13,1,7,76,99,26,62,25,65,47,27,93,41,5],
        // cost = [45,6,87,41,82,40,36,26,53,92,100,89,23,39,75]
        // 输出：2443
//        int n = 15;
//        int k = 17;
//        int budget = 80884895;
//
//        List<Integer> com1 = new ArrayList<>(Arrays.asList(53,57,69,73,13,41,70,74,50,74,64,54,93,86,66));
//        List<Integer> com2 = new ArrayList<>(Arrays.asList(73,85,78,31,68,34,65,70,58,92,54,24,5,94,79));
//        List<Integer> com3 = new ArrayList<>(Arrays.asList(19,12,21,48,18,62,37,38,94,16,30,88,23,18,48));
//        List<Integer> com4 = new ArrayList<>(Arrays.asList(62,74,62,77,57,23,42,90,46,88,76,22,60,1,62));
//        List<Integer> com5 = new ArrayList<>(Arrays.asList(99,37,97,67,51,97,75,40,49,40,77,12,27,62,37));
//        List<Integer> com6 = new ArrayList<>(Arrays.asList(27,9,32,20,2,36,95,30,96,51,67,23,29,56,39));
//        List<Integer> com7 = new ArrayList<>(Arrays.asList(69,83,34,27,75,42,14,59,20,34,75,3,56,53,43));
//        List<Integer> com8 = new ArrayList<>(Arrays.asList(33,42,26,21,10,25,6,94,7,64,65,58,94,83,7));
//        List<Integer> com9 = new ArrayList<>(Arrays.asList(88,11,62,92,90,69,1,54,6,44,82,5,28,46,47));
//        List<Integer> com10 = new ArrayList<>(Arrays.asList(61,16,58,87,5,95,23,93,14,58,77,32,37,72,39));
//        List<Integer> com11 = new ArrayList<>(Arrays.asList(64,14,55,81,60,52,36,9,97,84,55,41,28,75,37));
//        List<Integer> com12 = new ArrayList<>(Arrays.asList(5,5,97,92,18,3,65,69,95,70,61,7,47,100,19));
//        List<Integer> com13 = new ArrayList<>(Arrays.asList(90,66,53,17,94,70,53,42,34,19,94,29,31,58,11));
//        List<Integer> com14 = new ArrayList<>(Arrays.asList(44,77,21,33,98,84,28,74,39,49,57,47,72,95,29));
//        List<Integer> com15 = new ArrayList<>(Arrays.asList(89,68,13,47,29,57,36,47,46,69,97,81,23,33,45));
//        List<Integer> com16 = new ArrayList<>(Arrays.asList(27,63,96,44,22,1,59,31,87,54,10,66,62,54,88));
//        List<Integer> com17 = new ArrayList<>(Arrays.asList(87,25,6,46,44,3,31,97,83,58,6,46,92,57,45));
//        List<List<Integer>> composition = new ArrayList<>();
//        composition.add(com1);
//        composition.add(com2);
//        composition.add(com3);
//        composition.add(com4);
//        composition.add(com5);
//        composition.add(com6);
//        composition.add(com7);
//        composition.add(com8);
//        composition.add(com9);
//        composition.add(com10);
//        composition.add(com11);
//        composition.add(com12);
//        composition.add(com13);
//        composition.add(com14);
//        composition.add(com15);
//        composition.add(com16);
//        composition.add(com17);
//
//        List<Integer> stock = new ArrayList<>(Arrays.asList(24,13,1,7,76,99,26,62,25,65,47,27,93,41,5));
//        List<Integer> cost = new ArrayList<>(Arrays.asList(45,6,87,41,82,40,36,26,53,92,100,89,23,39,75));


        // 输入：n = 1, k = 2, budget = 24308609, composition = [[40], [88]], stock = [82685338], cost = [2]
        // 输出：2370991
        int n = 1;
        int k = 2;
        int budget = 24308609;

        List<Integer> com1 = new ArrayList<>(Arrays.asList(40));
        List<Integer> com2 = new ArrayList<>(Arrays.asList(88));
        List<List<Integer>> composition = new ArrayList<>();
        composition.add(com1);
        composition.add(com2);

        List<Integer> stock = new ArrayList<>(Arrays.asList(82685338));
        List<Integer> cost = new ArrayList<>(Arrays.asList(2));

        Solution solution = new Solution();
        int result = solution.maxNumberOfAlloys(n, k, budget, composition, stock, cost);
        int result0 = solution.maxNumberOfAlloys0(n, k, budget, composition, stock, cost);
        int result2 = solution.maxNumberOfAlloys2(n, k, budget, composition, stock, cost);

        System.out.println("result = " + result);
        System.out.println("result0 = " + result0);
        System.out.println("result2 = " + result2);
    }


    static class Solution {

        public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {

            // 估算 查找的区间，最小值为0
            int minMetalCount = 0;

            // 估算 查找的区间，最大值是 "库存的最小值 + 预算值"，
            // 假设机器的每一种类型的金属元素的需要份数为1，并且每一份的金属元素的花费为1。
            int maxMetalCount = Collections.min(stock) + budget;

            int metalCountResult = 0;
            int maxMetalCountResult = Integer.MIN_VALUE;
            boolean canMakeMetalWithCount = false;


            // 遍历 每台机器，比较获得可以制造最多块合金的机器，返回 它所制造的合金数量
            for (int i = 0; i < composition.size(); i++) {

                canMakeMetalWithCount = checkMakeMetalUnderBudget(maxMetalCount, budget, composition.get(i), stock, cost);
                if (canMakeMetalWithCount) {
                    metalCountResult = maxMetalCount;
                    maxMetalCountResult = Math.max(maxMetalCountResult, metalCountResult);
                    continue;
                }

                int lowCount = 0;
                int highCount = 0;
                int midMetalCount = 0;
                int preMidMetalCount = -1;
                int prePreMidMetalCount = -2;

                lowCount = minMetalCount;
                highCount = maxMetalCount;

                // 上面可以估算得到 查找的区间（可能制造的合金数量的 最小值和最大值），
                // 并且区间内元素是单调递增 （制造的合金数量 与 总的费用，是单调递增性）
                // 使用 二分法，查找 符合的结果
                while (lowCount < highCount) {
                    prePreMidMetalCount = preMidMetalCount;
                    preMidMetalCount = midMetalCount;
                    midMetalCount = lowCount + ( highCount - lowCount ) / 2;

                    // Found the result Count
                    if (midMetalCount == prePreMidMetalCount) {
                        metalCountResult = midMetalCount;
                        break;
                    }

                    canMakeMetalWithCount = checkMakeMetalUnderBudget(midMetalCount, budget, composition.get(i), stock, cost);

                    if (canMakeMetalWithCount) {
                        lowCount = midMetalCount;
                    } else {
                        highCount = midMetalCount;
                    }
                }

                // 打擂台，比较获得 可以制造最多数量合金的机器，它所制造的合金数量
                maxMetalCountResult = Math.max(maxMetalCountResult, metalCountResult);
            }

            return maxMetalCountResult;
        }

        private boolean checkMakeMetalUnderBudget(int metalCount, int budget,
                                               List<Integer> machineRequired, List<Integer> stock, List<Integer> cost) {

            List<Integer> stockTemp = new ArrayList<>(stock);
            long sumCost = 0;
            long eachMetalTotalRequired = 0;

            // 遍历机器的需要的各个类型金属元素
            for (int k = 0; k < stockTemp.size(); k++) {

                // 计算 制造指定数量的合金，所需要的其中一种类型金属元素的总量
                eachMetalTotalRequired = (long)machineRequired.get(k) * metalCount;

                // 如果 对应的类型的金属元素 的库存 >= 所需要的总量，则此项花费=0
                // 否则，计算 对应的金属元素的花费
                if (stockTemp.get(k) >= eachMetalTotalRequired) {
                    continue;
                } else {
                    sumCost = sumCost + (eachMetalTotalRequired - stockTemp.get(k)) * cost.get(k);

                    // 如果累计的 花费 > 预算值，立即返回false
                    if (sumCost > budget) {
                        return false;
                    }
                }
            }

            // 累计的花费 <= 预算制，返回true
            return true;
        }



        public int maxNumberOfAlloys0(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
            int ans = 0;
            int mx = Collections.min(stock) + budget;
            for (List<Integer> com : composition) {
                int left = 0, right = mx + 1;
                while (left + 1 < right) { // 开区间写法
                    int mid = (left + right) / 2;
                    boolean ok = true;
                    long money = 0;
                    for (int i = 0; i < n; ++i) {
                        if (stock.get(i) < (long) com.get(i) * mid) {
                            money += ((long) com.get(i) * mid - stock.get(i)) * cost.get(i);
                            if (money > budget) {
                                ok = false;
                                break;
                            }
                        }
                    }
                    if (ok) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                ans = Math.max(ans, left);
            }
            return ans;
        }


        public int maxNumberOfAlloys2(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {

            int lowestCountResult = 0;

            for (int i = 0; i < composition.size(); i++) {
                long totalCost = 0;
                int countResult = 0;
                List<Integer> stockTemp = new ArrayList<>(stock);

                while (totalCost <= budget) {
                    long tempCost = tryMakeOneMetal(composition.get(i), stockTemp, cost);
                    totalCost = totalCost + tempCost;
                    countResult++;
                }

                countResult--;

                lowestCountResult = Math.max(lowestCountResult, countResult);
            }

            return lowestCountResult;

        }


        private long tryMakeOneMetal(List<Integer> machineRequired, List<Integer> stock, List<Integer> cost) {

            long costSum = 0;

            for (int i = 0; i < machineRequired.size(); i++) {
                int oneSubMetalRequired = machineRequired.get(i);

                // 库存 >= 所需要的某一类型的金属，则不需要计算cost
                if (oneSubMetalRequired <= stock.get(i)) {
                    stock.set(i, stock.get(i) - oneSubMetalRequired);
                } else {
                    costSum = costSum + ((long)(oneSubMetalRequired - stock.get(i))) * cost.get(i);
                    stock.set(i, 0);
                }
            }

            return costSum;
        }


    }
}