/**
 * description: 给你一个整数数组perm，它是前n个正整数的排列，且n是个 奇数。
 * 它被加密成另一个长度为 n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。比方说，如果perm = [1,3,2]，那么encoded = [2,1]。
 * 给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。
 * <p>
 * 思路: 利用异或运算的性质,先求出最后最后一个元素即可求解.
 *
 * @author hawdies
 * @date 2021/5/11
 **/
public class N1734DecodeXorPermutation {
    public static void main(String[] args) {

    }

    public int[] decode(int[] encoded) {
        int[] res = new int[encoded.length + 1];
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < encoded.length; i++) {
            s1 ^= encoded[i++];
        }
        s2 = fun(encoded.length + 1);
        res[encoded.length] = s1 ^ s2;
        for (int i = encoded.length - 1; i >= 0; i--) {
            res[i] = res[i + 1] ^ encoded[i];
        }
        return res;
    }


    private int fun(int x) {
        if (x % 4 == 0) {
            return x;
        }
        if (x % 4 == 1) {
            return 1;
        }
        if (x % 4 == 2) {
            return x + 1;
        }

        return 0;
    }
}
