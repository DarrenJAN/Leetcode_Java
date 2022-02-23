package com.company;

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<s.length();i++)
        {
            char cur_char = s.charAt(i);

            if(Character.isAlphabetic(cur_char) || Character.isDigit(cur_char))
            {
                stringBuilder.append(cur_char);
            }
        }

        StringBuilder reverse = new StringBuilder(stringBuilder);
        reverse.reverse();

        return stringBuilder.toString().toLowerCase().equals(
                reverse.toString().toLowerCase()
        );
    }


}
