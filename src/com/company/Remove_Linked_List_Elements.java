package com.company;

public class Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;

        ListNode pre = new ListNode(-1);
        pre.next =head;

        ListNode newhead = pre;
        ListNode tmp = head;

        while(tmp != null)
        {

            if(tmp.val == val)
            {
                pre.next = tmp.next;
            }else
            {
                pre = pre.next;
            }

            tmp = tmp.next;

        }

        return newhead.next;
    }

}
