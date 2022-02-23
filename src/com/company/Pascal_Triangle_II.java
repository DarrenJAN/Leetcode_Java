package com.company;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle_II {
    List<List<Integer>> store = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre_level;
        List<Integer> cur_level = new ArrayList<>();
        cur_level.add(1);
        store.add(cur_level);

        for(int i = 1;i<=rowIndex;i++)
        {
            cur_level = new ArrayList<>();
            pre_level = store.get(store.size()-1);
            for(int j = 0;j<=i;j++)
            {
                if(j == 0 || j == i)
                {
                    cur_level.add(1);
                }
                else
                {
                    cur_level.add(pre_level.get(j-1) + pre_level.get(j));
                }
                store.add(cur_level);
            }
        }
        return cur_level;
    }
}
