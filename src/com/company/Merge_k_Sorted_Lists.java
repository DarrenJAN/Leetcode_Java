package com.company;

import java.util.List;

public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;
        if(k == 0)
            return null;
        ListNode head = lists[0];

        for(int i = 1; i< k;i++)
            head = merge2Lists(head, lists[i]);

        return head;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2)
    {
        ListNode new_head = new ListNode(-1);
        ListNode new_head_it = new_head;

        while(l1 != null && l2 != null)
        {
            if( l1.val < l2.val)
            {
                new_head_it.next  = l1;
                l1 = l1.next;
            }else
            {
                new_head_it.next = l2;
                l2 = l2.next;
            }
            new_head_it = new_head_it.next;
        }

        if (l1 != null)
        {
            new_head_it.next = l1;
        }

        if (l2 != null)
            new_head_it.next = l2;

        return new_head.next;
    }
}
