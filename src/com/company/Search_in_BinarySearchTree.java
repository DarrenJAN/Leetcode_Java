package com.company;

public class Search_in_BinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        else if(root.val == val)
            return root;
        else if(root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
}
