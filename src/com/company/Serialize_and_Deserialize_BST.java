package com.company;

public class Serialize_and_Deserialize_BST {
    /////////////////////////////////////////没写出来！！！！！！！！！！
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        pre_order(root, stringBuilder);
        return stringBuilder.toString();
    }

    public void pre_order(TreeNode root, StringBuilder stringBuilder)
    {
        if(root == null)
            return;

        stringBuilder.append(root.val + " ");
        pre_order(root.left, stringBuilder);
        pre_order(root.right, stringBuilder);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] chars = data.split(" ");
        return des_helper(chars, 0, chars.length-1);
    }

    public TreeNode des_helper(String[] chars, int left, int right)
    {
        if( left > right)
            return null;
        else
        {
            int root_val = Integer.parseInt(chars[left]);
            TreeNode root = new TreeNode(root_val);
            int new_left = right +1;
            for(int i = left+1; i<=right;i++)
            {
                if(Integer.parseInt(chars[i])- '0' > root_val)
                    new_left  = i;
            }
            root.left = des_helper(chars, left+1, new_left -1);
            root.right = des_helper(chars, new_left , right);
            return root;
        }
    }
}
