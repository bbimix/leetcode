package 链表.链表相加二;

import 链表.ListNode;

public class Solution {

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode addInList (ListNode head1, ListNode head2) {

        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode h1 = head1;
        ListNode h2 = head2;

        int sum;
        int carry = 0;

        ListNode res = new ListNode(-1);
        ListNode p = res;

        while (h1 != null && h2 != null) {
            sum = h1.val + h2.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            else
                carry = 0;

            ListNode num = new ListNode(sum);
            p.next = num;
            p = p.next;

            h1 = h1.next;
            h2 = h2.next;
        }
        while (h1 != null) {
            sum = h1.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            else
                carry = 0;

            ListNode num = new ListNode(sum);
            p.next = num;
            p = p.next;

            h1 = h1.next;
        }

        while (h2 != null) {
            sum = h2.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            }
            else
                carry = 0;

            ListNode num = new ListNode(sum);
            p.next = num;
            p = p.next;

            h2 = h2.next;
        }

        if (carry == 1) {
            ListNode num = new ListNode(1);
            p.next = num;
            p = p.next;
        }

        return reverse(res.next);
    }
}
