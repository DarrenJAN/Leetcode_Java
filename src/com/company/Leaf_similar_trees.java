package com.company;

import java.util.ArrayList;
import java.util.List;

public class Leaf_similar_trees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        getleaf(root1, r1);
        getleaf(root2, r2);


        //return r1.equals(r2);
        if(r1.size() != r2.size())
            return false;

        for(int i =0;i<r1.size();i++)
        {
            if(r1.get(i) != r2.get(i))
                return false;
        }

        return true;

    }

    public void getleaf(TreeNode root, List<Integer> r)
    {
        if(root == null)
        {
            return;
        } else if(root.left == null && root.right == null)
        {
            r.add(root.val);
        }

        getleaf(root.left, r);
        getleaf(root.right, r);
    }
}
