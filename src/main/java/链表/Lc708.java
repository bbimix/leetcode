package 链表;

/**
 * 循环有序链表的插入 VIP题
 *
 * 思路 记录开始节点 转一圈找最接近insertval的节点
 * 也就是小于insertval但是最大的节点
 */

public class Lc708 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node hd = new Node(insertVal);
            hd.next = hd;
            return hd;
        }

        Node pre = head, iter = head;
        int min = head.val;

        // 先找到最小的
        while (iter.next != head) {
            iter = iter.next;
            int premin = min;
            min = Math.max(min, iter.val);
            if (min != premin) {
                pre = iter;
            }
        }

        if (insertVal < pre.val) {
            Node prepre = head;
            while (prepre.next != pre) {
                prepre = prepre.next;
            }
            Node newNode = new Node(insertVal);
            newNode.next = prepre.next;
            prepre.next = newNode;
            return head;
        }

        Node start = pre;

        while (pre.next.val < insertVal && pre.next != start) {
            pre = pre.next;
        }
        Node newNode = new Node(insertVal);
        newNode.next = pre.next;
        pre.next = newNode;
        return head;

    }

}
