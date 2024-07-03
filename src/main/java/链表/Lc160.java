package 链表;

/**
 * 相交链表
 */

public class Lc160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;
        ListNode res = null;

        while (pa != null && pb != null) {

            if (pa == pb)
                return pa;

            pa = pa.next;
            pb = pb.next;

            if (pa == null && pb == null)
                break;
            else if (pa == null) {
                pa = headB;
            } else if (pb == null) {
                pb = headA;
            } else if (pa == pb){
                res = pa;
                break;
            }



        }

        return res;
    }

}
