import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLists {

    // Intersection of Two Linked Lists
    // Write a program to find the node at which the intersection of two singly linked lists begins.
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        // Declare hashset to store node addresses from headA
        Set<ListNode> hset = new HashSet<>();

        ListNode currentA = headA;
        while(currentA != null) {
            // Add ListNode from listA (headA) into the hashmap
            hset.add(currentA);
            // set currentA to next reference in listA
            currentA = currentA.next;
        }

        ListNode currentB = headB;
        ListNode intersect = null;
        while(currentB != null) {
            // check if ListNode from listB is contained within the hashmap
            if(hset.contains(currentB)) {
                intersect = currentB;
                break;
            }
            // set currentB to the next reference in listB
            currentB = currentB.next;
        }
        return intersect;
    }
}
