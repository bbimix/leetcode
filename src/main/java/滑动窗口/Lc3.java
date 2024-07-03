package 滑动窗口;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;

/**
 * 最长无重复子串
 */
public class Lc3 {
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        if (n < 2)
            return n;

        int l = 0, r = 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int maxres = 0;

        while (l <= r && r < n) {
            while (r < n && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                res++;
            }
            maxres = Math.max(maxres, res);
            while (r < n && set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
                res--;
            }
        }
        return maxres;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaababc"));
    }

}
