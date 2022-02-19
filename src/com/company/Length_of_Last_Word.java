package com.company;

public class Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[]a = s.split(" ");
        return a[a.length-1].length();
    }
}
