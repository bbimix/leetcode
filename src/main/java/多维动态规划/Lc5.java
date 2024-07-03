package 多维动态规划;

/**
 * 最长回文子串
 *
 * 突然想到类似于括号匹配 动态规划题
 */

public class Lc5 {
    public String longestPalindrome(String s) {

        int n = s.length();
        char[] cc = s.toCharArray();

        if (s == null || n < 2)
            return s;

        int start = 0, end = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {

            int len1 = getlong(cc, i, i);
            int len2 = getlong(cc, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getlong(char[] cc, int i, int j) {

        while (i >= 0 && j < cc.length && cc[i] == cc[j]) {
            i--;
            j++;
        }
        return j - i - 1;

    }

    public static void main(String[] args) {
        String s = "bananananad";
        Lc5 lc5 = new Lc5();
        String res = lc5.longestPalindrome(s);
        System.out.println(res);

    }
}
