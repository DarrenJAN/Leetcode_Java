package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Jump_Game_VII {
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length()-1) == '1')
            return false;

        int n =s.length();
        int farthest=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while( !queue.isEmpty())
        {
            int cur_pos = queue.poll();
            if(cur_pos == n-1)
                return true;

            //System.out.println(cur_pos);

            int min_pos=Math.max(cur_pos + minJump,farthest+1);
            int max_pos = Math.min(cur_pos + maxJump, n-1) ;

            for(int i = min_pos;i<=max_pos;i++)
            {
                if(i == n-1)
                    return true;
                if(s.charAt(i) == '0')
                    queue.add(i);
            }
            farthest = cur_pos + maxJump;
        }

        return false;
    }
}
