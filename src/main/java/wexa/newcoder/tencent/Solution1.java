package wexa.newcoder.tencent;

import lc.ListNode;

import java.util.List;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param m int整型
     * @param a ListNode类 指向彩带的起点，val表示当前节点的val，next指向下一个节点
     * @return ListNode类一维数组
     */
    public ListNode[] solve (int m, ListNode a) {
        // write code here
        ListNode[] res = new ListNode[m];
        for (int i = 0; i < m; i++) {
            ListNode dummy = new ListNode(0);
            res[i] = dummy;
        }
        ListNode[] arrp = new ListNode[m];
        for (int i = 0; i< m; i++) {
            arrp[i] = res[i];
        }
        ListNode p = a;
        while (p != null) {
            int index = p.val % m;
            arrp[index].next = p;
            ListNode tmp = p.next;
            arrp[index] = arrp[index].next;
            p.next = null;
            p = tmp;
        }
        for (int i = 0; i < m; i++) {
            res[i] = res[i].next;
        }
        return res;
    }
}
