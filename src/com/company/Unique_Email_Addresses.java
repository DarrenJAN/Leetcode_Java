package com.company;

import java.util.HashSet;

public class Unique_Email_Addresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet = new HashSet<>();

        for(int i =0;i<emails.length;i++)
        {
            String[] cur =  emails[i].split("@");
            String local = cur[0];
            String host = cur[1];

            StringBuilder new_loca = new StringBuilder();

            for(int j = 0;j< local.length();j++)
            {
                if(local.charAt(j) == '+')
                    break;
                else if(local.charAt(j) == '.')
                    continue;
                else
                    new_loca.append(local.charAt(j));
            }

            String email = new_loca.toString()+"@"+host;
            hashSet.add(email);
        }
        return hashSet.size();
    }
}
