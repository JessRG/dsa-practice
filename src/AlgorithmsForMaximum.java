public class AlgorithmsForMaximum {

    // Maximum Subarray
    // Given an integer array nums, find the contiguous subarray (containing at least one number) which has
    // the largest sum and return its sum.
    // Follow up: If you have figured out the O(n) solution, try coding another solution using the divide
    // and conquer approach, which is more subtle.
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return -1;

        // Declare maxSum to store the maximum subarray sum
        int maxSum = nums[0];
        // Declare currentSum to help store the current maximum contiguous subarray sum
        // throughout the iteration process
        int currentSum = maxSum;

        // iterate through nums array and determine the max contiguous subarray sum
        for(int i = 1; i < nums.length; i++) {
            // calculate the current max sum between the most recent contiguous subarray max and current element value
            currentSum = Math.max(currentSum + nums[i], nums[i]);

            // check if the currentSum is greater than maxSum (most recently calculated max)
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    // Maximum Product Subarray
    // Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
    // which has the largest product.
    public static int maxProduct(int[] nums) {

        // handle edge case if nums parameter is empty
        if(nums.length == 0) return -1;

        // Declare three variables
        // currentMax to help keep track of the max product
        int currentMax = nums[0];
        // currentMin to help keep track of the product of negative values
        int currentMin = nums[0];
        // maxProduct to store the highest contiguous product
        int maxProduct = nums[0];

        for(int i = 1; i < nums.length; i++) {
            // Assign a temp variable to the currentMax to be used for minimum calculation
            int temp = currentMax;

            // Set the current max product between currentMax * current element, currentMin * current element
            // or current element (will continue contiguous subarray or begin a new subarray)
            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);

            // assign the most minimum product to help account for the product of negative numbers with currentMax
            currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);

            // Set the maxProduct to the maximum contiguous subarray value
            if(currentMax > maxProduct) {
                maxProduct = currentMax;
            }
        }

        return maxProduct;
    }
}
