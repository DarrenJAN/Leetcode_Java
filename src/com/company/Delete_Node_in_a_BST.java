package com.company;

public class Delete_Node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete_helper(root, key);
    }

    public TreeNode next_small(TreeNode root)
    {
        TreeNode it = root.left ;
        while(it != null && it.right != null)
        {
            it = it.right;
        }
        return it;
    }

    public TreeNode next_large(TreeNode root)
    {
        TreeNode it = root.right ;
        while(it != null && it.left != null)
        {
            it = it.left;
        }
        return it;
    }
    public TreeNode delete_helper(TreeNode root, int key) {
        if(root == null)
            return null;

        if (root.val == key)
        {
            if(root.left == null && root.right == null)
                return null;
            else if(root.right != null)
            {
                TreeNode next = next_large(root);
                root.val = next.val;
                root.right = delete_helper(root.right, root.val);
                return root;
            }
            else
            {
                TreeNode next = next_small(root);
                root.val = next.val;
                root.left = delete_helper(root.left, root.val);
                return root;
            }
        }else if(root.val > key)
        {

            root.left =delete_helper(root.left, key);
            return root;
        } else
        {
            root.right = delete_helper(root.right, key);
            return root;
        }
    }
}
