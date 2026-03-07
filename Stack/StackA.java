// import java.util.*;
public class StackA {
    static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            next = null;
        }
    }
    static class StackB {
        static Node head= null;
        // Approach 1 - Build Stack using Linked List 
        public static boolean isEmpty(){
            return head == null;
        }

        // push 
        public void push(int val){
            Node newNode = new Node(val);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop 
        public int pop(){
            if (isEmpty()) {
                return -1;
            }
            int top = head.val;
            head = head.next;
            return top;
        }

        // peek 
        public int peek(){
            if (isEmpty()) {
                return -1;
            }
            return head.val;
        }

        // print stack
        public void print(){
            if (isEmpty()) {
                System.out.println("Stack is empty.");
            }
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }
        
        /* 
        Approach 1 - Build Stack using ArrayList
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty(){
            return list.size() == 0;
        }

        // push
        public void push(int data){
            list.add(data);
        }

        // pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty.");
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty.");
                return -1;
            }
            return list.get(list.size()-1);
        }

        // print stack
        public void print(){
            for(int i=list.size()-1;i>=0;i--){
                System.out.println(list.get(i));
            }
        }
        */
    }

    public static void main(String[] args) {
        // Inbuild Stack (Java Collection FrameWork)
        // Stack<Integer> s = new Stack<>();
        StackB s = new StackB();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top element: " + s.peek());

        s.print();

        s.pop();
        s.pop();

        System.out.println("After popping:");

        s.print();
    }
}