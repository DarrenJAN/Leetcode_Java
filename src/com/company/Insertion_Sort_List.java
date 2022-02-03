package com.company;

public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        ListNode node = head;
        ListNode newhead = null;
        while(node != null)
        {
            ListNode next = node.next;
            node.next =null;
            newhead = insert_it(newhead, node);
            node = next;
        }

        return newhead;
    }

    public ListNode insert_it(ListNode list, ListNode node)
    {
        if(list == null)
            return node;

        ListNode pre = null;
        ListNode it = list;
        while(it != null )
        {
            if(it.val > node.val)
                break;
            else
            {
                pre = it;
                it = it.next;

            }
        }

        if(pre ==  null)
        {
            node.next = it;
            return node;
        }else
        {
            pre.next = node;
            node.next = it;
            return list;
        }

    }
}
