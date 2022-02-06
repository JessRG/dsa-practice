public class ReverseLinkedList {

    // Reverse Linked List
    public static ListNode reverseListRecursive(ListNode head) {
        // check if either reference parameter head or head's next reference is null
        if(head == null || head.next == null) return head;

        // re
        ListNode ptr = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return ptr;
    }
}
