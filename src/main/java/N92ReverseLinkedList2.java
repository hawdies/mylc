import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/4/9
 **/
public class N92ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prenewHead = dummy;
        ListNode tail = dummy;
        ListNode p = dummy;
        for (int i = 0; p != null; i++, p = p.next) {
            if (i + 1 == left) {
                prenewHead = p;
            }
            if (i == right) {
                tail = p;
                break;
            }
        }
        ListNode postTail = tail.next;
        List<ListNode> res = reverse(prenewHead.next, tail);
        prenewHead.next = res.get(0);
        res.get(1).next = postTail;
        return dummy.next;
    }

    private List<ListNode> reverse(ListNode head, ListNode tail) {
        List<ListNode> list = new ArrayList<>();
        ListNode dummy = new ListNode();
        ListNode p = head;
        while (p != tail) {
            ListNode temp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = temp;
        }
        tail.next = dummy.next;
        dummy.next = tail;
        list.add(tail);
        list.add(head);
        return list;
    }
}
