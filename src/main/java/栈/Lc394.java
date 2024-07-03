package 栈;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * 字符串解码
 * 自己A出来了
 */

public class Lc394 {

    public static String decodeString(String s) {
        return decode(s, 1);
    }

    private static String decode(String s, int num) {

        char[] cc = s.toCharArray();
        int n = s.length();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            if (cc[i] >= '0' && cc[i] <= '9') {

                int numb = 0;
                while (cc[i] >= '0' && cc[i] <= '9') {
                    numb = numb * 10 + cc[i] - '0';
                    i++;
                }
                i++;  //跳过 "["
                int j = i;
                int kk = 1;
                while (kk != 0) {
                    if (cc[i] == '[')
                        kk++;
                    if (cc[i] == ']')
                        kk--;
                    i++;
                }

                String temp = decode(s.substring(j, i - 1), numb);
                sb.append(temp);
                i--;
            } else {
                sb.append(cc[i]);
            }

        }
        String stemp = sb.toString();
        while (num - 1 != 0) {
            sb.append(stemp);
            num--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]3[aa]5[ccc]";
        String res = decodeString(s);
        System.out.println(res);
    }

}
