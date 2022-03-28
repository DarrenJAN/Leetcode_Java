package com.company;

import java.util.Collections;

public class Multiply_Strings {
    //Product of digit at index i in num1 and digit at index j in num1 will be saved at indexes i+j and i+j+1 in the result array.
    //
    //result[i+j+1] = (nums[i] * nums[j]) % 10
    //result[i+j] = (nums[i] * nums[j]) / 10
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if(num1.equals("0")  || num2.equals("0"))
        {
            return "0";
        }

        if(num1.equals("1"))
            return num2;
        if(num2.equals("1"))
            return num1;
        int[] result = new int[n1+n2];

        for(int i = n2-1;i>= 0; i--)
        {
            int c1 = num2.charAt(i) - '0';
            for(int j = n1-1;j>=0;j--)
            {
                int c2 = num1.charAt(j) - '0';
                int cur_product = c1 * c2;
                cur_product += result[i+j+1];

                int carry = cur_product / 10;
                int mod = cur_product % 10;

                result[i+j+1] = mod;
                result[i+j] += carry;

                //System.out.println(cur_product);
            }
        }

        //from the end
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i< result.length ;i++){
            if(stringBuilder.length() == 0 && result[i] == 0)
                continue;
            stringBuilder.append(result[i]);
        }

        //stringBuilder.reverse();
        return stringBuilder.toString();

    }

}
