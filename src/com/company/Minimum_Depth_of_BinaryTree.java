package com.company;

public class Minimum_Depth_of_BinaryTree {
    int result = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        preorder(root, 1);

        return result;

    }

    public void preorder(TreeNode root, int depth)
    {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
        {
            if(depth < result)
            {
                result = depth;
            }
            return;
        }

        preorder(root.left, depth +1 );
        preorder(root.right, depth+1);
    }

    public int minDepth_2(TreeNode root) {
        if(root==null){return 0;}
        if(root.left==null){return minDepth(root.right) +1;}
        if(root.right==null){return minDepth(root.left)+1;}
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
