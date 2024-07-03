package 栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Pattern;

/**
 * 逆波兰表达式求值
 */

public class Lc150 {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            if (isNumber(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else if (tokens[i].equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (tokens[i].equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (tokens[i].equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("-?\\d+");
        return pattern.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        Lc150 lc150 = new Lc150();
        int res = lc150.evalRPN(tokens);
        System.out.println(res);

//        String s = "+";
//        System.out.println(lc150.isNumber(s));
    }
}
