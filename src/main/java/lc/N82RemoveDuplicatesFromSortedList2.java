package lc;

/**
 * @author hawdies
 * @date 2021/4/13
 **/
public class N82RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int val = p.next.val;
                ListNode temp = p.next;
                while (temp != null && temp.val == val) temp = temp.next;
                p.next = temp;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
