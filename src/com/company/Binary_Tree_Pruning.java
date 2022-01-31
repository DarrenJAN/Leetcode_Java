package com.company;

public class Binary_Tree_Pruning {
    public TreeNode pruneTree(TreeNode root) {
        return pruneTree_helper(root);
    }


    public  TreeNode pruneTree_helper(TreeNode root)
    {
        if(root == null)
            return  null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null)
        {
            if(root.val != 1)
                return null;
            else
                return root;
        }

        return root;
    }
}
