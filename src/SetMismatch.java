public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        // Sort the nums array (cyclic sort)
        int n = 0;
        while (n < nums.length) {
            int correctIdx = nums[n] - 1;
            if (nums[n] < nums.length  && nums[n] != nums[correctIdx]) {
                swap(nums, n, correctIdx);
            } else {
                n++;
            }
        }

        // Find the set of numbers that are mismatched in the nums array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return new int[] { nums[i], i+1 };
            }
        }

        return new int[] {};
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
