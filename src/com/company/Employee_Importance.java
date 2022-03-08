package com.company;

import java.util.*;

public class Employee_Importance {
    HashMap<Integer, Employee> Hashmap= new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        Queue<Employee> queue = new LinkedList<>();

        for(Employee e: employees)
        {
            if(e.id == id)
            {
                queue.add(e);
            }
            Hashmap.put(e.id, e);
        }

        int result = 0;
        while (! queue.isEmpty())
        {
            Employee e = queue.poll();
            result += e.importance;

            for(Integer sub_e : e.subordinates)
                queue.add(Hashmap.get(sub_e));

        }
        return result;

    }



    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
