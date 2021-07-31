package wexa.saima.dj;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author hawdies
 * @date 2021/7/31
 **/
public class Solution0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                treeSet.add(scanner.nextInt());
            }
            for (int i = 0; i < m; i++) {
                treeSet.add(scanner.nextInt());
            }
            for (Integer integer : treeSet) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
