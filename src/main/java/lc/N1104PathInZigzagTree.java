package lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description: 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * 思路: 根据树的数学规律,找出父节点.
 *
 * @author hawdies
 * @date 2021/7/29
 **/
public class N1104PathInZigzagTree {
    public static void main(String[] args) {
        int level = (int) Math.ceil(Math.log(14 + 1) / Math.log(2));
        System.out.println(level);
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        list.add(label);
        int level = (int) Math.ceil(Math.log(label + 1) / Math.log(2));
        if (level == 1) return list;
        level--;
        while (level > 1) {
            label = findParent(label, level);
            list.add(label);
            level--;
        }
        list.add(1);
        Collections.reverse(list);
        return list;
    }

    private int findParent(int label, int level) {
        int levelValue = (int) (Math.pow(2, level) - 1 + Math.pow(2, level - 1));
        int oldParent = label / 2;
        return levelValue - oldParent;
    }
}
