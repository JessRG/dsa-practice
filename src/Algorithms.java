public class Algorithms {

    // Depth First Search

    // Breadth First Search

    // Matching Bracket Problem (Matching Parenthesis)

    // Hash Tables

    // Variables and Pointers Manipulation

    // Reverse a Linked List
    public static ListNode reverseList(ListNode head) {
        // check if either reference parameter head or head's next reference is null
        if(head == null || head.next == null) return head;

        // assign current to the head of the list
        ListNode current = head;

        // assign previous to null
        ListNode prev = null;

        // iterate through the linked list
        while(current != null) {
            // assign temp reference to next node in the list
            ListNode temp = current.next;

            // set current next reference to previous
            current.next = prev;

            // set previous to the current reference
            prev = current;

            // set current reference to temp
            current = temp;
        }
        return prev;
    }

    // Sorting Fundamentals

    // Recursion

    // Custom Data structure

    // Binary Search
    public static boolean binarySearch(int v, int[] nums, int low, int high) {
        if(low > high) {
            System.out.println("Not found");
            return false;
        }

        int mid = (low + high) / 2;
        if(v == nums[mid]) {
            System.out.printf("Found it at %d!\n", mid);
            return true;
        } else if(v < nums[mid]) {
            return binarySearch(v, nums, low, mid-1);
        } else {
            return binarySearch(v, nums, mid+1, high);
        }
    }
}
