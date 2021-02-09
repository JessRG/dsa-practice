public class ReverseLinkedList {

    // Reverse Linked List
    // Reverse a singly linked list.
    public static ListNode reverseList(ListNode head) {
        // check if either reference parameter head or head's next reference is null
        if(head == null || head.next == null) return head;

        // declare current reference to the head of the list
        ListNode current = head;

        // declare a previous reference set as null
        ListNode prev = null;

        // iterate through the linked list
        while(current != null) {
            // declare temp reference to be set to current's next reference
            ListNode temp = current.next;

            // set current's next reference to previous reference
            current.next = prev;
            // set previous to the current reference
            prev = current;

            // set current reference to temp
            current = temp;
        }
        return prev;
    }

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
