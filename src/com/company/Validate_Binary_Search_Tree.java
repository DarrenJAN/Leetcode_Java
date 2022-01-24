package com.company;

public class Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return  isValidBST_helper(root, null, null);
    }

    public boolean isValidBST_helper(TreeNode root, Integer low, Integer high)
    {
        if(root == null)
            return true;

        if( (low != null && root.val <= low) || (high != null && root.val >= high))
        {
            return false;
        }else
            return isValidBST_helper(root.left, low, root.val) && isValidBST_helper(root.right, root.val, high);
    }
}
