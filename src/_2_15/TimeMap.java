package _2_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    class Temp{
        String value;
        int timestamp;
        Temp(String value,int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    Map<String, List<Temp>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Temp> l = map.get(key);
            Temp temp = new Temp(value,timestamp);
            boolean flag = false;
            for (int i = l.size()-1; i >=0 ; i--) {
                Temp te = l.get(i);
                if(timestamp>=te.timestamp){
                    l.add(i+1,temp);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                l.add(0,temp);
            }
        }else{
            Temp temp = new Temp(value,timestamp);
            List<Temp> l = new ArrayList<>();
            l.add(temp);
            map.put(key,l);
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Temp> l = map.get(key);
            for (int i = l.size()-1; i >=0 ; i--) {
                Temp temp = l.get(i);
                if(temp.timestamp<=timestamp)
                    return temp.value;
            }
        }
        return "";
    }
}
