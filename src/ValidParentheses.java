import java.util.Stack;

public class ValidParentheses {

    // Valid Parentheses
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    public static boolean isValid(String s) {
        boolean res = false;
        // check if string parameter (s) has valid characters
        if ( (s.contains("()") || s.contains("[]") || s.contains("{}")) && s.length() % 2 == 0 ) {
            // Declare and initialize stack
            Stack<String> stk = new Stack<>();
            // split the string parameter s
            String[] str = s.split("");

            // loop through split string and push elements into the stack
            // if closing parenthesis( ')', ']', '}' ) is found pop the stack
            for(int i = 0; i < str.length; i++) {
                if ( (str[i].equals(")") || str[i].equals("]") || str[i].equals("}")) && !stk.isEmpty()) {
                    // test to see if the top of the stack is the same type of parenthesis
                    boolean flag = false;
                    switch(str[i]) {
                        case ")": flag = stk.peek().equals("("); break;
                        case "]": flag = stk.peek().equals("["); break;
                        case "}": flag = stk.peek().equals("{"); break;

                    }
                    if (flag) {
                        stk.pop();
                    }
                    // continue to avoid pushing the closing parenthesis into the stack
                    continue;
                }
                stk.push(str[i]);
            }
            // if stack is empty set the result to true
            if(stk.isEmpty()) {
                res = true;
            }
        }
        return res;
    }
}
