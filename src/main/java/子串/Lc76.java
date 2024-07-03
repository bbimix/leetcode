package 子串;

import java.util.HashMap;

/**
 * 最小覆盖子串
 */

public class Lc76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ns = s.length(), nt = t.length();
        char[] ss = s.toCharArray(), tt = t.toCharArray();

        for (int i = 0; i < nt; i++) {
            map.put(tt[i], map.getOrDefault(tt[i], 0) + 1);
        }

        int l = 0, r = 0, fl = 0, fr = 0;
        int minlen = Integer.MAX_VALUE;

        while (r < ns) {

            while (r < ns && !check(map)) {
                if (map.containsKey(ss[r])) {
                    map.put(ss[r], map.get(ss[r]) - 1);
                }
                r++;
            }

            while (l < r && check(map)) {
                if (map.containsKey(ss[l])) {
                    map.put(ss[l], map.get(ss[l]) + 1);
                }

                int pre = minlen;
                minlen = Math.min(minlen, (r - l + 1));
                if (minlen != pre) {
                    fl = l;
                    fr = r;
                }
                l++;
            }

        }

        return s.substring(fl, fr);

    }

    // 判断是否都包含了
    private boolean check(HashMap<Character, Integer> map) {
        for (int i : map.values()) {
            if (i > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc76 lc76 = new Lc76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = lc76.minWindow(s, t);
        System.out.println(res);
    }
}
