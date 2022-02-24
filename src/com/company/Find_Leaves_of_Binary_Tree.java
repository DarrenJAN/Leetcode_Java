package com.company;

import java.util.ArrayList;
import java.util.List;

public class Find_Leaves_of_Binary_Tree {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        getheight(root);
        return result;
    }

    public int getheight(TreeNode root)
    {
        if(root == null)
            return -1;

        int left = getheight(root.left);
        int right = getheight(root.right);

        int cur = Math.max(left, right) +1;
        if(cur == result.size())
        {
            result.add(new ArrayList<>());
        }

        result.get(cur).add(root.val);
        return cur;
    }
}
