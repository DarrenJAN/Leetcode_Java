package com.company;

public class Trim_a_Binary_Search_Tree {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return root;
        else if(low <= root.val && root.val <= high)
        {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }else if(    root.val < low)
        {
            return trimBST(root.right, low, high);
        } else
            return trimBST(root.left, low, high);
    }
}
