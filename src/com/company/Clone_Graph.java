package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Clone_Graph {
    //recursion
    HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (visited.containsKey(node))
            return visited.get(node);


        Node root = new Node(node.val);
        visited.put(node, root);

        List<Node> neighbors = node.children;
        for (Node neighbor : neighbors) {
            root.children.add(cloneGraph(neighbor));
        }

        return root;
    }

    //BFS
    public Node cloneGraph_BFS(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> vis = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(node.val);

        vis.put(node, root);
        queue.add(node);

        while(!queue.isEmpty())
        {
            Node cur_node = queue.poll();
            Node new_cur_node = vis.get(cur_node);

            List<Node> neighbors = cur_node.children;

            for(Node neighbor : neighbors)
            {
                if(vis.containsKey(neighbor))
                    new_cur_node.children.add(vis.get(neighbor));
                else
                {
                    Node new_neighbor = new Node(neighbor.val);
                    new_cur_node.children.add(new_neighbor);
                    vis.put(neighbor, new_neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return root;
    }
}