package com.company;

public class Design_Linked_List {
    ListNode head = null;
    ListNode tail = null;
    int item = 0;
    public void MyLinkedList() {
        head = null;
        tail = null;
        item = 0;
    }

    public int get(int index) {
        if(index >= item)
            return -1;

        ListNode it = null;

        for(int i = 0;i <= index; i++ )
        {
            if(it == null)
                it = head;
            else
                it= it.next;

        }

        // print();
        return it.val;
    }

    public void addAtHead(int val) {

        item++;
        ListNode newhead = new ListNode(val);
        if(head == null)
        {
            head = newhead;
            tail = newhead;
        } else
        {
            newhead.next = head;
            head = newhead;
        }
        //print();
    }

    public void addAtTail(int val) {

        ListNode newtail = new ListNode(val);
        item++;
        if (tail == null)
        {
            head = newtail;
            tail = newtail;
        }else
        {
            tail.next = newtail;
            tail = newtail;
        }
        //print();
    }

    public void addAtIndex(int index, int val) {
        if (index > item)
            return;


        ListNode it = head;
        ListNode pre = null;
        while(index > 0 )
        {
            pre = it;
            it = it.next;
            index--;
        }



        if(pre == null)
            addAtHead(val);
        else
        {
            ListNode cur = new ListNode(val);
            pre.next = cur;
            cur.next = it;
            item ++;

            if(it == null)
                tail = cur;

        }


        //print();

    }

    public void deleteAtIndex(int index) {
        if (index >= item)
            return;


        ListNode it = head;
        ListNode pre = null;
        while(index > 0 )
        {
            pre = it;
            it = it.next;
            index--;
        }

        item --;
        if(pre == null)
        {
            head = head.next;
        }
        else
        {
            pre.next= it.next;
            if(it.next == null)
                tail = pre;
        }

        //print();
        //System.out.println(tail.val);
    }

    public void print()
    {
        ListNode it = head;
        while(it  !=null)
        {
            System.out.print(it.val + " " );
            it = it.next;
        }
        System.out.println();
    }
}
