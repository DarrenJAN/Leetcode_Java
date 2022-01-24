package com.company;

public record Remove_Nth_Node_From_End_of_List() {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;

        if(head == null)
            return null;

        int len = 0;
        while(first != null)
        {
            first = first.next;
            len++;
        }

        int pos = len - n;
        if(pos == 0)
            return head.next;

        first = head;
        while(pos != 1)
        {
            first = first.next;
            pos --;
        }

        //System.out.println(first.val);
        if(first.next.next == null)
            first.next = null;
        else
        {
            ListNode listNode = first.next.next;
            first.next = listNode;
        }

        return head;

    }
}
