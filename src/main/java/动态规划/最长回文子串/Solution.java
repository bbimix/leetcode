package 动态规划.最长回文子串;

/**
 * @projectName: leetcode
 * @package: 动态规划.最长回文子串
 * @className: solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/4 19:05
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param A string字符串
     * @return int整型
     */
    public void manacher(String s, int n, int[] mp) {
        String ms = "";
        ms += "$#";
        //预处理使之都变成奇数回文子串
        for (int i = 0; i < n; i++) {
            ms += s.charAt(i);
            ms += '#';
        }

        //目前已知的最长回文子串的最右一位的后一位
        int maxpos = 0;

        //当前的最长回文子串的中心点
        int index = 0;
        for (int i = 0; i < ms.length(); i++) {
            mp[i] = maxpos > i ? Math.min(mp[2 * index - i], maxpos - i) : 1;
            while (i - mp[i] > 0 && i + mp[i] < ms.length() &&
                    ms.charAt(i + mp[i]) == ms.charAt(i - mp[i]))
                //两边扫
                mp[i]++;
            //更新位置
            if (i + mp[i] > maxpos) {
                maxpos = i + mp[i];
                index = i;
            }
        }
    }

    public int getLongestPalindrome (String A) {
        // write code here
        int n = A.length();
        //记录回文子串长度
        int[] mp = new int[2 * n + 2];
        manacher(A, n, mp);
        int maxlen = 0;
        //遍历数组
        for (int i = 0; i < 2 * n + 2; i++)
            //找到最大的长度
            maxlen = Math.max(maxlen, mp[i] - 1);
        return maxlen;
    }

    public static void main(String[] args) {
        String A = "ababc";
        Solution solution = new Solution();
        int a = solution.getLongestPalindrome(A);
    }
}
