package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_III {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> hashSet = new HashSet<>();
        Node p_it = p;
        while(p_it != null)
        {
            hashSet.add(p_it);
            p_it = p_it.parent;
        }

        while(! hashSet.contains(q))
        {
            q = q.parent;
        }

        return q;

    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
