package com.company;

public class Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if(root == null)
            return null;

        root.next = null;
        iteration(root.left, root.right);
        return root;
    }

    public void iteration(Node l, Node r)
    {
        if(l == null || r== null)
            return;

        l.next = r;
        r.next = null;
        iteration(l.left, l.right);
        iteration(l.right, r.left);
        iteration(r.left, r.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
