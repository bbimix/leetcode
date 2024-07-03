package 贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 划分字母区间
 */
public class Lc763 {

    public static List<Integer> partitionLabels(String s) {

        int end = -1;
        int start = -1;
        int length = s.length();
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {

            if (map.containsKey(i)) {
                end = Math.max(end, map.get(i));
                if (i == end) {
                    res.add(end - start);
                    start = end;
                }
                continue;
            }

            for (int j = length - 1; j >=0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    end = Math.max(end, j);
                    map.put(s.charAt(i), j);
                }
            }

            if (i == end) {
                res.add(end - start);
                start = end;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "caedbdedda";
        List<Integer> res = partitionLabels(s);
        System.out.println(res);

    }

}
