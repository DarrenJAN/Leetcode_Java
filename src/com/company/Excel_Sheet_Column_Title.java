package com.company;

public class Excel_Sheet_Column_Title {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while(columnNumber > 0)
        {
            int letter = (columnNumber -1) % 26;
            columnNumber = ( columnNumber-1) / 26;

            stringBuilder.append( (char) (letter + 'A'));
        }
        return stringBuilder.reverse().toString();
    }
}
