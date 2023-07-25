package 数组_字符串.Problem_13_罗马数字转整数;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

//    "MCDLXXVI"
        String s = new String("MCDLXXVI");

        Solution solution = new Solution();
        int result = solution.romanToInt(s);

        System.out.println("result = " + result);
    }

    static class Solution {

// 字符          数值
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000

// IV            4
// IX            9
// XL            40
// XC            90
// CD            400
// CM            900


        /**
         * s = "MCMXCIV"
         * M // 1000
         * C // 100
         * M // 1000
         * => 1000 - 100 = 900
         * <p>
         * X // 10
         * C // 100
         * => 100 - 10 = 90
         * <p>
         * I // 1
         * V // 5
         * => 5 - 1 = 4
         * <p>
         * ===>
         * 1000 + 900 + 90 + 4 = 1994
         **/

        public int romanToInt(String s) {

            HashMap<String, Integer> romanToInteger = new HashMap<>();
            romanToInteger.put("I", Integer.valueOf(1));
            romanToInteger.put("V", Integer.valueOf(5));
            romanToInteger.put("X", Integer.valueOf(10));
            romanToInteger.put("L", Integer.valueOf(50));
            romanToInteger.put("C", Integer.valueOf(100));
            romanToInteger.put("D", Integer.valueOf(500));
            romanToInteger.put("M", Integer.valueOf(1000));

            romanToInteger.put("IV", Integer.valueOf(4));
            romanToInteger.put("IX", Integer.valueOf(9));
            romanToInteger.put("XL", Integer.valueOf(40));
            romanToInteger.put("XC", Integer.valueOf(90));
            romanToInteger.put("CD", Integer.valueOf(400));
            romanToInteger.put("CM", Integer.valueOf(900));

            int length = s.length();
            int result = 0;

            for (int i = 0; i < length; i++) {
                if (i + 1 < length) {
                    String doubleRomanNumStr = s.substring(i, i + 2);

                    if (romanToInteger.containsKey(doubleRomanNumStr)) {
                        Integer doubleRomanAmount = romanToInteger.get(doubleRomanNumStr);
                        result = result + doubleRomanAmount;
                        i++;
                        continue;
                    }
                }

                String singleRomanNumStr = s.substring(i, i + 1);
                Integer singleRomanAmount = romanToInteger.get(singleRomanNumStr);
                result = result + singleRomanAmount;
            }

            return result;
        }
    }


}