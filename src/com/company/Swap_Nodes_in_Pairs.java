package com.company;

public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;
        if(head.next ==  null)
            return head;

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = two.next;
        two.next = one;
        one.next = swapPairs(three);
        return two;
    }
}
