package com.company;

import java.util.Stack;

public class MyQueue {
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        toStack2();
        return stack2.pop();
    }

    public int peek() {
        toStack2();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void toStack2()
    {
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

}
