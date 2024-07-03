package 链表;

/**
 * 旋转链表
 */

public class Lc61 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;

        if (k == 0)
            return head;

        int n = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = head;
        ListNode tail = dummy;

        while(iter != null) {
            tail = tail.next;
            iter = iter.next;
            n++;
        }

        k = k % n;

        if (k == 0)
            return head;

        ListNode p = dummy, c = head;
        int n2 = n;

        while (n2 > k) {
            c = c.next;
            p = p.next;
            n2--;
        }

        p.next = tail.next;
        tail.next = dummy.next;
        dummy.next = c;

        return dummy.next;

    }
}
