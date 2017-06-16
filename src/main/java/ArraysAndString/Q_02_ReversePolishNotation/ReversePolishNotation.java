package ArraysAndString.Q_02_ReversePolishNotation;

import java.util.Stack;

/**
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {

    /**
     * Can easily do this using a stack.
     * add every token as an integer in the stack, unless it's an operation. In that case, I pop two elements from the stack and
     * then save the result back to it. After all operations are done through, the remaining element in the stack will be the result.
     *
     * @param strs
     * @return
     */
    public static int reversePolishNotation(String[] tokens) {

        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.push(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.push(a / b);
            }
            else if(s.equals("*")) {
                S.push(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.push(a - b);
            }
            else {
                S.push(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};

        System.out.println(reversePolishNotation(tokens1));
        System.out.println(reversePolishNotation(tokens2));
    }
}
