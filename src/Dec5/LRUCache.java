package Dec5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer,Integer> map = new LinkedHashMap<>();
    int max = 0;

    public LRUCache(int capacity) {
        max = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key))
            return map.get(key);
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        }else{
            if(map.size()<max){
                map.put(key,value);
            }else{
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                   map.remove(entry.getKey());
                   break;
                }
                map.put(key,value);
            }
        }
    }
}
