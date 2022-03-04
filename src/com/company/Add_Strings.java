package com.company;

public class Add_Strings {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while(len1 >= 0 || len2 >= 0)
        {
            int cur_1 =  len1 >= 0 ? n1[len1]-'0' : 0;
            int cur_2 =  len2 >= 0 ? n2[len2] - '0' : 0;


            int sum = cur_1+cur_2 + carry;
            carry = sum / 10;

            stringBuilder.append(sum % 10);
            len1--;
            len2--;
        }
        if(carry == 1)
            stringBuilder.append('1');
        return stringBuilder.reverse().toString();
    }
}
