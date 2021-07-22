package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * <p>
 * 思路: 回溯 + 哈希表求解
 * 哈希表map存放老节点与复制节点的对应关系
 * 先查看map中是否有对应的oldNode,如果没有则创建新节点newOld,并将该kv放入map,然后在处理对应的oldNode.next, oldNode.random.
 * 这是一个递归的过程.
 *
 * @author hawdies
 * @date 2021/7/22
 **/
public class N138CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        private Node(int val) {
            this.val = val;
        }
    }

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

}

