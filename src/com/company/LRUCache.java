package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    HashMap<Integer, DoubleListNode> cache;
    int size;
    int capacity;
    DoubleListNode head;
    DoubleListNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DoubleListNode(-1, -1);
        tail = new DoubleListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        DoubleListNode node = cache.get(key);
        movetohead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleListNode node = new DoubleListNode(key, value);
        if (size < capacity) {
            size++;

        } else {
            poptail();

        }
        cache.put(key, node);
        movetohead(node);
    }


    public void movetohead(DoubleListNode node) {
       remove(node);
       add(node);
    }

    void poptail() {
        DoubleListNode tobedelete = tail.pre;
        remove(tobedelete);

        cache.remove(tobedelete.key);
    }

    void remove(DoubleListNode node)
    {
        DoubleListNode pre = node.pre;
        DoubleListNode next =node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    void add(DoubleListNode node)
    {
        DoubleListNode next = head.next;
        head.next = node;
        node.next = next;

        next.pre = node;
        node.pre = head;
    }


    class DoubleListNode
    {

        int key;
        int value;
        DoubleListNode pre;
        DoubleListNode next;

        DoubleListNode(int key,int val)
        {

            this.key = key;
            this.value = val;
        }
    }
}
