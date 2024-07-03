package 递归回溯;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号可能性
 * 自己做出来了
 * 但是对于递归何时去掉新加的括号
 * 不是很确定
 */

public class Lc22 {

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        char[] product = new char[2 * n];
        product[0] = '(';
        generateParenthesis(n, res, 1, 0, product);
        return res;

    }

    private static void generateParenthesis(int n, List<String> res, int left, int right, char[] product) {

        if (left < n) {
            product[left + right] = '(';
            generateParenthesis(n, res, left + 1, right, product);

        }
        if (right < n && left > right) {
            product[left + right] = ')';
            generateParenthesis(n, res, left, right + 1, product);
        }
        if (left == n && right == n) {
            res.add(String.valueOf(product));
        }
    }

    public static void main(String[] args) {
        List<String> res =  generateParenthesis(7);
        System.out.println(res.size());
    }

}
