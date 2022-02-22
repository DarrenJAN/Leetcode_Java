package com.company;

public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode new_head = new ListNode(-1);
        ListNode new_head_it = new_head;

        ListNode after_head = new ListNode(-1);
        ListNode after_head_it = after_head;

        while(head != null)
        {
            if( head.val < x)
            {
                new_head_it.next = head;
                new_head_it = new_head_it.next;
            }else
            {
                after_head_it.next = head;
                after_head_it = after_head_it.next;
            }
            head= head.next;
        }

        after_head_it.next =null;
        new_head_it.next = after_head.next;

        return new_head.next;
    }
}
