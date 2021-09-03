package wexa.huawei;

import java.util.*;

/**
 * @author hawdies
 * @date 2021/9/1
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            in.nextLine();
            String[][] strs = new String[n][3];
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                String[] s1 = s.split(" ");
                strs[i][0] = s1[0];
                strs[i][1] = s1[1];
                strs[i][2] = s1[2];
            }
            String s = in.next();
            fun(strs, n, s);
        }
    }

    private static void fun(String[][] strs, int n, String s) {
        Map<String, TreeNode> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (strs[i][1].equals("subClassOf")) {
                TreeNode parent = map.getOrDefault(strs[i][2], new TreeNode(strs[i][2]));
                TreeNode son = map.getOrDefault(strs[i][0], new TreeNode(strs[i][0]));
                if (parent.nexts == null) {
                    parent.nexts = new ArrayList<>();
                }
                if (!parent.nexts.contains(son)) {
                    parent.nexts.add(son);
                }
                map.put(strs[i][2], parent);
                map.put(strs[i][0], son);
            } else if (strs[i][1].equals("instanceOf")) {
                TreeNode node = map.getOrDefault(strs[i][2], new TreeNode(strs[i][2]));
                if (node.instances == null) {
                    node.instances = new ArrayList<>();
                }
                if (!node.instances.contains(strs[i][0])) {
                    node.instances.add(strs[i][0]);
                }
                map.put(strs[i][2], node);
            }
        }
        TreeNode root = map.get(s);
        List<String> res = new ArrayList<>();
        dfs(root, res);
        Collections.sort(res);
        if (res.size() == 0) {
            System.out.println("empty");
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i < res.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }


    private static void dfs(TreeNode root, List<String> res) {
        if (root == null) return;
        if (root.instances.size() > 0) {
            res.addAll(root.instances);
        }
        if (root.nexts != null) {
            for (TreeNode next : root.nexts) {
                dfs(next, res);
            }
        }
    }
}

class TreeNode {
    String value;
    List<TreeNode> nexts;
    List<String> instances;
    public TreeNode (String value) {
        this.value = value;
    }
}
