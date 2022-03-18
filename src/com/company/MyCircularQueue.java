package com.company;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCircularQueue {
    int[] nums;
    int head;
    int tail;
    int cap;
    int size;
    ReentrantLock lock = new ReentrantLock();
    public MyCircularQueue(int k) {
        nums = new int[k];
        head = 0;
        tail  = 0 ;
        this.cap = k;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        lock.lock();
        try{
            if( size == cap)
            {
                return false;
            }else
            {
                if(tail == this.cap)
                {
                    tail = 0;
                }
                nums[tail] = value;
                tail++;
                size ++;
                return true;
            }
        } finally {
            lock.unlock();
        }

    }

    public boolean deQueue() {
        if(size == 0)
            return false;
        else
        {
            head ++;
            if(head == this.cap)
                head = 0;
            size--;
            return true;
        }
    }

    public int Front() {
        if(this.size == 0)
            return -1;
        return nums[head];
    }

    public int Rear() {
        if(this.size == 0)
            return -1;
        return nums[tail-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {

        return size == cap;
    }

}
