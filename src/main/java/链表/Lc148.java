package 链表;

/**
 * 排序 时间复杂度nlogn
 * 使用归并排序
 */
public class Lc148 {

    public static ListNode sortList(ListNode head) {

        return sortList(head, null);

    }

    public static ListNode sortList(ListNode head, ListNode tail) {

        if (head == null)
            return head;

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head, slow = head;

        while (fast != tail) {

            fast = fast.next;
            slow = slow.next;

            if (fast != tail)
                fast = fast.next;

        }

        ListNode mid = slow;
        ListNode dummyHead = new ListNode(-1);
        ListNode head1 = sortList(head, mid);
        ListNode head2 = sortList(mid, tail);
        return merge(head1, head2);
    }

    public static ListNode merge(ListNode head1, ListNode head2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode tempHead = dummyHead;
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while(temp1 != null && temp2 != null) {

            if (temp1.val > temp2.val) {
                tempHead.next = temp2;
                temp2 = temp2.next;
            } else {
                tempHead.next = temp1;
                temp1 = temp1.next;
            }
            tempHead = tempHead.next;
        }

        if (temp1 == null) {
            tempHead.next = temp2;
        } else if (temp2 == null) {
            tempHead.next = temp1;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(9);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(6);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(5);
        ListNode seventh = new ListNode(2);

        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        ListNode src = sortList(head);
        while (src != null) {
            System.out.println(src.val);
            src = src.next;
        }
    }
}
