package com.company;

public class Delete_Leaves_With_a_Given_Value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)
            return null;
        else
        {
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if(root.val == target)
            {
                if(root.right == null && root.left == null)
                {
                    return null;
                }
            }

            return root;

        }

    }


}
