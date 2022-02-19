package com.company;

public class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if( k == 0 || head == null || head.next == null)
            return head;

        int n = 1;
        ListNode it = head;
        while(it.next != null)
        {
            it = it.next;
            n++;
        }

        k = k % n;
        if(k == 0)
            return head;
        it.next = head;
        System.out.println(n);

        int b = n - k;
        int i = 1;
        while(i < b)
        {
            head = head.next;
            i++;

        }
        ListNode newhead = head.next;
        head.next = null;
        return newhead;

    }
}
