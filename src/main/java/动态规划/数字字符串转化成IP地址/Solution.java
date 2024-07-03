package 动态规划.数字字符串转化成IP地址;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: 动态规划.数字字符串转化成IP地址
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/4 19:11
 * 三种情况，自己一位，结合前一位，或者结合前两位。
 */
public class Solution {

    public ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        int leng = s.length();

        if (leng < 4) {
            return list;
        }

        for (int i = 0; i < 4 && i < leng - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < leng - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < leng; k++) {
                    if (leng - k >= 4) {
                        continue;
                    }

                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k);

                    if (Integer.parseInt(a) > 255 || Integer.parseInt(b) > 255 || Integer.parseInt(c) > 255 || Integer.parseInt(d) > 255) {
                        continue;
                    }

                    if ((a.length() != 1 && a.charAt(0) == '0') || (b.length() != 1 && b.charAt(0) == '0') || (c.length() != 1 && c.charAt(0) == '0') || (d.length() != 1 && d.charAt(0) == '0')) {
                        continue;
                    }

                    String temp = a + "." + b + "." + c + "." + d;
                    list.add(temp);
                }
            }
        }
        return list;
    }

    private String nums = "";

    public void dfs(String s, ArrayList<String> res, int step, int index) {
        String cur = "";
        if (step == 4 && index != s.length()) {
            return;
        } else if (step == 4) {
            res.add(nums);
        } else {
            for (int i = index; i < index + 3 && i < s.length(); i++) {
                cur += s.charAt(i);
                int num = Integer.parseInt(cur);
                String temp = nums;
                if (num <= 255 && (cur.length() == 1 || cur.charAt(0) != '0')) {
                    if (step - 3 != 0) {
                        nums += cur + '.';
                    } else {
                        nums += cur;
                    }

                    dfs(s, res, step + 1, i + 1);
                    nums = temp;
                }
            }
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "0000";
        ArrayList<String> alist = solution.restoreIpAddresses(s);
    }
}
