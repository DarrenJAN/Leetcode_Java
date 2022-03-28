package com.company;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++)
        {
            prefix = prefix_helper(prefix,  strs[i]);
        }
        return prefix;
    }

    public  String prefix_helper(String prefix, String a)
    {
        while(prefix.length()  > 0 && !a.startsWith(prefix))
        {
            prefix = prefix.substring(0, prefix.length()-1);
        }
        return prefix;
    }

    public String longestCommonPrefix_2(String[] strs) {
        int l = 0;
        int r = strs[0].length()-1;
        while( l <= r)
        {
            int mid = (r - l) /2 + l;
            if(isPrefix(strs, mid))
            {
                l = mid +1;
            }else
            {
                r = mid -1;
            }
        }
        return strs[0].substring(0, l);
    }

    public boolean isPrefix(String[] strings, int mid )
    {
        String prefix = strings[0].substring(0,  mid+1);
        for(int i = 1; i< strings.length;i++)
        {
            if(!strings[i].startsWith(prefix))
                return false;
        }
        return true;
    }




    public static void main(String[] args) {
        String a = "abcd";
        String b = "abceeeee";
        //String c = prefix_helper(a, b);

        //System.out.println(c);
    }
}
