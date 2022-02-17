package com.company;

import java.util.ArrayList;
import java.util.List;

public class Swapping_Nodes_in_a_Linked_List {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        ListNode firstNode = head;
        ListNode seconNode = head;

        int length = 0;
        while(cur != null)
        {
            length ++;

            if(length == k)
                firstNode = cur;
            cur = cur.next;

        }

        int second_index = length - k+1;

        for(int i = 1;i<second_index;i++)
        {
            seconNode = seconNode.next;
        }


        int tmp = firstNode.val;
        firstNode.val = seconNode.val;
        seconNode.val = tmp;
        return head;

    }

}
