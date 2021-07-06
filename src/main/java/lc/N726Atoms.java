package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author hawdies
 * @date 2021/7/5
 **/
public class N726Atoms {
    public static void main(String[] args) {
        Integer i = null;
        String a = "hi";
        System.out.println(a + i);
    }

    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                Map<String, Integer> pop = stack.pop();
                String number = getNumber(formula, ++i);
                if (number != null) i += number.length();
                int count = number == null ? 1 : Integer.parseInt(number);
                Map<String, Integer> peek = stack.peek();
                pop.forEach((key, value) -> {
                    pop.put(key, count * value);
                    Integer v = peek.getOrDefault(key, 0);
                    peek.put(key, v + pop.get(key));
                });
            } else {
                String element = getElement(formula, i);
                i += element.length();
                String number = getNumber(formula, i);
                if (number != null) i += number.length();
                int count = number == null ? 1 : Integer.parseInt(number);
                Map<String, Integer> peek = stack.peek();
                Integer v = peek.getOrDefault(element, 0);
                peek.put(element, v + count);
            }
        }
        Map<String, Integer> map = stack.pop();
        PriorityQueue<String> queue = new PriorityQueue<>();
        map.forEach((key, value) -> {
            if (value.equals(1)) {
                queue.offer(key);
            } else {
                queue.offer(key + value.toString());
            }
        });
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            sb.append(poll);
        }
        return sb.toString();
    }

    private String getElement(String formula, int start) {
        if (start >= formula.length()) return null;
        int end = start + 1;
        while (end < formula.length() && Character.isLowerCase(formula.charAt(end))) {
            end++;
        }
        return start == end ? null : formula.substring(start, end);

    }

    private String getNumber(String formula, int start) {
        if (start >= formula.length()) return null;
        int end = start;
        while (end < formula.length() && Character.isDigit(formula.charAt(end))) {
            end++;
        }
        return start == end ? null : formula.substring(start, end);

    }
}
