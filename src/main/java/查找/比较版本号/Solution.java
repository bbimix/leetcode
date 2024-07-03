package 查找.比较版本号;

import java.util.Locale;

public class Solution {

    /**
     * 通过分割字符串实现
     */
    public int compare (String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        for (int i = 0; i < s1.length || i < s2.length; i++) {
            int num1 = 0, num2 = 0;
            if (i < s1.length)
                num1 = Integer.parseInt(s1[i]);

            if (i < s2.length)
                num2 = Integer.parseInt(s2[i]);

            if (num1 > num2)
                return 1;
            if (num2 > num1)
                return -1;
        }
        return 0;
    }

    /**
     * 双指针
     */
    public int compare2 (String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();

        int i = 0, j = 0;

        while (i < len1 || j < len2) {

            int num1 = 0;
            for ( ; i < len1 && version1.charAt(i) != '.'; i++) {
                num1 = num1 * 10 + version1.charAt(i) - '0';
            }
            i++;

            int num2 = 0;
            for ( ; j < len2 && version2.charAt(i) != '.'; i++) {
                num2 = num2 * 10 + version2.charAt(i) - '0';
            }
            j++;

            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;
        }
        return 0;
    }
}
