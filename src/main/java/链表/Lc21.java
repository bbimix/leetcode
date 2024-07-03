package 链表;

/**
 * 合并有序链表
 */

public class Lc21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(-1);
        ListNode pre = res;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
                pre = pre.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
                pre = pre.next;
            }
        }

        pre.next = (list1 == null) ? list2 : list1;
        return res.next;
    }
}
