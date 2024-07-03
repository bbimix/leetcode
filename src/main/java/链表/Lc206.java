package 链表;

/**
 * 反转链表
 */

public class Lc206 {

    public ListNode reverseList(ListNode head) {

        if (head == null)
            return null;

        ListNode l = null;
        ListNode c = head;
        ListNode n = head;

        while (c != null) {
            n = n.next;
            c.next = l;
            l = c;
            c = n;
        }

        return c;
    }
}
