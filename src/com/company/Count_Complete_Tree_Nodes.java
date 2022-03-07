package com.company;

public class Count_Complete_Tree_Nodes {
    int sum = 0;
    public int countNodes(TreeNode root) {
        if(root != null)
            return 0;

        return 1+ countNodes(root.left) + countNodes(root.right);

    }
}
