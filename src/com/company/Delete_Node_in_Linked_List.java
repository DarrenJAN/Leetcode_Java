package com.company;

public class Delete_Node_in_Linked_List {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        ListNode next = node.next;
        while(next.next != null)
        {
            pre.val = next.val;
            pre = next;
            next =next.next;
        }
        pre.val =next.val;
        pre.next = null;
    }

}
