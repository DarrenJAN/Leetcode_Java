package com.company;

import java.util.HashSet;

public class Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> hashSet  = new HashSet<>();
        ListNode head_it = head;
        if(head == null)
            return head;

        ListNode head_next_it = head.next;
        if(head_next_it == null)
            return head;

        while(head_it != null && head_next_it != null)
        {
            if(head_it.val == head_next_it.val )
            {
                hashSet.add(head_it.val);
                //System.out.println(head_it.val);
            }

            head_it = head_next_it;
            head_next_it = head_next_it.next;
        }

        ListNode pre = new ListNode(-1);
        ListNode new_head = pre;
        head_it = head;
        while(head_it != null)
        {
            if(hashSet.contains(head_it.val ))
            {
                pre.next =head_it.next;
                //System.out.println(head_it.val);
            }
            else
            {
                pre.next = head_it;
                pre = head_it;
            }

            head_it = head_it.next;
        }

        return new_head.next;
    }

    //
    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        ListNode pre = sentinel;

        if(head == null)
            return null;
        if(head.next == null)
            return head;

        while(head != null && head.next != null)
        {
            //System.out.println(head.val);
            if(head.val == head.next.val )
            {
                //System.out.println(head.val);
                int val = head.val;
                while(head != null && head.val == val)
                {
                    head = head.next;
                }
                pre.next = head;
            }else
            {
                pre.next = head;
                pre = head;
                head = head.next;

            }

        }
        return  sentinel.next;
    }
}
