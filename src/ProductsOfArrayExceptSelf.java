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

        // second pass (iterate through arr parameter to build right array)

        // build the result array using both the left and right array

        return result;
    }
}
