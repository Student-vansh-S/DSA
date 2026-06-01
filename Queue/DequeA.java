import java.util.*;

public class DequeA {
    static class Stack{
        Deque<Integer> d = new ArrayDeque<>();
        public void push(int x){
            d.addLast(x);
        }
        public int pop(){
            return d.removeLast();
        }
        public int peek(){
            return d.peekLast();
        }
    }
    static class Queue{
        Deque<Integer> d = new ArrayDeque<>();
        public void add(int x){
            d.addLast(x);
        }
        public int remove(){
            return d.removeFirst();
        }
        public int peek(){
            return d.peekFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println("Peek :"+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        // Stack s = new Stack();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // System.out.println("Peek :"+s.peek());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // Deque<Integer> d = new ArrayDeque<>();
        // d.addFirst(4);
        // d.addFirst(3);
        // d.addFirst(2);
        // d.addFirst(1);
        // d.addLast(5);
        // System.out.println(d);
        // System.out.println(d.removeFirst());
        // System.out.println(d.removeLast());
        // System.out.println(d);
        // System.out.println(d.peekFirst());
        // System.out.println(d.peekLast());
    }
}
