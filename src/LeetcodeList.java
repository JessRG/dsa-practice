import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LeetcodeList {

    // Declaring ArrayList object to help solve some problems

    private final Scanner scan;

    LeetcodeList() {
        scan = new Scanner(System.in);
    }

    // selectionSort method
    public int[] sortArray(int[] nums) {

        // loop through nums
        int idx = 0, smallest = -1;
        for(int i = 0; i < nums.length; i++) {
            idx = 0;
            smallest = nums[i];
            for(int j = i; j < nums.length; j++) {
                if(nums[j] < smallest) {
                    smallest = nums[j];
                    idx = j;
                }
            }
            if(smallest < nums[i]) {
                int temp = nums[i];
                nums[i] = smallest;
                nums[idx] = temp;
            }
        }
        return nums;
    }

    // bubbleSort method
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    swapped = true;
                }
            }
        } while (swapped == true);

        System.out.println(Arrays.toString(nums));
    }

    // Count and Say
    // The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
    // countAndSay(1) = "1"
    // countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a
    // different digit string. To determine how you "say" a digit string, split it into the minimal number of groups so
    // that each group is a contiguous section all of the same character. Then for each group, say the number of
    // characters, then say the character. To convert the saying into a digit string, replace the counts with a number
    // and concatenate every saying.
    public String countAndSay(int n) {
        if(n < 0) return "";

        String s = "1";
        while(n > 1) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < s.length(); ++i) {
                int count = 1;
                while(i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    ++count;
                    ++i;
                }
                result.append(count).append(s.charAt(i));
            }
            s = result.toString();
            --n;
        }
        return s;
    }

    // Plus One
    // Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
    // The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
    // You may assume the integer does not contain any leading zero, except the number 0 itself.
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNum = new int[n+1];
        newNum[0] = 1;
        return newNum;
    }

    // Sqrt(x)
    // Given a non-negative integer x, compute and return the square root of x.
    // Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
    public int mySqrt(int x) {
        /** Math class square root method */
        // return (int) Math.sqrt((double) x);

        /** Binary Search Solution */
        int low = 1;
        int high = x;

        while(low <= high) {
            // calculate the mid value
            long mid = low + (high - low) / 2;
//            System.out.println(mid);

            // check if mid is the square root
            if(mid * mid == x) {
                return (int) mid;
            } else if(mid * mid > x) {
                // if mid squared is greater set high equal to mid value minus 1
                high = (int) mid-1;
            } else {
                // if mid squared is less than set low equal to mid value plus 1
                low = (int) mid+1;
            }
        }
        return high;
    }

    // Majority Element
    // Given an array nums of size n, return the majority element.
    // The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
    public int majorityElement(int[] nums) {
        // write the logic for the solution here...
        return 0;
    }

    // Excel Sheet Column Number
    // Given a column title as appear in an Excel sheet, return its corresponding column number.
    public int titleToNumber(String s) {
        // write the logic of solution here...
        int sum = 0;
        return sum;
    }

    // Factorial Trailing Zeroes
    // Given an integer n, return the number of trailing zeroes in n!.
    // Follow up: Could you write a solution that works in logarithmic time complexity?
    public int trailingZeroes(int n) {
        // write solution here...
        return 0;
    }
}

