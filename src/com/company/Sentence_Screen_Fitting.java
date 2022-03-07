package com.company;

public class Sentence_Screen_Fitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int spaceleft = cols;
        int cycle= 0;
        int currow =0;

        while(currow < rows)
        {
            for(String word : sentence)
            {
                int wordlength = word.length();
                if(wordlength> cols)
                    return 0;

                if(spaceleft - wordlength  >= 0)
                {
                    spaceleft -= wordlength;
                    spaceleft--;
                }else
                {
                    currow++;
                    spaceleft = cols;
                    spaceleft -= wordlength;
                    spaceleft--;
                }
            }
            cycle++;
        }
        return cycle;

    }

}
