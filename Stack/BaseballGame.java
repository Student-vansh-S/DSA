import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();

        for (String op : operations) {

            if (op.equals("C")) {
                s.pop();

            } else if (op.equals("D")) {
                s.push(2 * s.peek());

            } else if (op.equals("+")) {
                int top = s.pop();
                int newTop = top + s.peek();
                s.push(top);
                s.push(newTop);

            } else {
                // number
                s.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }

        return sum;
    }
}
