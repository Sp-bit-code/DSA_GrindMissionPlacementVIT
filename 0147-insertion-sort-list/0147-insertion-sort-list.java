
class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {

            // Save next node before changing links
            ListNode next = curr.next;

            // Find correct position in sorted list
            ListNode prev = dummy;

            while (prev.next != null &&
                   prev.next.val <= curr.val) {
                prev = prev.next;
            }

            // Insert current node
            curr.next = prev.next;
            prev.next = curr;

            // Move to next unsorted node
            curr = next;
        }

        return dummy.next;
    }
}
