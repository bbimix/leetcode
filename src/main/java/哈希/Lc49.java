package 哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 字母异位词分组
 */

public class Lc49 {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < 26; j++) {
                if (count[j] != 0) {
                    sb.append('a' + j);
                    sb.append(count[j]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            map.put(sb.toString(), list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
}
