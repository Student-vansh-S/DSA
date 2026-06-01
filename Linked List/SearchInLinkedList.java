public class SearchInLinkedList {
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
        if (head == null) {
            System.out.println("Linked List is Empty.");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add at a specific location
    public void addSpecific(int idx, int val) {
        if (head == null) {
            addFirst(val);
            return;
        }
        Node newnNode = new Node(val);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newnNode.next = temp.next;
        temp.next = newnNode;
        size++;
    }

    // Remove from Start
    public int removeStart() {
        if (size == 0) {
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.val;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    // Remove from last
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List is Empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.val;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        // reach second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.val; // last node value
        temp.next = null; // remove last node
        tail = temp; // update tail
        size--;
        return val;
    }

    // Search in  Linked List using iteration (loop)
    public int search(int target){
        Node temp=head;
        int i=0;
        while (temp!=null) {
            if(temp.val==target){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    // Helper function bcz we don't wanna change head 
    public int helper(Node temp,int target){
        if(temp==null){
            return -1; // base case 
        }
        if(temp.val == target){
            return 0;
        }
        int idx = helper(temp.next, target);
        if(idx== -1){
            return-1;
        }
        return idx+1;
    }
    // Search in Linked List using recursion 
    public int recSearch(int target){
        return helper(head,target);
    }
    public static void main(String[] args) {
        SearchInLinkedList ll=new SearchInLinkedList();
        ll.addFirst(1);
        ll.addLast(12);
        ll.addLast(40);
        ll.addLast(9);
        ll.addLast(5);
        ll.print();
        System.out.println(ll.recSearch(400));
        System.out.println(ll.recSearch(9));
    }
}
