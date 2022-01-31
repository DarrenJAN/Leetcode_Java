package com.company;

public class Longest_Univalue_Path {
    int max= 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        univalue_dfs(root);
        return max;
    }

    public int univalue_dfs(TreeNode root)
    {
        if(root == null)
            return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;
        int left_res = univalue_dfs(left);
        int right_res = univalue_dfs(right);

        int arrow_left= 0, arrow_right = 0;
        if(left != null && left.val == root.val)
        {
            arrow_left = left_res +1;
        }

        if(right != null && right.val == root.val)
        {
            arrow_right = right_res +1;
        }

        max = Math.max(arrow_left + arrow_right, max);

        return Math.max(arrow_left, arrow_right);

    }
}
