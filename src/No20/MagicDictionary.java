package No20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {
    Map<Integer,List<String>> map = new HashMap();
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str: dict
             ) {
            if(map.containsKey(str.length())){
                List<String> list = map.get(str.length());
                list.add(str);
                map.put(str.length(),list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(str.length(),list);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(!map.containsKey(word.length())){
            return false;
        }else{
            List<String> l = map.get(word.length());
            for (String s:l
                 ) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)!=word.charAt(i))
                        count++;
                    if(count>1){
                        break;
                    }
                }
                if(count<=0)
                    return true;
            }
        }
        return false;
    }
}
