package 栈;

import java.util.*;

/**
 * 柱状图
 */

public class Lc84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ll = new int[n];
        int[] rr = new int[n];
        Arrays.fill(rr, n);
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                rr[stack.pop()] = i;
            }
            ll[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, (rr[i] - ll[i] - 1) * heights[i]);
        }
        return res;
    }

    public int largestRectangleAreaCom(int[] heights) {
        int n = heights.length;
        int[] ll = new int[n];
        int[] rr = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            ll[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (rr[i] - ll[i] - 1) * heights[i]);
        }
        return res;
    }

    /**
     * 暴力解法
     */
    public int largestRectangleAreaForce(int[] heights) {
        int n = heights.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int minh = heights[i];
            res = Math.max(res, heights[i]);
            for (int j = i + 1; j < n; j++) {
                if (heights[j] < minh)
                    minh = heights[j];
                res = Math.max(res, (j - i + 1) * minh);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc84 lc84 = new Lc84();
        int[] heights = {2,1,5,6,2,3};
        int res = lc84.largestRectangleArea(heights);
        System.out.println(res);
    }
}
