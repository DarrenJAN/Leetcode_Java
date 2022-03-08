package com.company;

import java.util.Arrays;

public class Maximum_Height_by_Stacking_Cuboids {
    public int maxHeight(int[][] cuboids) {
        for (int i = 0; i < cuboids.length; i++) Arrays.sort(cuboids[i]);
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        int[] dp = new int[cuboids.length];
        int max = 0;
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = i - 1; j >= 0; j--)
                if ((cuboids[i][1] >= cuboids[j][1]) && (cuboids[i][2] >= cuboids[j][2]))
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
