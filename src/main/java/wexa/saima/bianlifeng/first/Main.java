package wexa.saima.bianlifeng.first;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/4/9
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            String result = fun(input);
            System.out.println(result);
        }
    }

    private static String fun(String input) {
        if (input == null || input.isEmpty()) return input;
        int len = input.length();
        int numIndex = 0;
        int left = 0;
        int right = 0;
        int strIndex = 0;
        String result;
        if (input.charAt(0) > '9') {
            if (input.charAt(0) != '{') return input;
            if (input.charAt(0) == '{') {
                String str = input.replace("{", "");
                str = str.replace("}", "");
            }
        }
        if (input.contains("{")) {
            left = input.indexOf('{');
            right = input.indexOf('}');
            strIndex = right + 1;
        } else {
            for (int i = 0; i < len; i++) {
                char temp = input.charAt(i);
                if (temp > '9') {
                    strIndex = i;
                }
            }
            if (strIndex == 0) return input;
        }

        if (left > 0) {
            String countStr = input.substring(numIndex, left);
            int count = new Integer(countStr);
            String copyStr = input.substring(left + 1, right);
            String lastStr;
            lastStr = right <= len - 1 ? input.substring(right + 1, len) : "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(copyStr);
            }
            sb.append(lastStr);
            result = sb.toString();
        } else {
            String countStr = input.substring(numIndex, strIndex);
            int count = new Integer(countStr);
            String copyStr = input.substring(strIndex, len);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(copyStr);
            }
            result = sb.toString();
        }
        return result;
    }
}
