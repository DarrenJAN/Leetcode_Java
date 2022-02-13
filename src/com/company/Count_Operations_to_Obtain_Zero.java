package com.company;

public class Count_Operations_to_Obtain_Zero {
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0)
            return 0;
        if( num1 == num2)
        {
            return 1;
        } else if( num1 > num2)
        {
            return 1 + countOperations(num1- num2 , num2);
        } else
        {
            return 1 + countOperations(num1, num2 - num1);
        }

    }
}
