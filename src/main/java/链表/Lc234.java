package 链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 要求空间为O（1） 想到双指针
 * 又突然想到双指针需要双向链表才行
 * 先使用反转链表来一次
 */

public class Lc234 {

    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();

        ListNode c = head;
        while (c != null) {
            list.add(c.val);
            c = c.next;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            if (list.get(l) == list.get(r)) {
                l++;
                r--;
            } else {
                break;
            }
        }

        if (l > r) {
            return true;
        }
        return false;
    }

    private ListNode front;

    public boolean isPalindromedfs(ListNode head) {
        front = head;
        return dfs(front);
    }

    private boolean dfs(ListNode head) {
        ListNode curr = head;
        if (curr != null) {
            if (!dfs(curr.next))
                return false;
            if (front.val != curr.val)
                return false;
            front = front.next;
        }
        return true;
    }

    public boolean isPalindromereverse(ListNode head) {

        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = null;
        ListNode c = slow.next;
        ListNode n = slow.next;

        while (n != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        ListNode s = head;
        ListNode e = p;
        while (e != null) {
            if (s.val != e.val) {
                return false;
            }
            s = s.next;
            e = e.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
