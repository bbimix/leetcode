package 链表;

import java.util.ArrayList;
import java.util.List;

public class Lc2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, temp = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (head == null) {
                head = temp = new ListNode(sum);
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            temp.next = new ListNode(1);
        }
        return head;
    }
}
