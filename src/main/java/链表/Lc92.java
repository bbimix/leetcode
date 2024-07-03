package 链表;

/**
 * 反转链表II
 */

public class Lc92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }

        int l = 1, r = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iterl = head;
        ListNode iterr = head;
        ListNode before = dummy;
        while (l != left) {
            before = before.next;
            iterl = iterl.next;
            l++;
        }
        while (r != right) {
            iterr = iterr.next;
            r++;
        }

        ListNode after = iterr.next;

        ListNode pre = iterl, cur = iterl.next, next = cur.next;

        while (cur != after) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }

        iterl.next = after;
        before.next = iterr;

        return dummy.next;

    }
}
