import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
//        System.out.println(Arrays.toString(twoSum(new int[] {3, 3}, 6)));

        System.out.println(longestCommonPrefix(new String[] { "flower","flow","flight" }));
        System.out.println(longestCommonPrefix(new String[] { "dog","racecar","car" }));
        System.out.println(longestCommonPrefix(new String[] { "hello","hell","helenor" }));
        System.out.println(longestCommonPrefix(new String[] { }));
        System.out.println(longestCommonPrefix(new String[] { "a" }));
    }

    // Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    public static int[] twoSum(int[] nums, int target) {
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
    public static String longestCommonPrefix(String[] strs) {
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
            for(int i = 0; i < s.length(); i++) {
                for(int j = 0; j < strs.length; j++) {
                    if(s.charAt(i) != strs[j].charAt(i) && i == 0) {
                        return "";
                    } else if(s.charAt(i) != strs[j].charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    prefix.append(s.charAt(i));
                }
            }

            return prefix.toString();
        } catch(Exception e) {
            return "";
        }
    }
}
