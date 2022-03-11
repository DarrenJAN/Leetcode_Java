package com.company;

public class License_Key_Formatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i< s.length();i++)
        {
            if(s.charAt(i) != '-')
                stringBuilder.append(s.charAt(i));
        }
        int length = stringBuilder.length();
        if(length == 0)
            return "";
        int count = length / k;
        int first_length = length - count* k ;
        //System.out.println(length + " "+ count + " " + first_length);

        StringBuilder result = new StringBuilder();
        int z = 0;
        for(int i =0;i< first_length;i++)
        {
            char cur_char = stringBuilder.charAt(z++);

            if( 'a'<= cur_char && cur_char <= 'z' )
                cur_char = Character.toUpperCase(cur_char);
            result.append(cur_char);
        }

        if(result.length() != 0)
        {
            result.append('-');
        }

        for(int i = 0;i< count;i++)
        {
            for(int j =0;j< k;j++)
            {
                char cur_char = stringBuilder.charAt(z++);

                if( 'a'<= cur_char && cur_char <= 'z' )
                    cur_char = Character.toUpperCase(cur_char);
                result.append(cur_char);
            }
            result.append("-");
        }



        return result.substring(0, result.length()-1).toString();
    }
}
