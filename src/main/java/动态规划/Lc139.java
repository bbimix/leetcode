package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class Lc139 {

    static int[] memo;

    public static boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length() + 1];
        return dfs(s, wordDict, 0);
    }

    private static boolean dfs(String s, List<String> wordDict, int index) {

        if (index == s.length())
            return true;

        if (memo[index] != 0)
            return false;

        boolean res = false;
        for (int i = 0; i < wordDict.size(); i++) {
            String curr = wordDict.get(i);

            boolean good = true;
            for (int j = 0; j < curr.length(); j++) {
                if (j + index >= s.length() || s.charAt(j + index) != curr.charAt(j)) {
                    good = false;
                    break;
                }
            }
            if (good) {
                res = res || dfs(s, wordDict, index + curr.length());
            }
        }
        memo[index] = -1;
        return res;

    }

    public static void main(String[] args) {

//        String s = "leetcode";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaaa");
        boolean good = wordBreak(s, wordDict);
        System.out.println(good);
    }

}
