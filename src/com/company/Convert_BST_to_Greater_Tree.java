package com.company;

import java.util.ArrayList;
import java.util.List;

public class Convert_BST_to_Greater_Tree {
    int pre_sum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root)
    {
        if(root == null)
            return;

        helper(root.right);
        root.val   += pre_sum;
        pre_sum = root.val;
        helper(root.left);

    }
}
