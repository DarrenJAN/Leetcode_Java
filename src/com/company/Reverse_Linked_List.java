package com.company;

public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null)
        {
            ListNode nextnode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextnode;
        }

        return pre;
    }
}
