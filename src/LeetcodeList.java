import java.util.*;

public class LeetcodeList {


    // Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                result[0] = myMap.get(nums[i]);
                result[1] = i;
                break;
            }
            myMap.put(target-nums[i], i); // store complement as key, index as value
        }
        return result;
    }

    // Longest Common Prefix
    // Write a function to find the longest common prefix string amongst an array of strings.
    // If there is no common prefix, return an empty string "".
    public String longestCommonPrefix(String[] strs) {
        try {
            if (strs.length > 200 || strs[0].length() > 200) {
                return "";
            }

            String s = strs[0];
            int min = strs[0].length();

            // find the smallest word
            for(int i = 1; i < strs.length; i++) {
                if (min > strs[i].length()) {
                    min = strs[i].length();
                    s = strs[i];
                }
            }

            // check if the letters of the smallest string are contained within all words
            StringBuilder prefix = new StringBuilder();
            boolean flag = true;
            for(int i = s.length(); i >= 0; i--) {
                s = s.substring(0, i);
                for(int j = 0; j < strs.length; j++) {
                    if(!strs[j].substring(0, i).contains(s)) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if(flag) {
                    prefix.append(s);
                    break;
                }
            }

            return prefix.toString();
        } catch(Exception e) {
            return "";
        }
    }

    // 3Sum
    // Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.
    // Notice that the solution set must not contain duplicate triplets.


    // Valid Parentheses
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    public boolean isValid(String s) {
        boolean res = false;
        // check if string parameter (s) has valid characters
        if ( (s.contains("()") || s.contains("[]") || s.contains("{}")) && s.length() % 2 == 0 ) {
            // Declare and initialize stack
            Stack<String> stk = new Stack<>();
            // split the string parameter s
            String[] str = s.split("");

            // loop through split string and push elements into the stack
            // if closing parenthesis( ')', ']', '}' ) is found pop the stack
            for(int i = 0; i < str.length; i++) {
                if ( (str[i].equals(")") || str[i].equals("]") || str[i].equals("}")) && !stk.isEmpty()) {
                    // test to see if the top of the stack is the same type of parenthesis
                    boolean flag = false;
                    switch(str[i]) {
                        case ")": flag = stk.peek().equals("("); break;
                        case "]": flag = stk.peek().equals("["); break;
                        case "}": flag = stk.peek().equals("{"); break;

                    }
                    if (flag) {
                        stk.pop();
                    }
                    // continue to avoid pushing the closing parenthesis into the stack
                    continue;
                }
                stk.push(str[i]);
            }
            // if stack is empty set the result to true
            if(stk.isEmpty()) {
                res = true;
            }
        }
        return res;
    }
}
