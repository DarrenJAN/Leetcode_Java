package com.company;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtrack(root, "");
        return  result;
    }

    void backtrack(TreeNode root, String str)
    {
        if(root == null)
            return;

        str += ("->" +root.val);
        if(root.left == null && root.right == null)
        {
            result.add(new String(str.substring(2)));
            str.substring(0, str.length() -3 );
            return;
        }

        backtrack(root.left, str);
        backtrack(root.right, str);
        str.substring(0, str.length() -3 );
    }
}
