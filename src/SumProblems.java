import java.util.*;

public class SumProblems {

    // Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
    // For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    // Bonus: Can you do this in one pass?
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
    public static int[] twoSumReturnArray(int[] nums, int target) {
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

    // 3Sum
    // Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.
    // Notice that the solution set must not contain duplicate triplets.
    public static List<List<Integer>> threeSum(int[] nums) {
        // List of Lists to store each unique triplets in the array that gives the sum of zero
        List<List<Integer>> list = new LinkedList();

        // Sort the nums array
        Arrays.sort(nums);

        // Iterate through array of nums
        for(int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1]) ) {
                int low = i+1;
                int high = nums.length-1;
                int sum = 0 - nums[i];

                while(low < high) {
                    // if a set of triplets are found and to the list
                    if(nums[low] + nums[high] == sum) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return list;
    }
}
