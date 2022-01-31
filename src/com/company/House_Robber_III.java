package com.company;

public class House_Robber_III {

    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode root)
    {
        if(root == null)
            return new int[] {0,0};

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        //if rob this node
        int rob = root.val + l[1] + r[1];

        //if not rob this node
        int norob  = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

        return new int[] {rob, norob};
    }

}
