package 递归回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 需要再记忆
 * 拆分回文字符串
 * 自己做出来6成左右
 * 目前答案来自gpt
 */

public class Lc131 {

    public static List<List<String>> partition(String s) {

        int length = s.length();
        List<List<String>> res = new ArrayList<>();
        backTrack(s, 0, length, new ArrayList<>(), res);
        return res;
    }

    private static void backTrack(String s, int start, int length, List<String> path, List<List<String>> res) {
        if (start == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < length; i++) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                backTrack(s, i + 1, length, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++; right--;
        }
        return true;
    }

    /**
     * 为了不重复计算是否是回文
     * 可以预处理一个数组
     * 在O(1)的时间复杂度直接获取是不是回文
     */


    public static void main(String[] args) {
        String s = "aaab";
        Lc131 lc131 = new Lc131();
        List<List<String>> res = lc131.partition(s);
        System.out.println(res);
    }
}
