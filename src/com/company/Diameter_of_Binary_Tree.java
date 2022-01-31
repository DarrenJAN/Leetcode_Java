package com.company;

public class Diameter_of_Binary_Tree {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return max;
    }

    public int recursion(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = recursion(root.left);
        int right = recursion(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;

    }
}
