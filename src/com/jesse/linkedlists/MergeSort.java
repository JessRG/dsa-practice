package com.jesse.linkedlists;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode ptr = sort.sortList(head);
        while (ptr != null) {
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    // merge
    ListNode merge(ListNode first, ListNode second) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(first != null && second != null) {
            if (first.val < second.val) {
                tail.next = first;
                first = first.next;
                tail = tail.next;
            } else {
                tail.next = second;
                second = second.next;
                tail = tail.next;
            }
        }
        tail.next = (first != null) ? first : second;
        return dummyHead.next;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        ListNode sPre = null;

        while (f != null && f.next != null) {
            sPre = s;
            s = s.next;
            f = f.next.next;
        }
        sPre.next = null;
        return s;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
