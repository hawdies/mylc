package wexa.newcoder.rongyao;

import java.util.*;

/**
 * @author hawdies
 * @date 2021/8/7
 **/
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strs = new String[10];
            for(int i = 0; i < 10; i++) {
                strs[i] = scanner.next();
            }
            List<String> list = fun(strs);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    private static List<String> fun(String[] strs) {
        List<String> list = new ArrayList<>();
        list.add("[First round name list]");

        List<Node> nodes = new ArrayList<>();
        for (String str : strs) {
            String[] split = str.split("");
            Node node = new Node(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
            nodes.add(node);
        }
        nodes.sort((node1, node2) -> {
            int sum1 = node1.chinese + node1.math + node1.english;
            int sum2 = node2.chinese + node2.math + node2.english;
            if (sum1 != sum2) {
                return sum2 - sum1;
            }
            if (node1.chinese != node2.chinese) {
                return node2.chinese - node1.chinese;
            }
            if (node1.math != node2.math) {
                return node2.math - node1.math;
            }
            if (node1.english != node2.english) {
                return node2.english - node1.english;
            }
            return node1.name.compareTo(node2.name);
        });
        for (Node node : nodes) {
            list.add(node.toString());
        }

        return list;
    }

    public static class Node {
        String name;
        int chinese;
        int math;
        int english;

        public Node(String name, int chinese, int math, int english) {
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
        }

        @Override
        public String toString() {
            return name + " " + chinese + " " + math + " " + english;
        }
    }
}
