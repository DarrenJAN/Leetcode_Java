package com.company;

public class Next_Greater_Element_III {
    public int nextGreaterElement(int n) {
        char[] chars  = ("" +n).toCharArray();
        int length = chars.length;
        int first_index = length;
        int second_index = length-1;

        for(int i = length-1;i> 0; i--)
        {
            if(chars[i] > chars[i-1])
            {
                first_index = i-1;
                break;
            }
        }

        for(int i = first_index+1;i< length;i++)
        {
            if(chars[i] <= chars[first_index])
            {
                second_index = i-1;
                break;
            }
        }
        if(first_index == length )
            return -1;

        //System.out.println(first_index+ " "+ second_index);
        swap(chars, first_index, second_index);
        reverse(chars, first_index+1, length-1);

        String result = new String(chars);
        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            return -1;
        }
    }

    public void swap(char[] c, int i, int j )
    {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

    public void reverse(char[] c, int l, int r)
    {
        while(l < r)
        {
            swap(c, l , r);
            l++;
            r--;
        }
    }


}
