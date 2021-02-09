public class RotateArray {
    // Rotate Array
    // Given an array, rotate the array to the right by k steps, where k is non-negative.
    // Follow up:
    // Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    // Could you do it in-place with O(1) extra space?
    public void rotate(int[] nums, int k) {
        // Set k to modulus of nums length to potentially reduce the total amount of rotations
        k %= nums.length;

        // reverse nums array
        reverse(nums, 0, nums.length - 1);
        // reverse values from beginning of nums up to k (noninclusive)
        reverse(nums, 0, k - 1);
        // reverse values from k until the end of the nums array
        reverse(nums, k, nums.length - 1);
    }
    // reverse method (rotate helper method) to perform a reverse operation with the given parameters
    public void reverse(int[] arr,int start,int end) {
        // loop swap the start and end (indices in arr)
        while(start < end) {
            // temp local variable to store element at start index
            // swap the elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // increment start/decrement end
            start++;
            end--;
        }
    }

    // Rotate Array (Extra Array)
    public void rotateExtraArray(int[] nums, int k) {
        // Declare a new local array of size nums array length to store the rotated result of nums
        int[] res = new int[nums.length];
        // iterate through nums and store it's element values into result array
        for (int i = 0; i < nums.length; i++) {
            // use modulus operator to handle proper element value placement (appropriate index)
            res[(i + k) % nums.length] = nums[i];
        }
        // copy results from local array results into nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
