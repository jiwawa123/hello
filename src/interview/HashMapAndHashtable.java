package interview;/*
    user ji
    data 2019/3/26
    time 9:50 PM
*/

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashMapAndHashtable {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < 5; i++) {
            hashMap.put(i, i);
            hashtable.put(i, i);
        }
        Iterator iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println(key+" "+val);
        }
        System.out.println("======================");
        for (int k : hashtable.keySet()
                ) {
            System.out.println(k + " " + hashtable.get(k));
        }
    }
}
