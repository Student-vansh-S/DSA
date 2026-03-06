import java.util.*;

public class MergeKsortedLists {
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
    public void print(Node head) {
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

    public Node build(int[] arr) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        for (int x : arr) {
            tail.next = new Node(x);
            tail = tail.next;
        }
        return dummy.next;
    }
    
    // given: an array of k linked list, each sorted in ascending order
    // required: merge all the linked lists into one sorted list

    // constraints
    // k in [0, 10k]
    // length of each linked list in [0, 500]
    // each node value in [-10k, 10k]

    // one simple approach is to take 2 lists at a time, merge them and them move to
    // the next list
    // if each list is of size m and there are n linked lists
    // we traverse the first list n - 1 times
    // the second list n - 2 times
    // the last list once
    // m*(n - 1) + m*(n - 2) + ... + m*1 = m(n - 1 + n - 2 + ... + 1) = O(m*n^2)
    // class Solution {
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // ListNode dummy = new ListNode();
    // ListNode curr = dummy;
    // while(l1 != null && l2 != null) {
    // if(l1.val <= l2.val) {
    // curr.next = new ListNode(l1.val);
    // l1 = l1.next;
    // }
    // else {
    // curr.next = new ListNode(l2.val);
    // l2 = l2.next;
    // }
    // curr = curr.next;
    // }
    // if(l1 != null) {
    // curr.next = l1;
    // }
    // if(l2 != null) {
    // curr.next = l2;
    // }

    // return dummy.next;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    // if(lists.length == 0) {
    // return null;
    // }

    // ListNode result = lists[0];
    // for(int i = 1; i < lists.length; i++) {
    // result = mergeTwoLists(result, lists[i]);
    // }

    // return result;
    // }
    // }

    // what is inefficient here? we are traversing over the same lists multiple
    // times
    // we are traversing the first list n - 1 times, the second list n - 2 times and
    // so on
    // what if we could traverse each list constant no. of times?
    // we could use a strategy similar to merge sort, where we use divide and
    // conquer to merge 2 lists at a time
    // for example, we have 8 lists, we merge the first 2, then the second 2, the
    // third 2 and the last 2
    // in the next phase as we have 4 lists, we merge the first 2 and the second 2
    // in the final phase, we only have 2 lists left, so we merge them and return
    // in this case, each list is traversed 3 times only (logn)
    // this reduces the time complexity to nlogn*m instead of n^2*m
    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    public Node mergeKLists(Node[] lists) {
        if (lists.length == 0) {
            return null;
        }
        List<Node> mergedLists = new ArrayList<>(Arrays.asList(lists));
        while (mergedLists.size() > 1) {
            List<Node> temp = new ArrayList<>();
            for (int i = 0; i < mergedLists.size(); i = i + 2) {
                Node l1 = mergedLists.get(i);
                Node l2 = i == mergedLists.size() - 1 ? null : mergedLists.get(i + 1); // if there is an odd number of lists, the last list will be merged with null
                temp.add(mergeTwoLists(l1, l2));
            }
            mergedLists = temp;
        }
        return mergedLists.get(0);
    }

    public static void main(String[] args) {
        MergeKsortedLists ms = new MergeKsortedLists();

        Node l1 = ms.build(new int[] { 1, 4, 5 });
        Node l2 = ms.build(new int[] { 1, 3, 4 });
        Node l3 = ms.build(new int[] { 2, 6 });

        Node[] lists = new Node[] { l1, l2, l3 };

        Node result = ms.mergeKLists(lists);
        System.out.println("Merged List:");
        ms.print(result);
    }
}
