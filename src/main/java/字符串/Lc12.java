package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数转换为罗马数字
 *
 * 想法 按照千 百 十 个 依次转换
 *
 * 第一个版本 史山代码
 */

public class Lc12 {

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            String s = symbols[i];

            while (num >= v) {
                sb.append(s);
                num -= v;
            }
        }

        return sb.toString();
    }

}
