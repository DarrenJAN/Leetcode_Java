package com.company;

public class Cousins_in_Binary_Tree {
    TreeNode xParent;
    TreeNode yParent;
    int xDepth;
    int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;

        findnode(root, x,y, 0, null);

        return xDepth == yDepth && xParent != yParent;
    }

    public void findnode(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        if(root == null)
            return;

        if(root.val == x) {
            xParent = parent;
            xDepth = depth;
            return;
        } else if(root.val == y) {
            yParent = parent;
            yDepth = depth;
            return;
        } else {
            findnode(root.left, x, y, depth + 1, root);
            findnode(root.right, x, y, depth + 1, root);
        }


    }
}
