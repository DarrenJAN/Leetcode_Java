package com.company;

public class Binary_Tree_Longest_Consecutive_Sequence {
    int result = 0;
    public int longestConsecutive(TreeNode root) {
        heloper(root, null, 1);
        return result;
    }

    public void heloper(TreeNode root, TreeNode parent, int length)
    {
        if( root == null)
            return;

        if(parent != null && root.val == parent.val+1)
        {
            length = length+1;
        }else
        {
            length = 1;
        }
        result = Math.max(result, length);

        heloper(root.left, root, length);
        heloper(root.right, root, length);
    }
}
