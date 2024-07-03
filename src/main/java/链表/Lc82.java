package 链表;

/**
 * 删除排序链表中的重复元素II
 */

public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, c = head, n = head.next;
        int police = 200;

        while (n != null) {
            if (c.val == n.val || c.val == police) {
                police = c.val;
                p.next = c.next;
                c = n;
                n = c.next;
            } else {
                p = p.next;
                c = c.next;
                n = n.next;
            }
        }

        if (c.val == police)
            p.next = c.next;

        return dummy.next;
    }
}
