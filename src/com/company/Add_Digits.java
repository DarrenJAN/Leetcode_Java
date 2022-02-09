package com.company;

public class Add_Digits {
    public int addDigits(int num) {
        int result = num;


        while(result / 10 > 0)
        {
            result = result / 10  + result % 10;
        }
        return result;
    }

}
