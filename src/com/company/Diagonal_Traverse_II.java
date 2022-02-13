package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Diagonal_Traverse_II {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> result = new ArrayList<>();
        int row = nums.size();
        int count = 0;

        for(int i = 0;i< row;i++)
        {
            List<Integer> cur_row_nums = nums.get(i);

            if(cur_row_nums.size()+i > result.size())
            {
                int add_row = cur_row_nums.size() +i - result.size();
                for(int j = 0; j< add_row;j++)
                    result.add(new ArrayList<>());
            }

            for(int j = 0;j< cur_row_nums.size();j++)
            {
                result.get(j+i).add(cur_row_nums.get(j));
                count++;
            }
        }

        int[] re = new int[count];
        int k =0;
        for(int i =0;i<result.size();i++)
        {
            Collections.reverse(result.get(i));
            List<Integer> cur_row_nums = result.get(i);

            for(Integer integer :cur_row_nums)
            {
                re[k++] = integer;
            }
        }

        return re;

    }

}
