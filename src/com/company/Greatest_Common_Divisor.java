package com.company;

import java.util.Scanner;

public class Greatest_Common_Divisor {
    public static void main(String[] args) {
        System.out.println(GCD(30,32));
        System.out.println(GCD(1,32));
        System.out.println(GCD(81,32));

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int minGCD = Integer.MAX_VALUE, maxGCD = Integer.MIN_VALUE;
        for(int i = 0;i<= n ;i++)
        {
            if(i == 0)
            {
                sc.nextInt();
            }else
            {
                for(int  j = 0;j< Math.pow(2,i);j+=2)
                {
                    int a = sc.nextInt();
                    int b= sc.nextInt();
                    if(a == -1 || b == -1)
                        continue;
                    int newGCD = GCD(a, b);
                    System.out.println("newGCD " + newGCD);
                    if(newGCD < minGCD)
                        minGCD = newGCD;
                    if(newGCD > maxGCD)
                        maxGCD = newGCD;
                }
            }
        }
        if (minGCD == Integer.MAX_VALUE && maxGCD == Integer.MIN_VALUE) {
            System.out.print(0);
            return;
        }
        System.out.print(maxGCD - minGCD);
    }

    static int GCD(int a, int b )
    {
        if( b >= a )
            return GCD(b, a );

        if(b == 0)
            return a;
        else if( a % b == 0)
            return b;
        else
            return GCD(b, a % b);
    }
}
