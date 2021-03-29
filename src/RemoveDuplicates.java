public class RemoveDuplicates {

    // Remove Duplicates from Sorted Array
    // Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
    // Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    public static int removeDuplicates(int[] nums) {
//        // Declare a hashset will use this to get rid of duplicates from the array nums
//        Set<Integer> set = new HashSet<>();
//
//        // loop through nums array and store each element into the hashset (autoboxing happens here)
//        for(int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//
//        // loop through hashset to store the values into an ArrayList
//        Iterator it = set.iterator();
//        ArrayList<Integer> unique = new ArrayList<>();
//        while(it.hasNext()) {
//            unique.add(Integer.parseInt(it.next().toString()));
//        }
//        // sort the unique list of values
//        Collections.sort(unique);
//
//        // now store into the front of nums array
//        for(int i = 0; i < unique.size(); i++) {
//            nums[i] = unique.get(i);
//        }
//
//        return unique.size();

        // Improved solution
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
