package 二叉树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 填充每个节点的下一个右侧节点指针 II
 *
 * 一下想到的思路 先序 + 队列
 */

public class Lc117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {

        if (root == null)
            return null;

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            if (size > 1) {
                Node first = queue.poll();
                for (int i = 1; i < size; i++) {
                    Node next = queue.poll();
                    first.next = next;
                    if (first.left != null) {
                        queue.offer(first.left);
                    }
                    if (first.right != null) {
                        queue.offer(first.right);
                    }
                    first = next;
                }
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
            } else {
                Node first = queue.poll();
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
            }

        }
        return root;
    }

}
