package 数组_字符串.Problem_14_最长公共前缀;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：strs = ["flower","flow","flight"]
        // 输出："fl"
//        String[] strs = new String[]{"flower","flow","flight"};

        // 输入：strs = ["dog","racecar","car"]
        // 输出：""
//        String[] strs = new String[]{"dog","racecar","car"};

        // 输入：strs = ["dog","racecar","car"]
        // 输出：""
//        String[] strs = new String[]{"a"};

        // 输入：strs = ["ab", "a"]
        // 输出："a"
        String[] strs = new String[]{"ab", "a"};

        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strs);

        System.out.println("result = " + result);
    }

    static class Solution {

        public String longestCommonPrefix(String[] strs) {
            int length = strs.length;
            int minLenth = Integer.MAX_VALUE;
            int[] strLengths = new int[strs.length];
            int currLenth = 0;
            // 定义 当前最长的相同字符串前缀的长度
            int maxSameCount = 0;
            boolean sameChar = true;

            if (length == 1) {
                return strs[0];
            }

            // 先获取 最短的字符串的长度 minLength
            for (int i = 0; i < length; i++) {
                currLenth = strs[i].length();
                strLengths[i] = currLenth;
                if (currLenth < minLenth) {
                    minLenth = currLenth;
                }
            }

            // 从第一个字符开始遍历,不超过最短字符串长度
            for (int j = 0; j < minLenth; j++) {

                // 遍历每一个字符串
                for (int k = 0; k < length - 1; k++) {

                    if(strs[k].charAt(j) == strs[k+1].charAt(j)) {
                        continue;
                    } else {
                        sameChar = false;
                        break;
                    }
                }

                // 如果 发现有不一样的字符,立即退出循环
                if (!sameChar) {
                    maxSameCount = j;
                    break;
                } else {
                    maxSameCount = j + 1;
                }
            }

            return strs[0].substring(0,maxSameCount);
        }
    }


}