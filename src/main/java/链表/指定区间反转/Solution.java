package 链表.指定区间反转;

import 链表.ListNode;

/**
 * @projectName: leetcode
 * @package: 链表.指定区间反转
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/30 23:37
 */
public class Solution {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here

        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode pre = res;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }

        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return res.next;
    }
}
