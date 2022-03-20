package com.company;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if(!empty())
        {
            if(!out.isEmpty())
                return out.pop();
            else
            {
                while(!in.isEmpty())
                {
                    out.push(in.pop());
                }
                return out.pop();
            }
        }
        return -1;
    }

    public int peek() {
        if(! out.isEmpty())
        {
            return out.peek();
        }else
        {
            while(! in.isEmpty())
            {
                out.push(in.pop());
            }
            return out.peek();
        }
    }

    public boolean empty() {
        if (in.isEmpty() && out.isEmpty())
            return true;
        else
            return false;

    }

}
