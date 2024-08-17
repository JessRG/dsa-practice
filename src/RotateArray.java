public class RotateArray {
    // Rotate Array
    // Given an array, rotate the array to the right by k steps, where k is non-negative.
    // Follow up:
    // Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    // Could you do it in-place with O(1) extra space?
    public static void rotate(int[] nums, int k) {
        // Set k to modulus of nums length to potentially reduce the total amount of rotations
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    // reverse method (rotate helper method) to perform a reverse operation with the given parameters
    public static void reverse(int[] arr,int start,int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Rotate Array (Extra Array)
    public void rotateExtraArray(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[(i + k) % nums.length] = nums[i];
        }
        // copy results from local array results into nums
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
