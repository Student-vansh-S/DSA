public class SwapNodesInPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
        // dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            // swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;
            // move pointers
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }
}
