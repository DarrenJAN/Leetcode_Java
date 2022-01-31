package com.company;

public class Binary_Tree_Cameras {
    public enum Camera {COVERED, NOT_COVERED, HAS_CAMERA};
    int result = 0;

    public int minCameraCover(TreeNode root) {
        Camera root_state = dfs(root);
        if(root_state  == Camera.NOT_COVERED)
            result++;
        return result;
    }

    public Camera dfs(TreeNode root)
    {
        if(root == null)
            return Camera.COVERED;

        Camera l = dfs(root.left);
        Camera r = dfs(root.right);

        if(l == Camera.NOT_COVERED || r == Camera.NOT_COVERED)
        {
            result++;
            return Camera.HAS_CAMERA;
        }
        else if(l == Camera.HAS_CAMERA || r == Camera.HAS_CAMERA)
        {
            return Camera.COVERED;
        }else
            return Camera.NOT_COVERED;
    }
}
