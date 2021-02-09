public class LinkedListCycle {

    // Linked List Cycle
    // Given head, the head of a linked list, determine if the linked list has a cycle in it.
    // There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    // Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    // Return true if there is a cycle in the linked list. Otherwise, return false.
    public static boolean hasCycle(ListNode head) {
        /** My first solution */
//        // declare a set to help determine if a node has been visited
//        Set<ListNode> set = new HashSet<>();
//
//        // loop through linked list to determine if there is a cycle
//        ListNode current = head;
//        while(current != null) {
//            //check if the set already contains
//            if(!set.isEmpty() && set.contains(current)) {
//                return true;
//            }
//            // add list node value to the set
//            set.add(current);
//            // set current to next node
//            current = current.next;
//        }
//        return false;

        /** Floyd's Tortoise and Hare Algorithm solution */
//        if(head == null) return false;
//        // Set ListNode reference slow (tortoise/slow runner)
//        ListNode slow = head;
//        // Set ListNode reference fast (hare/fast runner)
//        ListNode fast = head.next;
//
//        // loop through list while slow reference does not equal to fast reference
//        while(slow != fast) {
//            // check if the fast reference or it's next reference is null (no cycle)
//            if(fast == null || fast.next == null) return false;
//
//            // set slow to following reference
//            slow = slow.next;
//
//            // set fast two references ahead
//            fast = fast.next.next;
//        }
//        return true;

        /** Interesting solution */
        if(head == null) return false;
        // create a new ListNode
        ListNode mark = new ListNode(0);

        // declare a current reference to the head of the list
        ListNode current = head;

        // iterate through the list
        while(current != null) {

            // if the current.next reference is equal to the mark node (has a cycle) return true
            if(current.next == mark) return true;
            // set mark.next reference to the current
            mark.next = current;

            //set current reference to the next node
            current = current.next;

            // set the former current next reference equal to mark
            mark.next.next = mark;
        }
        // if loop terminates there is no cycle
        return false;
    }
}
