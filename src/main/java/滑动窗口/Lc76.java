package 滑动窗口;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最小覆盖子串
 * 思路：不满足 right往右
 * 满足 left往左 直到不满足
 * 维护min
 */
public class Lc76 {

    public static String minWindow(String s, String t) {

        String res = "";
        int sl = s.length();
        int tl = t.length();
        if (sl < tl)
            return res;

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> cmap = new HashMap<>();

        int fl = 0, fr = 0;
        int minlen = Integer.MAX_VALUE;
        int l = 0, r = 0;

        for (int i = 0; i < tl; i++) {
            int num = map.getOrDefault(t.charAt(i), 0);
            map.put(t.charAt(i), num + 1);
            cmap.put(t.charAt(i), num + 1);
        }

        while (r < sl) {

            while (r < sl && !check(cmap)) {
                if (cmap.containsKey(s.charAt(r))) {
                    int num = cmap.get(s.charAt(r));
                    cmap.put(s.charAt(r), num - 1);
                }
                r++;
            }

            while (l < r && check(cmap)) {
                if (cmap.containsKey(s.charAt(l))) {
                    int num = cmap.get(s.charAt(l));
                    cmap.put(s.charAt(l), num + 1);
                }
                int pre = minlen;
                minlen = Math.min(minlen, r - l + 1);
                if (pre != minlen) {
                    fl = l;
                    fr = r;
                }
                l++;
            }

        }
        return s.substring(fl, fr);
    }

    private static boolean check(HashMap<Character, Integer> cmap) {
        List<Integer> list = new ArrayList<>(cmap.values());
        for (Integer i : list) {
            if (i > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
