package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cells_in_Range_on_Excel_Sheet {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        String[] arrays = s.split(":");
        int r1 = arrays[0].charAt(1) - '0';
        int r2 = arrays[1].charAt(1) - '0';

        char c1 = arrays[0].charAt(0);
        char c2 = arrays[1].charAt(0);

        for(char i = c1;i<=c2 ;i++)
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            for(int j = r1; j<= r2;j++)
            {
                stringBuilder.append(j);
                result.add(stringBuilder.toString());
                stringBuilder.deleteCharAt(1);
            }
        }
        return result;
    }
}
