package wexa.newcoder.haoweilai;

import lc.ListNode;

/**
 * @author hawdies
 * @date 2021/8/8
 **/
public class Solution1 {
    public ListNode merge (ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

}
