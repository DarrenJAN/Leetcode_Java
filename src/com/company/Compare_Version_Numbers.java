package com.company;

public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");
        int length = Math.max(strings1.length, strings2.length);

        //System.out.println(length);
        int first = 0;
        int second = 0;
        for(int i = 0;i< length;i++)
        {
            first = i >= strings1.length? 0:Integer.valueOf(strings1[i]);
            second = i >= strings2.length? 0: Integer.valueOf(strings2[i]);
            if(first< second )
                return -1;
            else if(first > second )
                return 1;
        }
        return 0;
    }
}
