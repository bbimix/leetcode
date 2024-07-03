package 链表;

/**
 * k个一组反转链表
 *
 * 直接A不动 需要再刷
 */

public class Lc25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        dummy.next = head;

        ListNode start = head, end = dummy;

        while (end != null) {
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null)
                    return dummy.next;
            }

            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start, end);
            pre = start;
            start.next = next;
            end = pre;
            start = next;
        }

        return dummy.next;

    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = cur;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
