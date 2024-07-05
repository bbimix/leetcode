package 双指针;

import javax.xml.stream.events.Characters;

/**
 * 判断回文
 *
 * 这里注意 StringBuffer底层是使用char[] 所以尽量不要使用删除操作
 */

public class Lc125 {
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String ns = sb.toString();
        char[] cns = ns.toCharArray();
        int n = ns.length();

        int l = 0, r = n - 1;

        while (l <= r) {
            if (cns[l] == cns[r]) {
                l++;r--;
            }
            else break;
        }

        if (l > r)
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "......a.....";
        isPalindrome(s);
    }
}
