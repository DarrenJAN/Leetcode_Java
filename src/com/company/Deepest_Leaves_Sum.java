package com.company;

public class Deepest_Leaves_Sum {
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int dep = depth(root);

        //System.out.println(dep);

        sum_helper(root, dep, 1);
        return sum;
    }

    public int depth(TreeNode root)
    {
        if(root == null)
            return 0;
        else
            return 1+ Math.max(depth(root.left), depth(root.right));

    }

    public void sum_helper(TreeNode root, int depth, int cur_depth)
    {
        if(root == null)
            return;

        if(cur_depth == depth)
        {
            sum += root.val;
            return;
        }

        sum_helper(root.left, depth, cur_depth+1);
        sum_helper(root.right, depth, cur_depth+1);

    }


}
