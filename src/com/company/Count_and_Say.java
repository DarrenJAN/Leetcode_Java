package com.company;

public class Count_and_Say {
    public String countAndSay(int n) {
        return helper(n);
    }

    public String helper(int n )
    {
        if(n ==1)
            return "1";

        String str = "1";
        while(n > 1)
        {
            StringBuilder stringBuilder = new StringBuilder();
            char cur_string = str.charAt(0);
            int cur_num = 1;
            for(int i = 1;i<str.length();i++)
            {

                if( str.charAt(i) == str.charAt(i-1))
                {
                    cur_num++;
                }else
                {

                    stringBuilder.append( cur_num );
                    stringBuilder.append(cur_string);
                    cur_string = str.charAt(i);
                    cur_num =1;
                }

            }
            stringBuilder.append( cur_num );
            stringBuilder.append(cur_string);

            str = new String(stringBuilder);
            n--;
        }
        return str;
    }
}
