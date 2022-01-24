package com.company;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();

        int n = strs.length;
        if(n == 0)
            return "";
        if(n == 1)
            return strs[0];

        String prefix = strs[0];
        for(int i =1; i<n;i++)
        {
            prefix = prefix_helper(prefix, strs[i]);
        }
        return prefix;
    }

    public static  String prefix_helper(String prefix, String a)
    {
        while(  a.indexOf(prefix) != 0 && !prefix.isEmpty())
        {
            prefix= prefix.substring(0, prefix.length()-1);
        }
        return prefix;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "abceeeee";
        String c = prefix_helper(a, b);

        System.out.println(c);
    }
}
