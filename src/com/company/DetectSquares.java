package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DetectSquares {
    List<int[]> points;
    HashMap<String, Integer> hashMap;

    public DetectSquares() {
        points = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    public void add(int[] point) {
        points.add(point);
        String key = point[0] + "@" + point[1];
        hashMap.put(key, hashMap.getOrDefault(key, 0) +1);

    }

    public int count(int[] point) {
        int ans= 0;
        int x = point[0];
        int y = point[1];

        for(int[] p : points)
        {
            int cur_x = p[0];
            int cur_y = p[1];;

            if(cur_x == x || cur_y == y || Math.abs(x - cur_x) != Math.abs(y - cur_y))
                continue;

            ans  += hashMap.getOrDefault(x+"@"+cur_y, 0) * hashMap.getOrDefault(y+"@"+cur_x, 0);
        }
        return ans;
    }
}
