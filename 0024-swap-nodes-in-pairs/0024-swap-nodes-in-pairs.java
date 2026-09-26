class Solution {
    public ListNode swapPairs(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        // Swap first two nodes
        first.next = swapPairs(second.next);
        second.next = first;

        // second becomes the new head
        return second;
    }
}