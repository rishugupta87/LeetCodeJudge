package ArraysAndString.Q_13_02_LongestValidParenthesis;

import java.util.Stack;

/**
 Given a string containing just the characters '(' and ')', find the length of the
 longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParenthesis {

    /**
     Since any valid parentheses sequence starts from a '(' and ends at ')', we can calculate new length when we meet a ')'.
     The key is to use a stack to store all the indices and the start position is always the one on top of the stack. See the code below for details.
     *
     *
     * ()(()
     *
     * @param s
     * @return
     */
    public static  int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>(); //positions of '('
        int maxLen = 0; //longest valid parentheses

        for (int i = 0; i < s.length(); ++i) { // for every character in s
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else { //it's ')'
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop(); //encountered a valid '()'

                    int lastPos = -1;
                    if (!stack.empty())
                        lastPos = stack.peek();

                    int curLen = i - lastPos;

                    maxLen = Math.max(maxLen, curLen);
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(LongestValidParenthesis.longestValidParentheses(s));
    }
}
