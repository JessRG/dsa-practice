
// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void traverseList(ListNode root) {

        ListNode current = root;
        System.out.print("[");
        while(current != null) {
            System.out.print(String.format("%d%s", current.val, current.next == null ? "]" : ","));
            current = current.next;
        }
    }
}
