package 链表;

import 链表.ListNode;

public class Lc142 {
    /**
     * 公式能算出来
     * 快慢指针相遇的时候
     * 慢指针离入口的距离和头一个样
     * 看题解做出来的
     */

    public static ListNode getGateNode(ListNode head) {

        if (head == null)
            return null;

        ListNode slow = head, fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = third;

        System.out.println(getGateNode(head).val);
    }

}
