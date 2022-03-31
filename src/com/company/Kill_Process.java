package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Kill_Process {
    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        for(int i = 0;i< ppid.size();i++)
        {
            int parent = ppid.get(i);
            int child = pid.get(i);

            if(!hashMap.containsKey(parent))
                hashMap.put(parent, new ArrayList<>());
            hashMap.get(parent).add(child);
        }

        DFS(kill);
        return result;
    }

    public void DFS(int kill)
    {
        result.add(kill);
        if(!hashMap.containsKey(kill))
            return;
        List<Integer> childs = hashMap.get(kill);
        for(Integer child : childs)
            DFS(child);
    }
}
