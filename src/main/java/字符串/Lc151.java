package 字符串;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 反转字符串中的单词
 */

public class Lc151 {
    public String reverseWords(String s) {

        StringBuffer sb = new StringBuffer();
        Deque<String> stack = new ArrayDeque<>();

        int n = s.length();
        char[] cc = s.toCharArray();
        int l = 0, r = n - 1;

        while (cc[l] == ' ') {
            l++;
        }

        while (cc[r] == ' ') {
            r--;
        }

        while (l <= r) {
            if (sb.length() != 0 && cc[l] == ' ') {
                stack.push(new String(sb));
                sb.setLength(0);
            } else if (cc[l] != ' ') {
                sb.append(cc[l]);
            }
            l++;
        }

        if (sb.length() != 0) {
            stack.push(new String(sb));
        }

        return String.join(" ", stack);

    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        Lc151 lc151 = new Lc151();
        String res = lc151.reverseWords(s);
        System.out.println(res);
    }
}
