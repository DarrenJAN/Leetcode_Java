package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_III {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, k, n, 1, new ArrayList<>());
        return result;
    }

    public void backtrack(int sum, int k, int n , int pos, List<Integer> path) {
        if (sum == n && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > n || path.size() > k)
            return;

        for (int i = pos; i <= 9; i++) {
            sum += i;
            path.add(i);

            backtrack(sum, k, n, i + 1, path);

            sum -= i;
            path.remove(path.size() - 1);
        }
    }

}
