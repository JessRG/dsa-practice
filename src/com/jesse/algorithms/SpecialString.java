package com.jesse.algorithms;

public class SpecialString {
//    Developers at Amazon are working on a text generation utility for one of their new products.
//    Currently, the utility generates only special strings. A string is special if there are no matching adjacent characters. Given a string s of length n, generate a special string of length n that is lexicographically greater than s. If multiple such special strings are possible, then return the lexicographically smallest string among them.
//
//    Notes:
//
//    Special String: A string is special if there are no two adjacent characters that are the same.
//    Lexicographical Order: This is a generalization of the way words are alphabetically ordered in dictionaries. For example, "abc" is lexicographically smaller than "abd" because 'c' comes before 'd' in the alphabet.
//    A string a is lexicographically smaller than a string b if and only if one of the following conditions holds:
//
//    a is a prefix of b, but is not equal to b.
//    In the first position where a and b differ, the character in a comes before the character in b in the alphabet. For example, "abc" is smaller than "abd" because 'c' comes before 'd'.
//    Important Considerations:
//
//    If the character is 'z', it is the last character in the alphabet and cannot be increased further. The string should not wrap around to 'a after 'z'
//    The output string must not have any adjacent characters that are the saem.
//            Function Description
//
//    Complete the function getSpecialString in the editor below.
//
//    getSpecialString has the following parameter:
//
//    s: the input string
//            Returns
//
//    string: the lexicographically smallest string that is greater than s. If no such special string exists, return "-1".
    public static void main(String[] args) {
        String str = "abbc";
        System.out.println(getSpecialString(str));
    }

    public static String getSpecialString(String s) {
        // write your code here
        return "";
    }
}
