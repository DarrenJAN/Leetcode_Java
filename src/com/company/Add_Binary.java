package com.company;

public class Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        int al = a.length()-1;
        int bl = b.length()-1;
        int carry = 0;

        while( al >= 0 && bl >= 0)
        {
            char a_c = a.charAt(al);
            char b_c = b.charAt(bl);

            if(a_c == '1')
                carry++;

            if( b_c == '1')
                carry++;

            if(carry == 2|| carry==0)
                stringBuilder.append('0' );
            else
                stringBuilder.append('1' );

            //System.out.println(stringBuilder.toString()+" " + carry);
            carry = carry/2;

            al--;
            bl--;
        }

        while(al >= 0)
        {
            char a_c = a.charAt(al);
            if(a_c == '1')
                carry++;
            if(carry == 2|| carry==0)
                stringBuilder.append('0' );
            else
                stringBuilder.append('1' );

            carry = carry/2;

            al--;
        }

        while(bl >= 0)
        {
            char b_c = b.charAt(bl);
            if(b_c == '1')
                carry++;
            if(carry == 2|| carry==0)
                stringBuilder.append('0' );
            else
                stringBuilder.append('1' );

            carry = carry/2;

            bl--;
        }

        if(carry ==1)
            stringBuilder.append('1' );
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
