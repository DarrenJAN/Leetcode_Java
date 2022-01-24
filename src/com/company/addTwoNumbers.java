package com.company;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        int carry = 0;
        ListNode first = l1;
        ListNode second = l2;
        ListNode result = new ListNode(0);
        ListNode current = result;
        int first_val = 0;
        int second_val = 0;
        while(first != null || second != null)
        {
            if( first == null)
            {
                first_val = 0;
            } else
                first_val = first.val;

            if( second == null)
            {
                second_val = 0;
            } else
                second_val = second.val;

            value = first_val + second_val+ carry;
            carry = value / 10;
            value = value % 10;

            current.next = new ListNode(value);

            current = current.next;
            if(first != null)
                first = first.next;

            if(second != null)
                second = second.next;


        }
        if(carry >0)
            current.next  = new ListNode(1);
        return result.next;
    }

    public static void main(String[] args) {

    }
}
