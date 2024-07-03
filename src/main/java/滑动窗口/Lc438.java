package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * 思路：把目标放在set里
 * 使用滑动窗口找字母是否在set中
 * 当长度是3 记录left
 */

public class Lc438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        int[] pp = new int[26];
        int[] ss = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pp[p.charAt(i) - 'a']++;
            ss[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(ss, pp)) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {

            ss[s.charAt(i) - 'a']--;
            ss[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(ss,pp)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
