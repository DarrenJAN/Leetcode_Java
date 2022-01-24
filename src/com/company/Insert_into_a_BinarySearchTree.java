package com.company;

public class Insert_into_a_BinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root ==null)
            return new TreeNode(val);

        TreeNode pre = root;
        TreeNode cur = root;
        while(cur != null)
        {
            pre = cur;
            if(cur.val < val)
            {
                cur= cur.right;
            }else
            {
                cur = cur.left;
            }
        }
        if(pre.val > val)
            pre.left = new TreeNode(val);
        else
            pre.right = new TreeNode(val);

        return root;
    }
}
