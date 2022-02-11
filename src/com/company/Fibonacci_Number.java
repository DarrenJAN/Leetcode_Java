package com.company;

public class Fibonacci_Number {
    public int fib(int n) {
        int[] mem = new int[n+1];

        return fib_recursion( n, mem);

    }

    public int fib_recursion(int n, int[] mem)
    {
        if(n == 0 )
            return 0;
        if(n == 1)
            return 1;
        if(mem[n] != 0)
            return mem[n];

        int a = fib_recursion(n-1,mem);
        int b = fib_recursion(n-2,mem);
        mem[n] = a+b;
        return a+b;
    }
}
