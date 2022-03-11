package com.company;

import java.util.HashMap;

public class MostBookedHotelRoom {
    public static String solution(String[] rooms) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String str : rooms)
        {
            String cur_char = str.substring(1);
            if(str.charAt(0) == '+')
                hashMap.put(cur_char, hashMap.getOrDefault(cur_char, 0)+1);
        }

        int max_book =-1 ;
        String result = "";
        for(String string: hashMap.keySet())
        {
            if(hashMap.get(string) > max_book)
            {
                result = string;
                max_book = hashMap.get(string);
            }else if(hashMap.get(string) == max_book)
            {
                if(isSmaller(string, result))
                {
                    result = string;
                }
            }
        }
        return max_book > 0 ? result : null;
    }

    public  static  boolean isSmaller(String a, String b)
    {
        if(a.equals(b))
        {
            return false;
        }else
        {
            int numa = a.charAt(0)-'0';
            int numb = b.charAt(0 )- '0';
            if(numa < numb)
                return true;
            else if (numa > numb)
                return false;
            else
            {
                return (a.charAt(1) - 'A') < (b.charAt(1) - 'A');
            }
        }
    }

    public static void main(String[] args) {
        // ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
        String[] books1 = { "+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+1A", "-1A", "+1A" };
        String[] books2 = {"+1E", "-1E", "+1E", "-1E", "+1E", "-1E", "+1E", "-1E","+2A", "-2A", "+2A", "-2A", "+2A", "-2A", "+2A",
                "-2A","+2B", "-2B", "+2B", "-2B", "+2B", "-2B", "+2B", "-2B"};
        System.out.println(solution(books1));
        System.out.println(solution(books2));
    }
}
