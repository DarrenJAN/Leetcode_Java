package com.company;

import java.util.List;

public class Keys_and_Rooms {
    boolean[] vis;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];


        dfs(rooms, 0);

        for(int i = 0 ;i< n;i++)
        {
            if( vis[i] == false)
                return false;
        }

        return true;
    }

    public void dfs(List<List<Integer>> rooms, int cur_pos)
    {
        if(vis[cur_pos] )
            return;

        vis[cur_pos] = true;
        List<Integer> cur_keys = rooms.get(cur_pos);

        for(int i = 0;i< cur_keys.size();i++)
        {
            dfs(rooms, cur_keys.get(i));
        }
    }

}
