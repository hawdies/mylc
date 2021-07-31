package lc;

/**
 * @author hawdies
 * @date 2021/7/31
 **/
public final class BuildTreeUtil {
    public static TreeNode buildTree(String[] arr) {
        return createTree(arr, 0);
    }

    private static TreeNode createTree(String[] arr, int index) {
        if (index < arr.length) {
            String str = arr[index];
            if (str.contains("#")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = createTree(arr, index * 2 + 1);
            node.right = createTree(arr, index * 2 + 2);
            return node;
        }
        return null;
    }
}
