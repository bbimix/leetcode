package 链表;

/**
 * 给单链表加一 VIP题
 *  给定一个用链表表示的非负整数， 然后将这个整数 再加上 1 。
 * 这些数字的存储是这样的：最高位有效的数字位于链表的首位 head 。
 *
 * 思路 先反转 再加一 进位 之后 再反转
 *
 * 一遍A
 *
 * 官方解： 找出最右边不为9的数字 加上一
 * 剩下的9都变成0
 *
 * 对于 999 这种边界情况 使用dummyhead
 */

public class Lc369 {

    public ListNode plusOne(ListNode head) {


        ListNode rhead = reverse(head);
        int c = 1;

        ListNode cal = rhead;

        while (cal != null) {
            int val = cal.val;
            int newVal = (val + c) % 10;
            c = (val + c) / 10;
            cal.val = newVal;
            if (c == 0)
                break;

            cal = cal.next;
        }

        if (c == 1) {
            ListNode last = new ListNode(c);
            head.next = last;
        }

        return reverse(rhead);
    }

    private ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (cur != next) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (next != null)
                next = next.next;
        }

        return pre;

    }

}
