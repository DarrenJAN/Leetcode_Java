package com.company;

import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        post_helper(root, result);
        return result;

    }

    void post_helper(TreeNode root, List<Integer> result)
    {
        if(root != null)
        {
            post_helper(root.left, result);
            post_helper(root.right, result);
            result.add(root.val);
        }
    }
}
