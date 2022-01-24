package com.company;

import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        inorder_helper(root, result);
        return result;
    }

    void inorder_helper(TreeNode root, List<Integer> result)
    {
        if(root != null)
        {
            inorder_helper(root.left, result);
            result.add(root.val);
            inorder_helper(root.right, result);
        }
    }

}
