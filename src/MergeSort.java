import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {

    // mergeSort method
    // Added this method to practice with using mergeSort
    public static int[] mergeSort(int[] nums) {
        int n = nums.length;
        int[] left;
        int[] right;

        // determine size of left and right array by number of array elements
        if(n < 2) {
            return nums;
        } else if(n % 2 == 0) {
            left = new int[n/2];
            right = new int[n/2];
        } else {
            left = new int[n/2];
            right = new int[n/2+1];
        }

        // fill in both the left and right arrays
        for(int i = 0; i < n; i++) {
            if(i < n/2) {
                left[i] = nums[i];
            } else {
                right[i - n/2] = nums[i];
            }
        }

        // recursively split and merge left and right arrays
        left = mergeSort(left);
        right = mergeSort(right);

        // merge subarrays
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        // declare result array which is the size of left and right together
        int [] res = new int[left.length + right.length];

        int leftIdx = 0;
        int rightIdx = 0;
        int idx = 0;
        // traverse through both left and right arrays and check which
        // elements should be set to the front of the result array
        while(leftIdx < left.length && rightIdx < right.length) {
            if(left[leftIdx] < right[rightIdx]) {
                res[idx++] = left[leftIdx++];
            } else {
                res[idx++] = right[rightIdx++];
            }
        }

        // add leftover elements from left
        while(leftIdx < left.length) {
            res[idx++] = left[leftIdx++];
        }

        // add leftover elements from right
        while(rightIdx < right.length) {
            res[idx++] = right[rightIdx++];
        }

        return res;
    }

    // Merge Sorted Array
    // Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    // Note:
    // The number of elements initialized in nums1 and nums2 are m and n respectively.
    // You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Declare ArrayList to store the elements of both nums1 and nums2
        ArrayList<Integer> al = new ArrayList<>();

        // Declare int j as an index to iterate through both nums1 and nums2
        int j = 0;

        // Add elements from both nums1 and nums2 into the ArrayList
        for(int i = 0; i < m+n; i++) {
            // Add element from nums1 into ArrayList if i is less than m
            if(i < m) {
                al.add(nums1[j]);
            }
            // set j back to 0 if i is exactly equal to m, then add the first element from nums2
            else if (i == m) {
                j = 0;
                al.add(nums2[j]);
            }
            // add elements from nums2 into ArrayList
            else {
                al.add(nums2[j]);
            }
            // increment j
            j++;
        }

        // sort ArrayList al
        Collections.sort(al);

        // assign j back to 0 (used as an iterator for nums1 in enhanced for loop)
        j = 0;
        // loop through ArrayList and re-assign the sorted list of integers to nums1
        for(int elem : al) {
            nums1[j++] = elem;
        }
    }

    // Merge Two Sorted Lists
    // Merge two sorted linked lists and return it as a new sorted list.
    // The new list should be made by splicing together the nodes of the first two lists.
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // create a new head to store a reference to the new list
        ListNode head = new ListNode(-1);
        // declare reference to new head node which will help splice the two lists together
        ListNode splicer = head;

        // loop to traverse through and compare the node values of the two sorted linked lists
        while(l1 != null && l2 != null) {
            // check if list 1's node value is less than or equal to list 2's node value
            if(l1.val <= l2.val) {
                // if list 1's node value is less, then set splicer.next reference to list 1's node
                splicer.next = l1;
                // set list 1's node to reference the subsequent node
                l1 = l1.next;
            } else {
                // if list 2's node value is less, then set splicer.next reference to list 2's node
                splicer.next = l2;
                // set list 2's node to reference the subsequent node
                l2 = l2.next;
            }
            // set splicer to the new subsequent node
            splicer = splicer.next;
        }

        // check if either l1 or l2 is equal to null
        if(l1 != null) {
            splicer.next = l1;
        } else {
            splicer.next = l2;
        }

        // return the of the new list
        return head.next;
    }
}
