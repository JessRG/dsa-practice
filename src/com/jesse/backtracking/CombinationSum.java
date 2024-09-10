package com.jesse.backtracking;

import java.util.ArrayList;
import java.util.List;

// Given an array of distinct positive integers candidates and a target integer target,
// return a list of all unique combinations of candidates where the chosen numbers sum to target.
// You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
// frequency of at least one of the chosen numbers is different.
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;

        for (List<Integer> item : s.combinationSum(candidates, target)) {
            System.out.println(item.toString());
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // TODO: Write your code here
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }

            comb.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}
