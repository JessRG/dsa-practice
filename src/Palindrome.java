public class Palindrome {

    // Valid Palindrome
    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        // store lowercase string s after replacing all special characters and spaces
        String str = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        // append the modified s string into the StringBuilder to take advantage of reverse method
        sb.append(str);

        // return true or false if the strings are/are not equal
        return sb.reverse().toString().equals(str);
    }
}
