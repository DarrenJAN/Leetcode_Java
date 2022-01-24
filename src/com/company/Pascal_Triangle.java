package com.company;

import java.util.LinkedList;
import java.util.List;

public class Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        tmp.add(1);
        result.add(tmp);


        if(numRows == 1)
            return result;

        for(int i = 1; i<numRows;i++)
        {
            tmp = new LinkedList<>();
            tmp.add(1);
            List<Integer> last = result.get(result.size()-1);
            for(int j = 0;j<i-1;j++)
            {
                tmp.add(last.get(j) + last.get(j+1));

            }
            tmp.add(1);
            result.add(tmp);

        }
        return result;
    }
}
