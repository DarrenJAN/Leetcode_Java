package com.company;

import java.util.ArrayList;

public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode new_head = new ListNode(-1);
        ListNode it = new_head;
        ListNode odd = head;
        ListNode even = head.next;
        while(odd != null)
        {
            it.next = new ListNode(odd.val);
            it = it.next;
            if(odd.next == null)
                break;
            odd = odd.next.next;

        }
        while(even != null)
        {
            it.next = new ListNode(even.val);
            it = it.next;
            if(even.next == null)
                break;
            even = even.next.next;

        }

        return new_head.next;
    }

    //no extra space
    public ListNode oddEvenList_2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd_tail = head;

        ListNode even_start = head.next;
        ListNode even_tail = head.next;

        ListNode it = head.next.next;
        odd_tail.next =null;
        even_tail.next = null;

        int i = 1;
        while(it  != null)
        {
            ListNode next = it.next;
            it.next = null;

            if( i % 2 != 0)
            {
                odd_tail.next = it;
                odd_tail = odd_tail.next;
            }else
            {
                even_tail.next =  it;
                even_tail = even_tail.next;
            }
            it = next;
            i++;
        }

        odd_tail.next = even_start;
        return head;

    }
}
