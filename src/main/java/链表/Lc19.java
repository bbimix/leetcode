package 链表;

public class Lc19 {
    /**
     * 纯自己做出来的
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;

        ListNode fast = head, slow = head, ptr = head;

        int i = n;
        while (i != 0) {
            i--;
            fast = fast.next;
            if (fast == null) {
                head = head.next;
                return head;
            }
        }

        fast = fast.next;
        slow = slow.next;

        if (fast == null) {
            ptr.next = slow.next;
            return head;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            ptr = ptr.next;
        }

        ptr.next = slow.next;
        return head;
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

        ListNode src = removeNthFromEnd(head, 5);
        while (src != null) {
            System.out.println(src.val);
            src = src.next;
        }
    }


}
