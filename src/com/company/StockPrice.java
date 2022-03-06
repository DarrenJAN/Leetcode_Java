package com.company;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class StockPrice {
    private PriorityQueue<Pair> min_heap;
    private PriorityQueue<Pair> max_heap;
    private HashMap<Integer,Integer> stock;
    private int time;


    public StockPrice() {
        min_heap = new PriorityQueue<>((a, b) -> (a.price - b.price));
        max_heap = new PriorityQueue<>((a, b) -> (b.price - a.price));
        stock = new HashMap<>();
        time = 0;

    }

    public void update(int timestamp, int price) {
        if(timestamp > time)
            time = timestamp;
        min_heap.add(new Pair(timestamp, price));
        max_heap.add(new Pair(timestamp, price));
        stock.put(timestamp, price);
    }

    public int current() {
        return stock.get(time);
    }

    public int maximum() {
        return head(max_heap);
    }

    public int minimum() {
        return head(min_heap);
    }

    public int head(PriorityQueue<Pair> pq)
    {
        while(!pq.isEmpty())
        {
            Pair cur = pq.peek();
            if(cur.price != stock.get(cur.time))
            {
                pq.poll();
            }else
                return cur.price;
        }
        return -1;
    }


    class Pair{
        int time;
        int price;

        Pair(int time, int p)
        {
            this.time = time;
            this.price = p;
        }
    }
}
