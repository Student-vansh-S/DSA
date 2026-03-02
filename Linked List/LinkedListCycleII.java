public class LinkedListCycleII {
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

    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (!cycle)
            return null;
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        LinkedListCycleII ll = new LinkedListCycleII();
        ll.addFirst(3);
        ll.addLast(2);
        ll.addLast(0);
        ll.addLast(-4);
        ll.detectCycle(head);
    }
}
