package 双指针;

/**
 * 判断子序列
 */

public class Lc392 {

    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        int sn = ss.length;
        int tn = tt.length;

        int i = 0, j = 0;

        while (i < sn && j < tn) {
            if (ss[i] == tt[j])
                i++;
            j++;
        }
        if (i == sn)
            return true;
        return false;

    }

}
