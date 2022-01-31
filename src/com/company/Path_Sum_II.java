package com.company;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backtrack(root, 0, targetSum, new ArrayList<>());
        return result;
    }

    public void backtrack(TreeNode root, int cur_sum, int targetsum, List<Integer> path)
    {
        if(root == null)
            return;

        path.add(root.val);
        cur_sum = root.val + cur_sum;

        if(root.left == null && root.right == null)
        {
            if( cur_sum== targetsum)
                result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        backtrack(root.left, cur_sum, targetsum, path);
        backtrack(root.right, cur_sum, targetsum, path);
        path.remove(path.size()-1);


    }
}
