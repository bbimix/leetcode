package 链表;

/**
 * 合并k个升序链表
 * 1.一个个来
 * 2.分治 两两合并
 * 3.优先队列
 */

public class Lc23 {

    public ListNode mergeKLists(ListNode[] lists) {

        int n = lists.length;
        ListNode ans = null;
        ans = merge(lists, 0, n - 1);
        return ans;
    }

    private ListNode merge(ListNode[] lists, int l, int r) {

        if (l == r)
            return lists[r];
        if (l > r)
            return null;
        int mid = (r - l) / 2 + l;
        return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    private ListNode mergeTwo(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode res = new ListNode(-1);
        ListNode pre = res;

        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        if (l1 != null || l2 != null) {
            pre.next = l1 == null ? l2 : l1;
        }

        return res.next;
    }

}
