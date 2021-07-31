package wexa.newcoder.yuanfudao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/7/31
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                index1 = i + 1;
                break;
            }
        }
        for (int j = list.size() - 1; j > 0; j--) {
            if (list.get(j) < list.get(j - 1)) {
                index2 = j + 1;
                break;
            }
        }
        System.out.println(index1 + " " + index2);
    }
}
