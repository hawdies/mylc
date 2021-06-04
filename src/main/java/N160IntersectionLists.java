import java.util.HashMap;
import java.util.Map;

/**
 * description: 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 思路:
 *  方法1: 使用哈希表存储链表A的节点,再遍历链表B查找是否存在.
 *  方法2: 使用双指针pa, pb. 分别遍历链表a和链表b.当遍历到尾时,pa从链表B的头开始再遍历边,pb从链表A的开始遍历,
 *  如果同时遍历到同一个节点则返回;如果同时遍历到尾则返回null
 * @author hawdies
 * @date 2021/6/4
 **/
public class N160IntersectionLists {
    // 方法1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Object> map = new HashMap<>();
        final Object VALUE = new Object();
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != null) {
            map.put(pa, VALUE);
            pa = pa.next;
        }
        while (pb != null) {
            if (map.containsKey(pb)) {
                return pb;
            }
            pb = pb.next;
        }
        return null;
    }

    // 方法2: 双指针,先分别遍历,再交叉遍历
    public ListNode getIntersectionNode02(ListNode headA, ListNode headB) {
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != null || pb != null) {
            if (pa == pb) return pa;
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return null;
    }
}
