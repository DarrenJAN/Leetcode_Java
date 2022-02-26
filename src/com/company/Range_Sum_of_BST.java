package com.company;

public class Range_Sum_of_BST {
    int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return result;
    }

    public void dfs(TreeNode root, int low, int high)
    {
        if(root == null)
            return;

        if( root.val >= low && root.val <= high)
        {
            result += root.val;
            dfs(root.left, low, high);
            dfs(root.right, low, high);
        }else if(root.val < low)
        {
            dfs(root.right, low, high);
        }else
        {
            dfs(root.left, low, high);
        }

    }
}
