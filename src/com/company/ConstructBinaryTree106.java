package com.company;

import java.util.HashMap;

public class ConstructBinaryTree106 {
    int post_index;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.post_index = postorder.length-1;
        for(int i = 0;i< inorder.length;i++)
            hashMap.put(inorder[i], i);

        return helper(inorder, postorder, 0, postorder.length-1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start ,int end)
    {
        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(postorder[post_index--]);

        int rootval = postorder[post_index--];
        int mid = hashMap.get(rootval);
        
        TreeNode root = new TreeNode(rootval);
        root.right = helper(inorder, postorder, mid+1, end);
        root.left = helper(inorder, postorder, start, mid-1);
        return root;
    }
}
