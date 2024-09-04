package com.jesse.arrays;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5};
//        arr = new int[] {1, 2};

//        for (List<Integer> list : findPermutations(arr)) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }

        for (List<Integer> list : generatePermutations(arr)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

//    public static List<List<Integer>> findPermutations(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        // TODO: Write your code here
//        List<Integer> up = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        permutations(new ArrayList<>(), up, result);
//
//        return result;
//    }
//
//    private static void permutations(List<Integer> p, List<Integer> up, List<List<Integer>> res) {
//        if (p.size() == up.size()) {
//            res.add(new ArrayList<>(p));
//        } else {
//            for (Integer num : up) {
//                if (!p.contains(num)) {
//                    p.add(num);
//                    permutations(p, up, res);
//                    p.remove(p.size() - 1);
//                }
//            }
//        }
//    }

    // BFS solution
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (int num : nums) {
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }

    // Recursive solution
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> permutation, List<List<Integer>> permutations) {
        if (index == nums.length) {
            permutations.add(permutation);
        } else {
            for (int i = 0; i <= permutation.size(); i++) {
                List<Integer> currentPermutation = new ArrayList<>(permutation);
                currentPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, currentPermutation, permutations);
            }
        }
    }
}
