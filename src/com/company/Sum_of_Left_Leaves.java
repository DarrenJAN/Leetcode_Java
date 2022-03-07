package com.company;

import javax.swing.event.ListDataListener;

public class Sum_of_Left_Leaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        goleft(root, false);
        return sum;
    }

    public void goleft(TreeNode root, boolean isLeft)
    {
        if(root == null)
        {
            return;
        }

        if(isLeft && root.left == null && root.right == null)
            sum += root.val;
        else
        {
            goleft(root.left, true);
            goleft(root.right, false);
        }


    }

}
