package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @date 2022/4/18
 */
public class N272LexicographiclaNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            list.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return list;
    }
}
