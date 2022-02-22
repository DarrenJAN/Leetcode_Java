package com.company;

public class ConstructBinaryTree105 {
    int pre_index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int start, int end)
    {
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(preorder[pre_index++]);

        int rootval =preorder[pre_index++];

        TreeNode root = new TreeNode(rootval);
        int mid = 0;
        for(int i = start; i<= end;i++)
        {
            if(inorder[i] == rootval)
            {
                mid = i;
                break;
            }
        }

        root.left = helper(preorder, inorder, start, mid-1);
        root.right = helper(preorder, inorder, mid+1, end);
        return root;
    }
}
