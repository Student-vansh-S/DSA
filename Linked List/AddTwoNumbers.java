public class AddTwoNumbers {

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            // add l1 value
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // add l2 value
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // digit to store
            int digit = sum % 10;
            // update carry
            carry = sum / 10;
            // create new node
            curr.next = new ListNode(digit);
            // move pointer
            curr = curr.next;
        }

        return dummy.next;
    }
}
}