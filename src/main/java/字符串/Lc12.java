package 字符串;

/**
 * 整数转换为罗马数字
 *
 * 想法 按照千 百 十 个 依次转换
 *
 * 第一个版本 史山代码
 */

public class Lc12 {

    public String intToRoman(int num) {

        StringBuffer sb = new StringBuffer();

        if (num / 1000 != 0) {
            int th = num / 1000;
            for (int i = 0; i < th; i++) {
                sb.append('M');
            }
        }

        num = num % 1000;

        if (num / 100 != 0) {
            int hd = num / 100;
            if (hd == 4 || hd == 9) {
                sb.append(hd == 4 ? "CD" : "CM");
            }

            if (hd < 5) {
                for (int i = 0; i < hd; i++) {
                    sb.append('C');
                }
            } else if (hd == 5) {
                sb.append('D');
            } else {
                sb.append('D');
                for (int i = 6; i < 9; i++) {
                    sb.append('C');
                }
            }
        }

        num = num % 100;

        if (num / 10 != 0) {
            int tn = num / 10;
            if (tn == 4 || tn == 9) {
                sb.append(tn == 4 ? "XL" : "XC");
            }

            if (tn < 5) {
                for (int i = 0; i < tn; i++) {
                    sb.append('X');
                }
            } else if (tn == 5) {
                sb.append('L');
            } else {
                sb.append('L');
                for (int i = 6; i < 9; i++) {
                    sb.append('X');
                }
            }
        }

        num = num % 10;

        if (num  != 0) {
            int on = num;
            if (on == 4 || on == 9) {
                sb.append(on == 4 ? "IV" : "IX");
            }

            if (on < 5) {
                for (int i = 0; i < on; i++) {
                    sb.append('I');
                }
            } else if (on == 5) {
                sb.append('V');
            } else {
                sb.append('X');
                for (int i = 6; i < 9; i++) {
                    sb.append('I');
                }
            }
        }
        return sb.toString();
    }

}
