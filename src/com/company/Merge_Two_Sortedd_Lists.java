package com.company;

public class Merge_Two_Sortedd_Lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;


        ListNode head = new ListNode(-1);
        ListNode pre = head;

        while(list1 != null && list2 != null)
        {
             if(list1.val < list2.val)
             {
                 pre.next = list1;
                 list1 = list1.next;
             }else
             {
                 pre.next = list2;
                 list2 = list2.next;
             }
             pre = pre.next;
        }

        if(list1 == null)
            pre.next = list2;
        else
            pre.next = list1;

        return head.next;
    }


    //recursion
    public ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {
        if(list1 == null)
            return  list2;
        else if(list2 == null)
            return list1;
        else if( list1.val< list2.val)
        {
            list1.next = mergeTwoLists_2(list1.next, list2);
            return list1;
        } else
        {
            list2.next = mergeTwoLists_2(list1, list2.next);
            return list2;
        }
    }
}
