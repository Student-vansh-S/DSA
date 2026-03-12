public class QueueA {
    static class Queue{
        // Using Array
        // static int arr[];
        // static int size;
        // static int rear;
        // Queue(int n){
        //     arr = new int[n];
        //     size = n;
        //     rear = -1;
        // }

        // public boolean isEmpty(){
        //     return rear == -1;
        // }

        // public void add(int data){
        //     if(rear == size-1){
        //         System.out.println("Queue is full");
        //         return;
        //     }
        //     rear++;
        //     arr[rear] = data;
        // }
        // public int remove(){
        //     if(isEmpty()){
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     int front = arr[0];
        //     for(int i=0; i<rear; i++){
        //         arr[i] = arr[i+1];
        //     }
        //     rear--;
        //     return front;
        // }

        // public int peek(){
        //     if(isEmpty()){
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     return arr[0];
        // }

        // Using Circular Array
        // static int arr[]; 
        // static int size;
        // static int rear;
        // static int front;
        // Queue(int n){
        //     arr = new int[n];
        //     size = n;
        //     rear = -1;
        //     front = -1;
        // }
        // public boolean isEmpty(){
        //     return rear == -1 && front == -1;
        // }
        // public void add(int data){
        //     if((rear+1)%size == front){
        //         System.out.println("Queue is full");
        //         return;
        //     }
        //     if(isEmpty()){
        //         rear = 0;
        //         front = 0;
        //     }else{
        //         rear = (rear+1)%size;
        //     }
        //     arr[rear] = data;
        // }
        // public int remove(){
        //     if(isEmpty()){
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     int data = arr[front];
        //     if(front == rear){
        //         front = -1;
        //         rear = -1;
        //     }else{
        //         front = (front+1)%size;
        //     }
        //     return data;
        // }
        // public int peek(){
        //     if(isEmpty()){
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     return arr[front];
        // }

        // Using Linked List
        static Node head = null;
        static Node tail = null;
        public void add(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public int remove(){
            if(head == null){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            head = head.next;
            return front;
        }
        public int peek(){
            if(head == null){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
        public boolean isEmpty(){
            return head == null;
        } 
        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // System.out.println(q.remove());
        // System.out.println(q.peek());
        // while (!q.isEmpty()) {
        //     System.out.println(q.remove());
        // }
        q.display();
    }
}