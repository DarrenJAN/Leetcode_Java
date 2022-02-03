package com.company;

public class Sort_List {
    public ListNode sortList(ListNode head) {
        return merge_sort(head);
    }

    public ListNode merge_sort(ListNode head)
    {
        if(head == null || head.next == null)
            return head;

        ListNode mid = getmid(head);
        ListNode left  = merge_sort(head);
        ListNode right = merge_sort(mid);
        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode newhead = new ListNode(-1);
        ListNode newhead_it = newhead;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val )
            {
                newhead_it.next = l1;
                l1 = l1.next;
            }else
            {
                newhead_it.next = l2;
                l2 = l2.next;
            }
            newhead_it = newhead_it.next;
        }

        if(l1 != null)
            newhead_it.next = l1;
        if(l2 != null)
            newhead_it.next = l2;
        return newhead.next;
    }

    public ListNode getmid(ListNode head)
    {
        ListNode first = head;
        ListNode second = head;
        ListNode mid_pre = null;

        while(second != null && second.next != null)
        {
            mid_pre= first;
            first = first.next;
            second = second.next.next;
        }

        if(mid_pre == null)
        {
            first.next = null;
            return first;
        }
        else
        {
            mid_pre.next = null;
            return first;
        }
    }
}
