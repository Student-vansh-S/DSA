public class RotateList {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // Step 1: find length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        // Step 2: make it circular
        temp.next = head;
        // Step 3: find new head position
        k = k % length;
        int steps = length - k;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }
        // Step 4: break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
}
