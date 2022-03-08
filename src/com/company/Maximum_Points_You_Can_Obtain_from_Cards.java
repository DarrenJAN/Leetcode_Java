package com.company;

public class Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int total_sum =0;
        int result_max = 0;

        for(int i : cardPoints)
            total_sum += i;

        int window_length  = cardPoints.length - k;
        int window_sum = 0;
        for(int i = 0;i< window_length;i++)
            window_sum += cardPoints[i];

        result_max = total_sum - window_sum;

        for(int i = 1;i< cardPoints.length - window_length;i++)
        {
            window_sum -= cardPoints[i-1];
            window_sum += cardPoints[i + window_length-1];
            result_max = Math.max(result_max, total_sum - window_sum);
        }

        return  result_max;
    }
}
