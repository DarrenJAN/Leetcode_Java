package com.company;

public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;

        if (first == null || first.next == null)
            return head;

        ListNode second = head;

        while (second != null)
        {
            if (second.next != null)
            {
                second = second.next;
                second = second.next;
            }else
                break;
            first = first.next;
        }

        return first;

    }

}
