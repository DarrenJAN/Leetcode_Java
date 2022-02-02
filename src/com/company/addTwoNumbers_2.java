package com.company;

public class addTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = reverseList(l1);
        ListNode listNode2 = reverseList(l2);

        ListNode newhead = new ListNode(-1);
        ListNode new_head_it = newhead;

        int value = 0;
        int carry = 0;

        while(listNode1 != null && listNode2 != null)
        {
            int cur_val = listNode1.val + listNode2.val + carry;
            value = cur_val % 10;
            carry  = cur_val / 10;

            ListNode cur_node = new ListNode(value);
            new_head_it.next = cur_node;
            new_head_it = cur_node;

            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }

        while(listNode1 != null)
        {
            int cur_val = listNode1.val   + carry;
            value = cur_val % 10;
            carry  = cur_val / 10;
            ListNode cur_node = new ListNode(value);
            new_head_it.next = cur_node;
            new_head_it = cur_node;
            listNode1 = listNode1.next;
        }

        while(listNode2 != null)
        {
            int cur_val = listNode2.val   + carry;
            value = cur_val % 10;
            carry  = cur_val / 10;
            ListNode cur_node = new ListNode(value);
            new_head_it.next = cur_node;
            new_head_it = cur_node;
            listNode2 = listNode2.next;
        }

        if(carry != 0)
            new_head_it.next = new ListNode(1);
        return reverseList(newhead.next);
    }

    public ListNode reverseList(ListNode l)
    {
        ListNode head = l;
        ListNode tail= null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}
