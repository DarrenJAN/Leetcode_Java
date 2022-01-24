package com.company;

public class Lowest_CommonAncestor_of_BinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pval = p.val;
        int qval = q.val;


        if(p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q );
        else if( p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p,q);
        else
            return root;
    }
}
