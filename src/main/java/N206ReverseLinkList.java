/**
 * @author hawdies
 * @Date 2021/3/25
 **/
public class N206ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        //调用两个方法之一即可
        return recurse(head);
    }

    // 递归解法
    private ListNode recurse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = recurse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    // 迭代解法
    private ListNode iterate(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = temp;
        }
        return dummy;
    }
}
