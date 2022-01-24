package com.company;

import java.util.HashSet;
import java.util.Set;

public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        Set<ListNode> set = new HashSet<>();
        ListNode tmp =head;
        while (tmp != null)
        {
            if(set.contains(tmp))
            {
                return true;
            }
            else
            {
                set.add(tmp);
                tmp = tmp.next;
            }
        }

        return false;
    }

    public boolean hasCycle_2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
