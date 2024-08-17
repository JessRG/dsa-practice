package com.jesse.linkedlists;

public class LL {

    protected ListNode head = null;
    protected ListNode tail = null;
    protected int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }

        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertNodeLast(ListNode item) {
        if (tail == null) {
            head = item;
            tail = item;
            return;
        }

        tail.next = item;
        tail = item;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        ListNode temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        ListNode node = new ListNode(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private ListNode insertRec(int val, int index, ListNode node) {
        if (index == 0) {
            ListNode temp = new ListNode(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index - 1, node.next);
        return node;
    }

    public int deleteFirst() {
        int val = head.val;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        int val = tail.val;
        ListNode secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (size == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        ListNode prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public ListNode find(int value) {
        ListNode node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public ListNode get(int index) {
        ListNode node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // questions
    public void duplicates() {
        ListNode node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }

        tail = node;
        tail.next = null;
    }

    public void removeOdds() {
        ListNode node = head;
        ListNode prev = head;
        while (node != null) {
            if (isOdd(node) && node == head) {
                node = node.next;
                head = node;
                prev = node;
            } else if (isOdd(node)) {
                prev.next = node.next;
                node = node.next;
            } else {
                prev = node;
                node = node.next;
            }
        }
    }

    private boolean isOdd(ListNode node) {
        return node.val % 2 == 1;
    }

    public ListNode middleNode(ListNode node) {
        ListNode s = node;
        ListNode f = node;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    // merge
    public static LL merge(LL first, LL second) {
        ListNode f = first.head;
        ListNode s = second.head;
        LL ans = new LL();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }

        // add any remaining nodes into the list
        while (f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.val);
            s = s.next;
        }

        return ans;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            ListNode first = get(col);
            ListNode second = get(col + 1);

            if (first.val > second.val) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    ListNode prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        }
        bubbleSort(row - 1, 0);
    }

    // recursion reverse
    private void reverse (ListNode node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in place reversal of linked list
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next = current.next;

        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        return prev;
    }

    public ListNode reverseBetween(int left, int right) {
        if (left == right) {
            return head;
        }

        // Skip the first left - 1 nodes
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right
        ListNode next = current.next;
        for(int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode reverse = reverseList(mid);

        // compare both halves
        ListNode left = head;
        ListNode right = reverse;

        while (left != null && right != null) {
            if (left.val != right.val) {
                break;
            }
            left = left.next;
            right = right.next;
        }
        reverseList(reverse);

        return left == null || right == null;
    }

    // Reorder List
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid);
        ListNode hf = head;

        // rearrange
        while (hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // set next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }

    // reverse nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        int remainingNodes = listLength(head);

        while (remainingNodes >= k) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse
            ListNode next = current.next;
            for(int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            if (current == null) {
                break;
            }

            prev = newEnd;
            remainingNodes = remainingNodes - k;
        }

        return head;
    }

    private int listLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode temp = head;
        int length = 0;
        while(temp != null) {
            temp = temp.next;
            length = length + 1;
        }
        return length;
    }

    // reverse alternate nodes in k-Group
    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse
            ListNode next = current.next;
            for(int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            // skip k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }

        return head;
    }

    // rotate list
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        // get the current last node in list and set next ptr to head
        int length = listLength(head);
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = head;

        // calculate rotations and amount of nodes to skip
        int rotations = k % length;
        int skip = length - rotations;

        // get new last node after rotations, set head ptr, and set next ptr to null
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    public static void main(String[] args) {
        LL linkList = new LL();
        ListNode list = new ListNode(1, new ListNode(2));
        list.next.next = new ListNode(2, new ListNode(1));

        ListNode itr = list;
        while (itr != null) {
            linkList.insertLast(itr.val);
            itr = itr.next;
        }

        ListNode newList = linkList.rotateRight(list, 2);
        ListNode temp = newList;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");

//        System.out.println(linkList.isPalindrome(list));


//        LL first = new LL();
//        LL second = new LL();
//
//        first.insertLast(1);
//        first.insertLast(4);
//        first.insertLast(7);
//        first.insertLast(9);
//
//        second.insertLast(2);
//        second.insertLast(3);
//        second.insertLast(5);
//        second.insertLast(8);
//        second.insertLast(11);


//        merge(first,second).display();
//        LL list = new LL();
//        for (int i = 7; i > 0; i--) {
//            list.insertLast(i);
//        }
//        list.bubbleSort();
//        list.display();

//        ListNode nList = list.reverseList();
//        ListNode iter = nList;


//        while (iter != null) {
//            System.out.print(iter.val + " -> ");
//            iter = iter.next;
//        }
//        System.out.println("END");

    }
}
