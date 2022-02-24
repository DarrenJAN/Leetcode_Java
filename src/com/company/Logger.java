package com.company;

import java.util.HashMap;
import java.util.HashSet;

class Logger {
    HashMap<String, Integer> hashMap;

    public Logger() {
        hashMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if( !hashMap.containsKey(message))
        {
            hashMap.put(message, timestamp);
            return true;
        }else
        {
            int last = hashMap.get(message);
            if(last + 10 >= timestamp) {
                hashMap.put(message, timestamp);
                return true;
            }
            else
                return false;

        }
    }
}
