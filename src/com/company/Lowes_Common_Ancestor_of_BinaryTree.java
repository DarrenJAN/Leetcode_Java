package com.company;

public class Lowes_Common_Ancestor_of_BinaryTree {
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor_helper(root, p, q);
        return result;

    }

    public boolean lowestCommonAncestor_helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;

        int mid = 0;
        if(root.val == p.val || root.val == q.val)
            mid = 1;
        else
            mid = 0;

        int left = lowestCommonAncestor_helper(root.left, p, q) ? 1 : 0;
        int right = lowestCommonAncestor_helper(root.right, p, q) ? 1 : 0;

        if(mid + left + right >= 2)
        {
            result = root;
        }

        return mid + left + right > 0;



    }
}
