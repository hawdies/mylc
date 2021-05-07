import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

/**
 * distription: 逆波兰表达式即后缀表达式, 求值使用栈运算即可.
 *
 * @author hawdies
 * @date 2021/5/6
 **/
public class N150EvaluateReversePolishNotation {
    public static void main(String[] args) throws UnsupportedEncodingException {
        N150EvaluateReversePolishNotation n150EvaluateReversePolishNotation = new N150EvaluateReversePolishNotation();
        String[] tokens = {
                "2","1","+","3","*"
        };
        int res = n150EvaluateReversePolishNotation.evalRPN(tokens);
        System.out.println(res);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> s1 = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    s1.push(s1.pop() + s1.pop());
                    break;
                case "-":
                    int subtractor = s1.pop();
                    int subtrahend = s1.pop();
                    int res = subtrahend - subtractor;
                    s1.push(res);
                    break;
                case "*":
                    s1.push(s1.pop() * s1.pop());
                    break;
                case "/":
                    int divisor = s1.pop();
                    int dividend = s1.pop();
                    s1.push(dividend / divisor);
                    break;
                default:
                    s1.push(Integer.parseInt(s));
            }
        }
        return s1.pop();
    }
}
