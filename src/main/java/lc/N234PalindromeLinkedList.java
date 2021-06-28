package lc;

/**
 * 判断是否是回文链表
 *
 * 1. 将值放入数组中,使用前后两个指针遍历
 * 2. 使用递归和一个全局变量求解
 * 3. 反转后半部分链表,使用双指针求解
 *
 * @author hawdies
 * @Date 2021/3/29
 **/
public class N234PalindromeLinkedList {
    private ListNode firstNode;
    public boolean isPalindrome(ListNode head) {
        // 1. 递归方法求解
//        firstNode = head;
//        return recurse(firstNode);
        // 2.反转链表,双指针求解
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode low = head;
        ListNode fast = head;
        for (int i = 0; i < (int)Math.ceil(length / 2); i++) {
            fast = fast.next;
        }
        fast = reverseList(fast);
        while (fast != null) {
            if (low.val != fast.val) return false;
            low = low.next;
            fast = fast.next;
        }
        return true;


    }
    // 递归方法求解,需要使用一个成员变量firstNode
    private boolean recurse(ListNode currentNode) {
        if (currentNode != null) {
            if (recurse(currentNode.next) == false) {
                return false;
            }
            if (firstNode.val != currentNode.val) {
                return false;
            }
            firstNode = firstNode.next;
        }
        return true;

    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = temp;
        }
        return dummy.next;
    }
}
