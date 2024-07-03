package 栈;

import java.util.Stack;

/**
 * 每日温度
 * 想对了一小半吧 15/48
 */

public class Lc739 {

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int exc = 0;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int p = stack.pop();
                res[p] = i - p;
            }
            stack.push(i);
        }

        res[n - 1] = 0;
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        int[] res = dailyTemperatures(temperatures);
        for (int i : res) {
            System.out.println(i);
        }
    }

}
