package com.company;

public class Step_By_Step_Directions_q2096 {
    TreeNode LCA;
    StringBuilder curpath;

    boolean left = false;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        findLCA(root, startValue, destValue);

        StringBuilder result = new StringBuilder();

        backtrack(LCA, startValue, new StringBuilder());

        System.out.println(LCA.val + " " + curpath );
        for(int i = 0;i< curpath.length();i++)
        {
            result.append("U");
        }

        backtrack(root, destValue, new StringBuilder());
        result.append(curpath);

        return result.toString();
    }

    public boolean findLCA(TreeNode root, int startValue, int destvalue)
    {
        if(root == null)
            return false;

        int mid = 0;
        int left = 0;
        int right = 0;

        if(root.val == startValue || root.val == destvalue)
        {
            mid = 1;
        }

        left = findLCA(root.left, startValue, destvalue)? 1: 0;
        right = findLCA(root.right, startValue, destvalue) ? 1:0;

        if(left + right + mid >= 2)
            LCA = root;

        return left + right + mid >0;
    }

    public void backtrack(TreeNode root, int val, StringBuilder path)
    {
        if(root== null)
            return;

        if(root.val == val)
        {
            curpath = new StringBuilder(path);
            return;
        }

        backtrack(root.left, val, path.append("L"));
        path.deleteCharAt(path.length()-1);

        backtrack(root.right, val, path.append("R"));
        path.deleteCharAt(path.length()-1);


    }


}
