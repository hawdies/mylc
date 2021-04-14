package wexa.bianlifeng.three;

import java.util.*;

/**
 * @author hawdies
 * @date 2021/4/9
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            int k = scanner.nextInt();
            String result = fun(input, k);
            System.out.println(result);
        }
    }

    private static String fun(String input, int k) {
        int m = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') m++;
        }
        m++;
        int[] array = new int[m];
        String[] strs = input.split(",");
        for (int i = 0; i < m; i++) {
            array[i] = new Integer(strs[i]);
        }
        List<Integer> list = new ArrayList<>();
        int max = array[0];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.add(array[i]);
        }
        list.add(queue.stream().max(Integer::compareTo).get());
        for (int i = k; i < m; i++) {
            queue.removeFirst();
            queue.add(array[i]);
            list.add(queue.stream().max(Integer::compareTo).get());
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            sb.append(',');
        }
        sb.append(list.get(list.size() - 1));
        sb.append(']');
        return sb.toString();
    }
}
