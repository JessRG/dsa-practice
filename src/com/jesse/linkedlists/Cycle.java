package com.jesse.linkedlists;

public class Cycle extends LL {
//    private class ListNode {
//        private int val;
//        private ListNode next;
//        private ListNode prev;
//
//        private ListNode(int val) {
//            this.val = val;
//        }
//
//        private ListNode(int val, ListNode prev, ListNode next) {
//            this.val = val;
//            this.next = next;
//            this.prev = prev;
//        }
//    }
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.insertLast(6);
        list.insertLast(7);
//        Node four = new Node(4);
//        Node cycle = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, four))));
//        four.setNext(cycle);
//        list.insertNodeLast(four);

//        System.out.println(hasCycle(list.getLL()));
//        System.out.println(lengthCycle(list.getLL()));
//        System.out.println(detectCycle(list.getLL()).getValue());
        System.out.println(list.middleNode(list.head).val);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        boolean stopFast = false;

//        while (fast != null && fast.getNext() != null) {
//            slow = slow.getNext();
//            fast = fast.getNext().getNext();
//
//            if (fast == slow) {
//                ListNode temp = slow;
//                do {
//                    length++;
//                    temp = temp.getNext();
//                } while (temp != fast);
//                return length;
//            }
//        }
//
//        return 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            if (!stopFast) {
                fast = fast.next.next;
            } else {
                length++;
            }

            if (fast == slow) {
                if (length > 0) {
                    break;
                }
                stopFast = true;
            }
        }

        return length;
    }

    public static ListNode detectCycle (ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        // find the start
        ListNode s= head;
        ListNode f = head;
        while (length > 0) {
            s = s.next;
            length--;
        }

        while (s != f) {
            s = s.next;
            f = f.next;
        }

        return s;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (fast != slow);

        if (slow == 1) {
            return true;
        }

        return false;
    }

    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
           int rem = number % 10;
           ans += rem * rem;
           number /= 10;
        }

        return ans;
    }

    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

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
}
