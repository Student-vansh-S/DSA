import java.util.Stack;

public class ImplementQueueUsingStack {
    static class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            return s1.pop();
        }

        public int peek() {
            if (empty()) {
                return -1;
            }
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // returns 1
        System.out.println(queue.pop()); // returns 1
        System.out.println(queue.empty()); // returns false
    }
}