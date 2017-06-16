package ArraysAndString.Q_13_01_ValidParenthesis;

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParenthesis {

    /**
     * Can be easily done using just one stack. No need to store pair of parenthesis in a hashMap.
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.equals("")) return true;

        for(char ch : s.toCharArray()) {
            if(ch=='('|| ch=='[' || ch=='{'){
                stack.push(ch);
            } else if(ch==')'){
                if(stack.empty() || stack.pop()!='(')
                    return false;
            } else if(ch==']'){
                if(stack.empty() || stack.pop()!='[')
                    return false;
            } else if(ch=='}'){
                if(stack.empty() || stack.pop()!='{')
                    return false;
            }
        }
        return stack.empty();
    }
}
