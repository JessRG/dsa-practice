import java.util.Arrays;
import java.util.HashMap;

public class StringAlgorithms {

    // Implement strStr()
    // Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    // Clarification:
    // What should we return when needle is an empty string? This is a great question to ask during an interview.
    // For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // Write a function that reverses a string. The input string is given as an array of characters char[].
    // Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    // You may assume all the characters consist of printable ascii characters.
    public static void reverseString(char[] s) {
        int start = 0, end = s.length - 1;

        while(start < end) {
            // if start less than end swap characters
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }

    // First Unique Character in a String
    // Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
    public static int firstUniqChar(String s) {
        // index local variable to store the index of the unique character
        int idx = -1;
        // Declare a hashmap to help solve this problem
        HashMap<Character, Integer> hmap = new HashMap<>();

        // build hashmap by storing each character along with a count of that character within the string
        for(int i = 0; i < s.length();i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // loop through the string again to check if the character count is equal to 1 (unique)
        for(int i = 0; i < s.length();i++) {
            // check if character is unique
            if (hmap.get(s.charAt(i)) == 1) {
                // assign index of the current character then break the loop
                idx = i;
                break;
            }
        }
        // return local idx variable
        return idx;
    }
}
