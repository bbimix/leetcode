package 字符串.大数加法;

/**
 * @projectName: leetcode
 * @package: 字符串.大数加法
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/18 21:58
 */
public class Solution {
    public String solve(String s, String t) {
        if (s.length() <= 0) {
            return t;
        }
        if (t.length() <= 0) {
            return s;
        }

        String longer = (s.length() > t.length() ? s : t);
        String shorter = (s.length() < t.length() ? s : t);

        int carry = 0;
        char[] res = new char[s.length()];
        for (int i = longer.length() - 1; i >= 0; i--) {
            int temp = longer.charAt(i) - '0' + carry;
            int j = i - longer.length() + t.length();
            if (j >= 0) {
                temp += t.charAt(j) - '0';
            }

            carry = temp / 10;
            temp = temp % 10;
            res[i] = (char) (temp + '0');
        }
        String result = String.valueOf(res);
        if (carry == 1) {
            result = '1' + result;
        }
        return result;

    }
}
