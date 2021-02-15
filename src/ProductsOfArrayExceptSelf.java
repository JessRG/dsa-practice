import java.util.Arrays;

public class ProductsOfArrayExceptSelf {

    // Given an array of integers, return a new array such that each element at index i of the new array is
    // the product of all the numbers in the original array except the one at i.
    // For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
    // If our input was [3, 2, 1], the expected output would be [2, 3, 6].
    // Follow-up: what if you can't use division?
    public int[] productExceptSelf(int[] arr) {
        // create new array to store the products
        int[] result = new int[arr.length];

        // declare left and right arrays
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        // first pass (iterate through arr parameter to build left array first)
        // set first element of left array equal to 1
        left[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            // calculate the product to the left of the i (current index in arr)
            left[i] = left[i-1] * arr[i-1];
        }

        // second pass (iterate through arr parameter to build right array)
        // set last element of right array equal to 1
        right[right.length - 1] = 1;
        for(int i = arr.length - 2; i >= 0; i--) {
            // calculate the product to the right of the i (current index in arr)
            right[i] = right[i+1] * arr[i+1];
        }

        // build the result array using both the left and right array
        for(int i = 0; i < arr.length; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
