package 链表.k组反转;

import 链表.ListNode;

import java.util.List;

/**
 * @projectName: leetcode
 * @package: 链表.k组反转
 * @className: Solution
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/31 21:55
 */
public class Solution {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode res = new ListNode(-1);
        res.next = head;

        ListNode tail = head;
        for(int i = 0; i < k; i++){
            if(tail == null)
                return head;
            tail = tail.next;
        }

        ListNode pre = res;
        ListNode cur = pre.next;

        while (pre != null) {
            int n = k;
            while (n > 1) {
                ListNode temp = cur.next;
                if (temp != null) {
                    cur.next = temp.next;
                    temp.next = pre.next;
                    pre.next = temp;
                }
                n--;
            }
            n = k;
            while (n > 0 && pre != null) {
                pre = pre.next;
                n--;
            }
            if (n > 0) {
                return res.next;
            }
            if (pre != null && pre.next != null)
                cur = pre.next;
        }
        return res.next;
    }

    public ListNode reverseKGroup2 (ListNode head, int k) {
        //找到每次翻转的尾部
        ListNode tail = head;
        //遍历k次到尾部
        for(int i = 0; i < k; i++){
            //如果不足k到了链表尾，直接返回，不翻转
            if(tail == null)
                return head;
            tail = tail.next;
        }
        //翻转时需要的前序和当前节点
        ListNode pre = null;
        ListNode cur = head;
        //在到达当前段尾节点前
        while(cur != tail){
            //翻转
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //当前尾指向下一段要翻转的链表
        head.next = reverseKGroup2(tail, k);
        return pre;
    }

}
