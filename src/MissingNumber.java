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
        int n = 0;
        while(n < nums.length) {
            int correct = nums[n];
            if(nums[n] != nums[correct]) {
                swap(nums, n, correct);
            } else {
                n++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        System.out.println(nums.toString());
        return nums.length;

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

    public int firstMissingPositive(int[] nums) {
        int n = 0;

        while(n < nums.length) {
            int correctIdx = nums[n] - 1;
            if (nums[n] > 0 && nums[n] <= nums.length && nums[n] != nums[correctIdx]) {
                swap(nums, n, correctIdx);
            } else {
                n++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    // swap function to swap two element values within an array
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }
}
