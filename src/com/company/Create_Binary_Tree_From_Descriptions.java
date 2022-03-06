package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Create_Binary_Tree_From_Descriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> real_root = new HashSet<>();
        HashSet<Integer> real_childs = new HashSet<>();


        HashMap<Integer, TreeNode> hashMap = new HashMap<>();
        for(int i =0;i< descriptions.length;i++)
        {
            int[] cur_tree_list = descriptions[i];
            int root_val = cur_tree_list[0];
            int child_val = cur_tree_list[1];

            if(!real_childs.contains(child_val))
                real_childs.add(child_val);
            if(!real_root.contains(root_val))
                real_root.add(root_val);

            if(real_childs.contains(root_val))
                real_root.remove(root_val);
            if(real_root.contains(child_val))
                real_root.remove(child_val);


            TreeNode root = hashMap.containsKey(root_val) == true ? hashMap.get(root_val): new TreeNode(root_val);
            TreeNode child  = hashMap.containsKey(child_val) ==  true? hashMap.get(child_val): new TreeNode(child_val);

            if(cur_tree_list[2] ==1)
            {
                root.left = child;
            }else
                root.right = child;

            hashMap.put(root_val,root);
            hashMap.put(child_val, child);

        }
        int result = 0;
        for(Integer root :real_root)
            result = root;
        return hashMap.get(result);
    }

}
