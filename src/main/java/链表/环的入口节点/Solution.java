package 链表.环的入口节点;

import 链表.ListNode;

/**
 * @projectName: leetcode
 * @package: 链表.环的入口节点
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/31 23:52
 */
public class Solution {

    public boolean hasLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }

        return false;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (!hasLoop(pHead))
            return null;

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = pHead;
                break;
            }
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
