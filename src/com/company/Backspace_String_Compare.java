package com.company;

public class Backspace_String_Compare {
    public boolean backspaceCompare(String s, String t) {
        String s_ = "";
        String t_ = "";

        s_ = getString(s, "");
        t_ = getString(t, "");
        //System.out.println(s_ + " " + t_);
        return s_.equals(t_);
    }

    public String getString(String str, String result)
    {
        for(int i = 0;i < str.length();i++)
        {
            if(str.charAt(i)  != '#')
                result += str.charAt(i);
            else
            {
                if(result.length()  != 0)
                    result = result.substring(0, result.length()-1);
            }

        }
        return result;
    }
}
