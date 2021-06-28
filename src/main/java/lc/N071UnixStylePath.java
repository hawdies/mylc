package lc;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author hawdies
 * @Date 2021/3/16
 **/
public class N071UnixStylePath {
    public String simplifyPath(String path) {
        String res = null;
        String[] paths = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String temp : paths) {
            if (".".equals(temp) || temp.isEmpty()) {
                continue;
            } else if ("..".equals(temp)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(temp);
            }
        }
        Collections.reverse(stack);
        res = "/" + String.join("/", stack);
        return res;
    }

    public static void main(String[] args) {
        String res = new N071UnixStylePath().simplifyPath("/a/./b/../../c/");
        System.out.println(res);
    }
}
