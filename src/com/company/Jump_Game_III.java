package com.company;

public class Jump_Game_III {

    boolean[] vis;
    public boolean canReach(int[] arr, int start) {
        vis = new boolean[arr.length];
        return  backtrack(arr, start);
    }

    public boolean backtrack(int[] arr, int start)
    {
        if( start < 0 || start >= arr.length)
            return false;
        if(vis[start] == true)
            return false;

        vis[start] = true;
        if(arr[start] == 0)
            return true;
        else
            return backtrack(arr, start - arr[start]) || backtrack(arr, start + arr[start]);
    }
}
