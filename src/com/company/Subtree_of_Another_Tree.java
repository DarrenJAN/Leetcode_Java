package com.company;

public class Subtree_of_Another_Tree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        else if(root == null || subRoot == null)
            return false;

        if(dfs(root, subRoot))
            return true;
        else
            return isSubtree(root.left, subRoot ) || isSubtree(root.right, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null)
            return true;
        else if(root == null || subRoot == null)
            return false;
        else if(root.val != subRoot.val)
            return false;
        else
        {
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
    }
}
