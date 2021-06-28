package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/4/12
 **/
public class N148SortedList {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        int len = 0;
        while (p != null) {
            list.add(p.val);
            p = p.next;
            len++;
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        p = head;
        for (int i = 0; i < len; i++) {
            p.val = array[i];
            p = p.next;
        }
        return head;
    }

    public ListNode sortList02(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList02(head);
        ListNode right = sortList02(tmp);
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                p = p.next;
                left = left.next;
            } else {
                p.next = right;
                p = p.next;
                right = right.next;
            }
        }
        p = left != null ? left : right;
        return dummy.next;
    }

}
