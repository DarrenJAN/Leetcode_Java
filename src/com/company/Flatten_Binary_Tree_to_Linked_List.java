package com.company;

public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
         helper(root);
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        helper(root.right);

        TreeNode l = root.left;
        TreeNode r = root.right;

        if(l != null)
        {
            root.right = l;
            root.left = null;
            while(l.right != null)
            {
                l = l.right;
            }

            l.right = r;
        }
    }
}
