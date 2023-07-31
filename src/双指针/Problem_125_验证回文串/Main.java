package 双指针.Problem_125_验证回文串;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // For example, the ASCII value of 'a' is 97 and 'A' is 65.
        // So, a – A = 32.
        // 输入: s = "A man, a plan, a canal: Panama"
        // 输出：true
        String s = new String("A man, a plan, a canal: Panama");

        // 输入：s = "race a car"
        // 输出：false
//        String s = new String("race a car");

        // 输入：s = " "
        // 输出：true
//        String s = new String(" ");

        Solution solution = new Solution();
        boolean result1 = solution.isPalindrome1(s);
        System.out.println("result1 = " + result1);

        System.out.println(" --- ");

        boolean result2 = solution.isPalindrome2(s);
        System.out.println("result2 = " + result2);
    }

    static class Solution {

        public boolean isPalindrome1(String s) {
            int length = s.length();
            char a = ' ';
            char[] charArray = new char[length];
            char tempChar = ' ';
            int newLength = 0;

            for (int i = 0; i < length; i++) {
                a = s.charAt(i);

                if (a >= 'A' && a <= 'Z') {
                    tempChar = Character.toLowerCase(a);
                    charArray[newLength] = tempChar;
                    newLength++;
                }

                if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9') {
                    charArray[newLength] = a;
                    newLength++;
                }
            }

            int l = 0;
            int r = newLength - 1;

            while (l <= r) {
                if (charArray[l] != charArray[r]) {
                    return false;
                } else {
                    l++;
                    r--;
                    continue;
                }
            }

            return true;
        }

        public boolean isPalindrome2(String s) {

            int length = s.length();
            char a = ' ';
            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < length; i++) {
                a = s.charAt(i);
                if (a >= 'A' && a <= 'Z') {
                    stringBuffer.append((char)(a + 32));
//                    stringBuffer.append(Character.toLowerCase(a));
                }

                if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9') {
                    stringBuffer.append(a);
                }
            }

            System.out.println("stringBuffer : " + stringBuffer);

            String str1 = new String(stringBuffer);
            String str2 = new String(stringBuffer.reverse());

            System.out.println("str1 : " + str1);
            System.out.println("str2 : " + str2);

            return str1.equals(str2);
        }

    }

}