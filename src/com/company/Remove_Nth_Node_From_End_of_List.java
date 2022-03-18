package com.company;

public record Remove_Nth_Node_From_End_of_List() {
    //slide window
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode predelteNode = null;
        ListNode deleteNode = head;
        ListNode it = head;

        n = n-1;
        while(n > 0) {
            it = it.next;
            n--;
        }

        while(it.next != null)
        {
            it = it.next;
            predelteNode =deleteNode;
            deleteNode = deleteNode.next;
        }
        if(predelteNode == null)
            return head.next;
        else
        {
            predelteNode.next = deleteNode.next;
        }

        return head;
    }



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
