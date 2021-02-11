import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {

//    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//    Bonus: Can you do this in one pass?
    public static boolean twoSum(int[] array, int k) {
        // declare and initialize boolean result variable
        boolean result = false;

        // check if array length is zero, return false if condition is true
        if(array.length == 0) {
            return result;
        }

        // create a hashset to help find if two values in the array add up to k parameter
        Set<Integer> hset = new HashSet<>();

        // iterate through array of numbers
        for(int elem : array) {
            // check if the current element (elem) value is contained within the hashset
            if(hset.contains(elem)) {
                result = true;
                break;
            }

            // add result of k - current element (elem)
            hset.add(k - elem);
        }
        return result;
    }

    // Two Sum
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // You can return the answer in any order.
    public int[] twoSumReturnArray(int[] nums, int target) {
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
}
