package com.company;

public class Kth_Smallest_Element_in_a_BST {
    int reuslt = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return reuslt;
    }

    public void dfs(TreeNode root, int k)
    {
        if(root == null)
            return;

        dfs(root.left,k);
        count ++;
        if(count ==k) {
            reuslt = root.val;
            return;
        }

        dfs(root.right,k);
    }
}
