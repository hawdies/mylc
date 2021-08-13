package wexa.newcoder.beikezufang;

/**
 * @author hawdies
 * @date 2021/8/13
 **/
public class Solution3 {

    public static void main(String[] args) {
//        Solution3 demo = new Solution3();
//        int[] a = {2, 3, 4, 8};
//        int t = 6;
//        long section = demo.section(a, t);
//        System.out.println(section);
        System.out.println(100000 ^ 99999);
    }

    public long section (int[] a, int t) {
        // write code here
        int n = a.length;
        long qy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] ^ a[j]) != t){
                    qy++;
                } else {
                    break;
                }
            }
        }
        return qy;
    }
}
