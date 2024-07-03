package 双指针.最小覆盖子串;

import java.util.Collection;
import java.util.HashMap;

/**
 * @projectName: leetcode
 * @package: 双指针.最小覆盖子串
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/20 22:27
 */
public class Solution {

    private static boolean areAllValuesZero(HashMap<Character, Integer> hashMap) {
        for (Integer value : hashMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean areAllValuesbig(HashMap<Character, Integer> hashMap) {
        for (Integer value : hashMap.values()) {
            if (value > 0) {
                return true;
            }
        }
        return false;
    }

    public String minWindow (String S, String T) {
        String res = new String();

        int i = 0, j = 0;

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int k = 0; k < T.length(); k++) {
            mp.put(T.charAt(k), -1);
        }

        while (j < S.length()) {
            if (mp.containsKey(S.charAt(j))) {
                mp.put(S.charAt(j), mp.get(S.charAt(j)) + 1);
                if (areAllValuesZero(mp)) {
                    if (res.length() == 0) {
                        res = S.substring(i, j + 1);
                    }
                    res = res.length() < (j - i + 1) ? res : S.substring(i, j + 1);
                } else {
                    while (areAllValuesbig(mp)) {
                        if (mp.containsKey(S.charAt(i))) {
                            mp.put(S.charAt(i), mp.get(S.charAt(i)) - 1);
                        }
                        i++;
                    }
                }
            }
            j++;
        }
    return res;
    }

    boolean check(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] < 0) {
                return false;
            }
        }
        return true;
    };

    public String minWindow2 (String S, String T) {
        int cnt = S.length() + 1;
        //记录目标字符串T的字符个数
        int[] hash = new int[128];
        for(int i = 0; i < T.length(); i++)
            //初始化哈希表都为负数，找的时候再加为正
        {
            hash[T.charAt(i)] -= 1;
        }
        int slow = 0, fast = 0;
        //记录左右区间
        int left = -1, right = -1;
        for(; fast < S.length(); fast++){
            char c = S.charAt(fast);
            //目标字符匹配+1
            hash[c]++;
            //没有小于0的说明都覆盖了，缩小窗口
            while(check(hash)){
                //取最优解
                if(cnt > fast - slow + 1){
                    cnt = fast - slow + 1;
                    left = slow;
                    right = fast;
                }
                c = S.charAt(slow);
                //缩小窗口的时候减1
                hash[c]--;
                //窗口缩小
                slow++;
            }
        }
        //找不到的情况
        if(left == -1) {
            return "";
        }
        return S.substring(left, right + 1);
    }
}
