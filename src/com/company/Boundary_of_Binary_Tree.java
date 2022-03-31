package com.company;

import java.util.ArrayList;
import java.util.List;

public class Boundary_of_Binary_Tree {
    List<Integer> result = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return result;
        result.add(root.val);
        addLeft(root.left, true);
        addRight(root.right , true);

        return result;
    }

    public void addLeft(TreeNode root, boolean isBoundary)
    {
        if(root == null)
        {
            return;
        }
        boolean isLeaf = root.left == null &&  root.right == null;
        if(isBoundary || isLeaf)
        {
            result.add(root.val);
        }

        if(!isLeaf)
        {
            addLeft(root.left, isBoundary);
            addLeft(root.right, isBoundary && root.left == null);
        }
    }

    public void addRight(TreeNode root, boolean isBoundary)
    {
        if(root == null)
            return;

        boolean isLeaf = root.left == null && root.right == null;
        if(!isLeaf)
        {
            addRight(root.left, isBoundary && root.right ==null);
            addRight(root.right, isBoundary);
        }

        if(isBoundary || isLeaf)
            result.add(root.val);
    }
}
