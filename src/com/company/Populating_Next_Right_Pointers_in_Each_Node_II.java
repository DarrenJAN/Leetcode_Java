package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node_II {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while( !queue.isEmpty())
        {
            Node first = queue.poll();
            int size = queue.size();

            if(first.left != null)
                queue.add(first.left);
            if(first.right != null)
                queue.add(first.right);

            for(int i =0;i<size;i++)
            {

                Node next = queue.poll();
                first.next = next;
                first = next;

                if(first.left != null)
                    queue.add(first.left);
                if(first.right != null)
                    queue.add(first.right);
            }
        }
        return root;
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
