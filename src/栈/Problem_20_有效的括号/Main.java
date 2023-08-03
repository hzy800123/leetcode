package 栈.Problem_20_有效的括号;

import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        System.out.println("");

        // 输入：s = "()"
        // 输出：true
//        String s = new String("()");

        // 输入：s = "()[]{}"
        // 输出：true
//        String s = new String("()[]{}");

        // 输入：s = "(]"
        // 输出：false
//        String s = new String("(]");

        // 输入：s = "{[]}"
        // 输出：true
        String s = new String("{[]}");

        Solution solution = new Solution();
        boolean result = solution.isValid(s);

        System.out.println("result = " + result);
    }

    static class Solution {

        public boolean isValid(String s) {

            // '('，')'，'{'，'}'，'['，']'
            HashMap<Character, Character> hashMap = new HashMap();
            hashMap.put(')', '(');
            hashMap.put('}', '{');
            hashMap.put(']', '[');

            Stack<Character> stack = new Stack<>();

            int sLength = s.length();
            char tempChar = ' ';

            for (int i = 0; i < sLength; i++) {
                tempChar = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(tempChar);
                } else {
                    // 如果 遇到不是右括号,而是左括号,需要入栈
                    if (!hashMap.containsKey(tempChar)) {
                        stack.push(tempChar);
                    } else {
                        // 如果 遇到是右括号,需要比较
                        if (hashMap.get(tempChar) == stack.peek()) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }

            // 如果 栈为空,返回true
            if (stack.isEmpty()) {
                return true;
            }

            return false;
        }
    }


}