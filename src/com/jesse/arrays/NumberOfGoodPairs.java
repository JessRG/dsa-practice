package com.jesse.arrays;

import java.util.HashMap;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
//        int[] nums = new int[] {1,2,3,1,1,3};
//        int[] nums = new int[] {1,1,1,1};
        int[] nums = new int[] {1,2,3};
        System.out.println(numGoodPairs(nums));
    }

    public static int numGoodPairs(int[] nums) {
        int pairCount = 0;
        // TODO: Write your code here
        int r = 2;
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int n : nums) {
            fmap.put(n, fmap.getOrDefault(n, 0) + 1);
        }

        for (Integer key : fmap.keySet()) {
            int n = fmap.get(key);
            if (n > 1) {
                int nfact = 1;
                for (int i = 1; i <= n; ++i) {
                    nfact *= i;
                }

                int nrfact = 1;
                for (int i = 1; i <= (n - r == 0 ? 1 : n - r); ++i) {
                    nrfact *= i;
                }
                pairCount += nfact / (r * nrfact);
            }
        }
        return pairCount;
    }
}
