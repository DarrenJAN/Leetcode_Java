package com.company;

public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int cur_gas = 0;
        int start_pos = 0;

        for(int i=0;i< gas.length;i++)
        {
            total_gas += gas[i] -cost[i];
            cur_gas += gas[i] -cost[i];
            if(cur_gas < 0)
            {
                start_pos = i+1;
                cur_gas = 0;
            }
        }

        return total_gas < 0 ? -1: start_pos;
    }

}
