package 栈;

import java.util.Stack;

/**
 * 有效的括号
 */

public class Lc20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        char[] cc = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cc[i] == '(' || cc[i] == '{' || cc[i] == '[') {
                stack.push(cc[i]);
            } else {
                if (stack.isEmpty())
                    return false;

                char c = stack.pop();
                if (cc[i] == ')' && c == '(' || cc[i] == ']' && c == '[' || cc[i] == '}' && c == '{') {
                    continue;
                }
                return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
