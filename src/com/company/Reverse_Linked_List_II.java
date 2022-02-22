package com.company;

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right <= left)
            return head;

        int left_it = 1;
        int right_it = 1;
        ListNode l = head;
        ListNode r = head;
        ListNode pre = null;
        ListNode after =head;

        while(left_it < left)
        {
            if(left_it == left-1)
                pre = l;
            l = l.next;
            r = r.next;
            left_it++;
            right_it++;
        }

        while(right_it < right)
        {
            r = r.next;
            right_it++;
        }

        after = r.next;
        r.next = null;

        ListNode reverseNode = reverse(l);

        if(pre != null)
        {
            pre.next = reverseNode;
            l.next = after;
            return head;
        }else
        {
            l.next = after;
            return reverseNode;
        }
    }

    public ListNode reverse(ListNode head)
    {
        ListNode pre = null;

        while(head !=null)
        {
            ListNode nexthead = head.next;
            head.next = pre;
            pre = head;
            head = nexthead;
        }
        return pre;
    }


}
