package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * <p>
 * 这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数Successor(x, curOrder)，给定一个人x和当前的继承顺序，该函数返回 x的下一继承人。
 * <p>
 * Successor(x, curOrder):
 * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
 * 如果 x 是国王，那么返回 null
 * 否则，返回 Successor(x 的父亲, curOrder)
 * 否则，返回 x 不在 curOrder 中最年长的孩子
 * 比方说，假设王国由国王，他的孩子Alice 和 Bob （Alice 比 Bob年长）和 Alice 的孩子Jack 组成。
 * <p>
 * 一开始，curOrder为["king"].
 * 调用Successor(king, curOrder)，返回 Alice ，所以我们将 Alice 放入 curOrder中，得到["king", "Alice"]。
 * 调用Successor(Alice, curOrder)，返回 Jack ，所以我们将 Jack 放入curOrder中，得到["king", "Alice", "Jack"]。
 * 调用Successor(Jack, curOrder)，返回 Bob ，所以我们将 Bob 放入curOrder中，得到["king", "Alice", "Jack", "Bob"]。
 * 调用Successor(Bob, curOrder)，返回null。最终得到继承顺序为["king", "Alice", "Jack", "Bob"]。
 * 通过以上的函数，我们总是能得到一个唯一的继承顺序。
 * <p>
 * 请你实现ThroneInheritance类：
 * <p>
 * ThroneInheritance(string kingName) 初始化一个ThroneInheritance类的对象。国王的名字作为构造函数的参数传入。
 * void birth(string parentName, string childName)表示parentName新拥有了一个名为childName的孩子。
 * void death(string name)表示名为name的人死亡。一个人的死亡不会影响Successor函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
 * string[] getInheritanceOrder()返回 除去死亡人员的当前继承顺序列表。
 *
 *
 * 思路:
 * 方法1: 使用多叉树进行先序遍历
 * 方法2: 使用链表,添加一个last指针,只想当前节点的最后一个儿子节点.需要分两种情况,当前节点没有儿子节点,即p.last == null; 当前节点有儿子节点.
 * tips: 注意继承顺序,是儿子节点->孙子节点->....->兄弟节点
 * 在添加节点时,需要添加到当前节点的最后的儿子节点的最后的儿子节点的...(这个是一个递归的过程,dfs),通过一个while循环来找到该节点
 * @author hawdies
 * @date 2021/6/20
 **/
public class N1600ThroneInheritance {
    private Map<String, Node> map = new HashMap<>();
    private Node head = new Node("");

    public N1600ThroneInheritance(String kingName) {
        Node node = new Node(kingName);
        head.next = node;
        head.last = node;
        map.put(kingName, node);
    }

    public void birth(String parentName, String childName) {
        Node p = map.get(parentName);
        Node node = new Node(childName);
        map.put(childName, node);
        Node tmp = p;
        // 重点理解
        while (tmp.last != null) tmp = tmp.last;
        node.next = tmp.next;
        tmp.next = node;
        p.last = node;
    }

    public void death(String name) {
        Node p = map.get(name);
        p.alive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        Node p = head.next;
        while (p != null) {
            if (p.alive) {
                list.add(p.name);
            }
            p = p.next;
        }
        return list;
    }


    private static class Node {
        private final String name;
        private Node next;
        private Node last;
        public boolean alive = true;

        public Node(String name) {
            this.name = name;
        }
    }
}
