package 链表;


import java.util.HashMap;

/**
 * 题目叫随机链表的复制
 */
public class Lc138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node cur = head;

        while (cur != null) {
            nodeMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node curr = nodeMap.get(cur);
            curr.next = cur.next;
            curr.random = cur.random;

        }

        return nodeMap.get(head);

    }

}
