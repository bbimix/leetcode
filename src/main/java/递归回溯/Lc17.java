package 递归回溯;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 手机号对应的字符串
 * 纯自己做
 * 一遍通过
 */

public class Lc17 {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0)
            return res;

        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        List<String> strings = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            strings.add(map.get(Integer.parseInt(digits.substring(i, i + 1))));
        }
        StringBuffer sb = new StringBuffer();
        backTrack(res,  strings, 0, sb);
        return res;
    }

    private static void backTrack(List<String> res, List<String> strings, int num, StringBuffer sb) {
        if (sb.length() == strings.size()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < strings.get(num).length(); i++) {
            sb.append(strings.get(num).charAt(i));
            backTrack(res, strings, num + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String d = "23";
        List<String> res = letterCombinations(d);
        System.out.println(res);
    }

}
