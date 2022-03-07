package com.company;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Binary_Tree_II {
    private List<Integer> pre_order = new ArrayList<>();

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        setPre_order(root);
        pre_order.add(val);

        return construct(0, pre_order.size()-1);
    }

    public TreeNode construct(int start, int end)
    {
        if(start > end)
            return null;

        int index = max_index(start, end);
        TreeNode root = new TreeNode(pre_order.get(index));
        root.left = construct(start, index-1);
        root.right = construct(index+1, end);

        return root;

    }

    public int max_index(int start, int end )
    {
        int max_num = pre_order.get(start);
        int max_i = start;

        for(int i = start;i<=end;i++)
        {
            if(pre_order.get(i) > max_num)
            {
                max_num = pre_order.get(i);
                max_i = i;
            }
        }

        return max_i;
    }



    public void setPre_order(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        setPre_order(root.left);
        pre_order.add(root.val);
        setPre_order(root.right);
    }
}
