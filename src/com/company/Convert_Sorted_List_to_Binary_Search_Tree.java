package com.company;

import java.util.ArrayList;
import java.util.List;

public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = list.size()-1;

        return buildTree(list, l, r);
    }

    public TreeNode buildTree(List<Integer> list, int l , int r)
    {
        if(l == r)
            return new TreeNode(list.get(l));
        if(l > r)
            return null;

        int mid = (r - l) /2 + l;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, l, mid -1);
        root.right = buildTree(list,mid+1, r);
        return root;
    }
}
