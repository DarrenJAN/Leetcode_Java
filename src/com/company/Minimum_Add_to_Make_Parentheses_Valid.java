package com.company;

public class Minimum_Add_to_Make_Parentheses_Valid {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int step = 0;
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i) == '(')
            {
                balance++;
            }else
            {
                if(balance== 0)
                {
                    step++;
                }else
                    balance--;
            }
        }

        step+= balance;
        return  step;
    }
}
