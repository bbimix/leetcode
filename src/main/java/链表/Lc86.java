package 链表;

/**
 * 分隔链表
 *
 * 正常思路 两个子链
 * 一个大于等于x 一个小于x
 * 在拼起来
 *
 * 我的思路：遍历一遍链表，小于x的插入到插入指针后 指针向后挪
 * 在原列表上改需要四个指针
 * lim 指向插入位置 pre 指向目前节点前一个 idx指向目前节点后一个 cur就是目前节点
 */

public class Lc86 {
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy, lim = dummy, cur = head, idx = cur.next;

        while (cur != null) {
            if (cur.val < x) {
                if (pre != lim) {
                    pre.next = idx;
                    cur.next = lim.next;
                    lim.next = cur;
                    lim = lim.next;
                    cur = idx;
                    if (idx != null)
                        idx = idx.next;
                } else {
                    lim = lim.next;
                    pre = pre.next;
                    cur = idx;
                    if (idx != null)
                        idx = idx.next;
                }
            } else {
                pre = pre.next;
                cur = idx;
                if (idx != null)
                    idx = idx.next;
            }
        }

        return dummy.next;
    }
}
