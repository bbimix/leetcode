package 滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 */

public class Lc30 {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<Character, List<String>> dict = new HashMap<>();
        List<String> used = new ArrayList<>();

        int n = s.length();

        char[] ss = s.toCharArray();

        for (String curs : words) {
            List<String> list = dict.getOrDefault(curs.charAt(0), new ArrayList<>());
            list.add(curs);
            dict.put(curs.charAt(0), list);
        }

        for (int i = 0; i < n; i++) {

            char curc = ss[i];
            if (!dict.containsKey(curc)) {
                continue;
            }

            List<String> curl = dict.get(curc);

        }
        return null;
    }

    private boolean haveSub(String s, HashMap<Character, List<String>> dict) {
        if (!dict.containsKey(s.charAt(0)) && dict.isEmpty()) {
            return true;
        }

    return false;
    }
}
