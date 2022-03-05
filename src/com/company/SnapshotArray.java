package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SnapshotArray {
    HashMap<Integer, Integer>[] snaps;
    int length;
    int id ;

    public SnapshotArray(int length) {
        snaps = new HashMap[length];
        for(int i = 0;i< length;i++)
        {
            snaps[i] = new HashMap<>();
        }
        id = 0;
        this.length= length;
    }

    public void set(int index, int val) {
        snaps[index].put(id, val);
    }

    public int snap() {
        id++;
        return id -1;

    }

    public int get(int index, int snap_id) {
        while(snap_id >= 0)
        {
            if(snaps[index].containsKey(snap_id))
            {
                return snaps[index].get(snap_id);
            }else
            {
                snap_id--;
            }
        }

        return 0;

    }
}
