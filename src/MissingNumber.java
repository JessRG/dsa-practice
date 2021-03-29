public class MissingNumber {

    // Missing Number
    // Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
    // Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
    public static int missingNumber(int[] nums) {

        /** My First Solution */
//        // store the length of the nums array
//        int n = nums.length;
//        int missingNumber = nums[0];
//
//        // use a hashset to store all the values of nums
//        Set<Integer> set = new HashSet<>();
//        for(Integer elem:nums) {
//            set.add(elem);
//        }
//
//        // iterate to find the value that is missing
//        for(int i = 0; i <= n; i++) {
//            if (!set.contains(i)) {
//                missingNumber = i;
//                break;
//            }
//        }
//        return missingNumber;

        /** Cyclic Sort solution (can be used to solve a few other problems) */
        // store the length of nums array
        int n = nums.length;
        int i = 0;
        while(i < n) {
            // check if current element is not equal to its index position and is less than nums length
            if(nums[i] != i && nums[i] < n) {
                // store the current element value (index position in array where it should be)
                int j = nums[i];
                // swap current element value with whatever element value is at position j
                swap(nums, i, j);
            } else {
                // pre-increment i if current element value is equal to the index position
                ++i;
            }
        }
        // check array to find the missing value
        for(int j = 0; j < n; j++){
            if(nums[j] != j){
                return j;
            }
        }
        // if for loop completes return the nums array length
        return n;

        /** Improved Solution */
//        int n = nums.length;
//        // store the series equation (closed formula) or the formula for sum of consecutive numbers
//        // use this to help find the missing number
//        int totalSum = n * (n + 1) / 2;
//        // accumulator to store the sum of the nums array
//        int actualSum = 0;
//
//        // iterate through nums array and calculate the sum
//        for(int i = 0; i < n; i++) {
//            // calculate the sum of nums array
//            actualSum += nums[i];
//        }
//
//        // check if formula result is not equal to the sum of nums (if they are equal return 0)
//        if(totalSum != actualSum) {
//            // return the difference between the formula result and sum of nums (the missing number)
//            return Math.abs(totalSum - actualSum);
//        } else {
//            return 0;
//        }
    }

    // swap function to swap two element values within an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
