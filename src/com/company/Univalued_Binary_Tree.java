package com.company;

import javax.swing.*;

public class Univalued_Binary_Tree {

    public boolean isUnivalTree(TreeNode root) {
        int value = root.val;
        return dfs(root, value);
    }

    public boolean dfs(TreeNode root, int val)
    {
        if(root == null)
            return true;

        if(root.val != val)
            return false;
        else
        {
            return dfs(root.left, val) && dfs(root.right, val);
        }
    }


}
