package 链表.合并已排序链表;

import 链表.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @projectName: leetcode
 * @package: 链表.合并已排序链表
 * @className: Solu
 * @author: BeamX
 * @description: TODO
 * @date: 2023/12/21 23:00
 */
public class Solution {
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here

        Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                queue.add(lists.get(i));
            }
        }

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            head.next = temp;
            head = head.next;

            if (temp.next != null) {
                queue.add(temp.next);
            }
        }

        return res.next;

    }
}
