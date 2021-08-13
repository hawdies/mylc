package wexa.newcoder.beikezufang;

/**
 * @author hawdies
 * @date 2021/8/13
 **/
public class Solution2 {

    public static void main(String[] args) {
        Solution2 demo = new Solution2();
        String s = "cbcb";
        int k = 1;
        String s1 = demo.NS_String(s, k);
        System.out.println(s1);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param k int整型
     * @return string字符串
     */
    public String NS_String (String s, int k) {
        // write code here
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        while (k-- > 0) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    arr[i] = 0;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (arr[c - 'a'] > 0) {
                sb.append(c);
                arr[c - 'a']--;
            }
        }
        return sb.toString();
    }
}
