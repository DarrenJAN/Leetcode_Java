package com.company;

public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode cur =head;
        while(cur != null && cur.next != null)
        {
            ListNode next = cur.next;

            if(cur.val == next.val)
            {
                cur.next = next.next;
            }else
            {
                cur = cur.next;
            }

        }
        return head;
    }
}
