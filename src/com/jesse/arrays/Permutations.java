package com.jesse.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5};
        arr = new int[] {1, 2};

        for (List<Integer> list : findPermutations(arr)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here
        List<Integer> up = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permutations(new ArrayList<>(), up, result);

        return result;
    }

    private static void permutations(List<Integer> p, List<Integer> up, List<List<Integer>> res) {
        if (p.size() == up.size()) {
            res.add(new ArrayList<>(p));
        } else {
            for (Integer num : up) {
                if (!p.contains(num)) {
                    p.add(num);
                    permutations(p, up, res);
                    p.remove(p.size() - 1);
                }
            }
        }
    }
}
