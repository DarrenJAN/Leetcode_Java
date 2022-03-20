package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    private Deque<Integer> in;
    public MyStack() {
        in = new LinkedList<>();
    }

    public void push(int x) {
        in.addLast(x);

        int size = in.size();
        while(size >1)
        {
            in.addLast(in.pop());
            size--;
        }
    }

    public int pop() {

        return in.pop();
    }

    public int top() {
        return in.peekFirst();
    }

    public boolean empty() {
        return in.isEmpty();
    }

}
