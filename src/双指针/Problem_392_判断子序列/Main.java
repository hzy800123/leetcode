package 双指针.Problem_392_判断子序列;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：s = "abc", t = "ahbgdc"
        // 输出：true
//        String s = new String("abc");
//        String t = new String("ahbgdc");

        // 输入：s = "axc", t = "ahbgdc"
        // 输出：false
        String s = new String("axc");
        String t = new String("ahbgdc");

        Solution solution = new Solution();
        boolean result = solution.isSubsequence(s, t);
        System.out.println("result = " + result);

    }

    static class Solution {

        public boolean isSubsequence(String s, String t) {

            // 获取 2个字符串的长度
            int sLength = s.length();
            int tLength = t.length();
            char sChar = ' ';
            boolean findSameChar = false;
            int sPostion = 0;

            // 先遍历 s字符串的每一个字符
            for (int i = 0; i < sLength; i++) {
                sChar = s.charAt(i);
                findSameChar = false;

                // 再遍历 t字符串的每一个字符
                // 每次从上一次找到相同字符的位置,继续向后查找
                for (int j = sPostion; j < tLength; j++) {
                    if (sChar == t.charAt(j)) {
                        findSameChar = true;
                        // 记录找到相同在字符的位置+1
                        sPostion = j + 1;
                        break;
                    } else {
                        continue;
                    }
                }

                // 如果遍历全部 t字符串之后,都没有找到相同的字符,立即返回false
                if (!findSameChar) {
                    return false;
                }
            }

            return true;
        }

    }

}