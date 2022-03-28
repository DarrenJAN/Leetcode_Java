package com.company;

public class Angle {
    public double angleClock(int hour, int minutes) {
        double onehourangle = 360 / 12.0;  //30
        double oneminangle = 360 /60 * 1.0; //6

        double minagnle = minutes * oneminangle;
        double hourangle = onehourangle * hour + (minutes / 60.0) * onehourangle;

        double angle = Math.abs(minagnle - hourangle);

        return Math.min(angle, 360 - angle);
    }
}
