package com.company;

public class Sum_Root_to_Leaf_Numbers {
    int result = 0;
    public int sumNumbers(TreeNode root) {
         backtrack(root, 0);
         return result;
    }

    public void backtrack(TreeNode root, int cur_num)
    {
        if(root == null)
            return;

        cur_num  = cur_num * 10 + root.val;
        if(root.left == null && root.right==  null)
        {
            result += cur_num;
            return;
        }

        backtrack(root.left, cur_num);
        backtrack(root.right, cur_num);
    }
}
