package 栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 简化路径
 */

public class Lc71 {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 1; i < ss.length; i++) {
            if (ss[i].equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                    continue;
                }
            }

            if (ss[i].equals(".") || ss[i].equals("")) {
                continue;
            }
            stack.push(ss[i]);
        }

        StringBuffer sb = new StringBuffer();

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc71 lc71 = new Lc71();
        String path = "/home/user/Documents/../Pictures";
        String res = lc71.simplifyPath(path);
        System.out.println(res);
    }
}
