package 链表;


/**
 * 两两交换列表的节点
 * 返回头节点
 * 想到的方法是分成两个链表 再拼起来
 */
public class Lc24 {

    public static ListNode swapPairs(ListNode head) {

        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode sg = head, sgHead = head;
        ListNode db = head.next, dbHead = head.next;

        while (sg != null && db != null) {

            sg.next = db.next;
            sg = db.next;

            if (sg != null) {
                db.next = sg.next;
                db = sg.next;
            }
        }

        sg = sgHead;
        db = dbHead;

        ListNode sgPtr = sg.next;
        ListNode dbPtr = db.next;

        while (db != null) {
            db.next = sg;
            db = dbPtr;
            if (dbPtr != null)
                dbPtr = dbPtr.next;

            if (db != null) {
                sg.next = db;
                sg = sgPtr;
                if (sgPtr != null)
                    sgPtr = sgPtr.next;
            } else {
                continue;
            }

        }

        return dbHead;
    }

    public static ListNode swapPairsOffcial(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        ListNode node1, node2;

        while (temp.next != null && temp.next.next != null) {

            node1 = temp.next;
            node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dummyHead.next;
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

        ListNode src = swapPairs(head);
        while (src != null) {
            System.out.println(src.val);
            src = src.next;
        }
    }

}
