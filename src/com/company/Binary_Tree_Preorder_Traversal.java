package com.company;

import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        pre_helper(root, result);
        return result;
    }

    void pre_helper(TreeNode root, List<Integer> result)
    {
        if(root != null)
        {
            result.add(root.val);
            pre_helper(root.left, result);
            pre_helper(root.right, result);
        }
    }
}
