package wexa.newcoder.haoweilai;

/**
 * @author hawdies
 * @date 2021/8/8
 **/
public class Solution2 {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        int k = 3;
        Solution2 demo = new Solution2();
        String s = demo.edit_string(str, 3);
        System.out.println();
    }
    public String edit_string (String str, int k) {
        int n = str.length();
        k = k % n;
        String str1 = str.substring(0, k);
        String str2 = str.substring(k);
        return str2 + str1;
    }
}
