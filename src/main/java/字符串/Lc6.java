package 字符串;

/**
 * Z字形变换
 */

public class Lc6 {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        int n = s.length();

        int t = 2 * numRows - 2;
        int col = (n + t - 1) / t * (numRows - 1);
        char[][] cc = new char[numRows][col];

        for (int i = 0, x = 0, y = 0; i < n; i++) {
            cc[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (char[] row : cc) {
            for (char ch : row) {
                if (ch != 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();

    }

}
