package 栈;

/**
 * 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */

public class Lc155 {

    int[] stack;
    int[] minStack;
    int top = -1;
    int mtop = -1;
    long min = Long.MIN_VALUE;

    public Lc155() {
        stack = new int[30000];
        minStack = new int[30000];
        minStack[++mtop] = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack[++top] = val;
        minStack[++mtop] = Math.min(minStack[mtop - 1], val);
    }

    public void pop() {
        top--;
        mtop--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[mtop];
    }

}
