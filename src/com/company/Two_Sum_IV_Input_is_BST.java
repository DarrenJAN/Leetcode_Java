package com.company;

import java.util.LinkedList;
import java.util.List;

public class Two_Sum_IV_Input_is_BST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer>  list = new LinkedList<>();
        in_order(root, list);

        int l = 0;
        int r = list.size()-1;

        while(l < r)
        {
            int sum = list.get(l) + list.get(r);
            if(sum == k)
                return true;
            else if(sum < k)
                l++;
            else
                r--;
        }
        return false;

    }

    public void in_order(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return;
        else
        {
            in_order(root.left, list);
            list.add(root.val);
            in_order(root.right, list);
        }

    }
}
