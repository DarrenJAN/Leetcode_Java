package com.company;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if(minstack.isEmpty())
            minstack.push(val);
        else if(val < minstack.peek())
            minstack.push(val);
        else
            minstack.push(minstack.peek());
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
