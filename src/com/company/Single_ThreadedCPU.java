package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Single_ThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[] order = new int[tasks.length];
        int order_index = 0;

        Task[] tasks1  = new Task[tasks.length];
        for(int i =0;i< tasks.length;i++)
            tasks1[i] = new Task(tasks[i][0],tasks[i][1], i);

        Arrays.sort(tasks1, (a, b)-> (a.start_time - b.start_time));

        PriorityQueue<Task> min_heap = new PriorityQueue<>( (a, b) ->  a.proc_time == b.proc_time ? a.index - b.index: (a.proc_time - b.proc_time));
        int i = 0;
        int time =0;

        while(i<  tasks1.length || !min_heap.isEmpty())
        {
            if(min_heap.isEmpty())
            {
                time = Math.max(time, tasks1[i].start_time);
            }

            while(i< tasks1.length && time >= tasks1[i].start_time)
                min_heap.add(tasks1[i++]);

            Task next_task = min_heap.poll();
            time += next_task.proc_time;
            order[order_index++] = next_task.index;;
        }

        return order;
    }

    class Task
    {
        int start_time;
        int proc_time;
        int index;

        Task(int start_time, int proc_time, int index)
        {
            this.start_time = start_time;
            this.proc_time = proc_time;
            this.index = index;
        }

    }

}
