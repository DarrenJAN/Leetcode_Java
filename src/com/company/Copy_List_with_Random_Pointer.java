package com.company;

import java.util.HashMap;

public class Copy_List_with_Random_Pointer {
    HashMap<Node, Node> vis = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Node new_head = new Node(head.val);
        Node new_head_it = new_head;

        if(vis.containsKey(head))
        {
            return vis.get(head);
        }

        vis.put(head, new_head);
        new_head_it.next = copyRandomList(head.next);
        new_head_it.random = copyRandomList(head.random);

        return new_head;

    }

    public Node copyRandomList_it(Node head) {
        if(head == null)
            return null;

        Node oldhead = head;
        Node newhead = new Node(head.val);
        Node newhead_it = newhead;
        vis.put(head, newhead);
        while( oldhead != null)
        {
            newhead_it.next = helper(oldhead.next);
            newhead_it.random = helper(oldhead.random);

            oldhead = oldhead.next;
            newhead_it = newhead_it.next;
        }
        return newhead;
    }
    public Node helper(Node node)
    {
        if(node == null)
            return null;

        if(vis.containsKey(node))
            return vis.get(node);
        else
        {
            Node newnode = new Node(node.val);
            vis.put(node, newnode);
            return newnode;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
