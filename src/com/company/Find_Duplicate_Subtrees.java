package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_Duplicate_Subtrees {
    private  List<TreeNode> result = new ArrayList<>();
    private HashMap<String, Integer> hashMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return result;
    }

    public String dfs(TreeNode root)
    {
        if(root == null)
            return null;

        String left = dfs(root.left);
        String right = dfs(root.right);
        String cur = root.val + ","+ left +","+ right;

        if(hashMap.getOrDefault(cur, 0) == 1)
            result.add(root);

        hashMap.put(cur, hashMap.getOrDefault(cur, 0)+1);
        return cur;
    }
}
