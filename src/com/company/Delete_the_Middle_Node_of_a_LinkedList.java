package com.company;

public class Delete_the_Middle_Node_of_a_LinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(pre == null)
            return null;
        else
        {
            pre.next = slow.next;
        }

        return head;
    }

}
