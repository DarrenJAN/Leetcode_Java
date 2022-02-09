package com.company;

public class Find_the_Celebrity {
    public boolean knows(int a, int b)
    {
        return false;
    }


    public int findCelebrity(int n) {
        for(int i = 0;i< n;i++)
        {
            if(isFamous(i , n ))
                return i;
        }
        return -1;
    }

    public boolean isFamous(int cur, int n)
    {
        for(int i = 0 ;i <n; i++ )
        {
            if(i != cur )
            {
                if(!knows(i, cur)  || knows(cur, i))
                    return false;
            }
        }
        return true;
    }

    public int findCelebrity_2(int n) {
        int result = 0;

        for(int i = 0;i< n;i++)
        {
            if(knows(result , i ))
                result = i;
        }

        if(isFamous(result,n))
            return result;


        return -1;
    }
}
