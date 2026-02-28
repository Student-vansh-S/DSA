public class CheckPalindrome {
    // Node class
    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // LinkedList properties
    public static Node head;
    public static Node tail;
    public static int size;

    // Add at start
    public void addFirst(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add at end
    public void addLast(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // Print list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add at a specific location
    public void addSpecific(int idx,int val){
        Node newnNode=new Node(val);
        Node temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        temp.next=newnNode;
    }
    public static void main(String[] args) {
        CheckPalindrome ll = new CheckPalindrome();
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(30);
        ll.print();
    }
}