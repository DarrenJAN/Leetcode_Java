package com.company;

public class Symmetric_Tree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSymmetric_helper(root.left, root.right);

    }

    public boolean isSymmetric_helper(TreeNode left, TreeNode right)
    {
        if(left != null && right != null)
        {
            if(left.val != right.val)
                return false;
            else
                return isSymmetric_helper(left.left, right.right) && isSymmetric_helper(left.right, right.left);
        } else if( left == null && right == null)
            return true;
        else
            return false;
    }
}
