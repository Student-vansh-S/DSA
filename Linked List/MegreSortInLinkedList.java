public class MegreSortInLinkedList {
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

    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node left, Node right) {
        Node mergedll = new Node(-1);
        Node temp = mergedll;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return mergedll.next;
    }

    public Node mergeSort(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }
        // Step 1 : Find mid (1st half last element)
        Node midNode = findMid(head);

        // Step 2: mergeSort
        Node rightHead = midNode.next;
        midNode.next = null;
        Node newleft = mergeSort(head);
        Node newright = mergeSort(rightHead);

        // Step 3 : Merge
        return merge(newleft, newright);
    }

    public static void main(String[] args) {
        MegreSortInLinkedList ll = new MegreSortInLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.print();
        head = ll.mergeSort(head);
        ll.print();
    }
}
