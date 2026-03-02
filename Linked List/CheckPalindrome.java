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
    public Node findMid(Node temp){
        Node slow = temp;
        Node fast = temp;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; // +2
        }
        return slow; //slow is my mid
    }
    public boolean checkPalindrome(){
        if(head == null || head.next ==null){
            return true;
        }
        // Step 1 : find mid
        Node midNode = findMid(head);

        // Step 2: reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right = prev; // right half head
        Node left = head;

        // Step 3: check left half & right half 
        while (right != null) {
            if(left.val!=right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPalindrome ll = new CheckPalindrome();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(6);
        ll.addLast(5);
        ll.print();
        System.out.println(ll.checkPalindrome());
    }
}