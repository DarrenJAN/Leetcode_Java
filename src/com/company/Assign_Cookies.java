package com.company;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;

public class Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;
        int s_index  = s.length-1;
        for(int i = g.length-1;i>= 0;i--)
        {
            if(s[s_index] >= g[i])
            {
                result++;
                s_index--;
            }
        }
        return result;
    }
}
