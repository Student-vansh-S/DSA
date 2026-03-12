import java.util.*;

public class ImplementStackUsingQueue {
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            if (!q1.isEmpty()) {
                q1.add(x);
            } else {
                q2.add(x);
            }
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public int top() {
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new ImplementStackUsingQueue().new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top()); // returns 2
        System.out.println(stack.pop()); // returns 2
        System.out.println(stack.empty()); // returns false
    }
}
