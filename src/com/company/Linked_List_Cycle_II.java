package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if(head == null || head.next == null)
            return null;

        ListNode it = head;
        while(it!= null)
        {
            if(set.contains(it))
                return it;
            else
                set.add(it);

            it = it.next;
        }
        return null;
    }
}
