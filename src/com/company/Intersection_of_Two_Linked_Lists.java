package com.company;

import java.util.HashSet;

public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while(headA != null)
        {
            hashSet.add(headA);
            headA = headA.next;
        }

        while( headB != null)
        {
            if(hashSet.contains(headB))
                return headB;
            headB = headB.next;
        }
        return headB;
    }
}
