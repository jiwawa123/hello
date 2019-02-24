package Dec1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class WordDictionary {
    Map<Integer,Set<String>> map = new HashMap();
    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(map.containsKey(word.length())){
            Set<String> s = map.get(word.length());
            s.add(word);

            map.put(word.length(),s);
        }else{
            Set<String> s = new TreeSet<>();
            s.add(word);
            map.put(word.length(),s);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(!map.containsKey(word.length())){
            return false;
        }else{
            Set<String> s =new TreeSet<>();
            for (String str:s
                    ) {
                if(pan(word,str))
                    return true;
            }
        }
        return false;
    }
    public boolean pan(String a,String b){
        if(a.length()!=b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!='.'&&a.charAt(i)!=b.charAt(i))
                return false;
        }

        return  true;
    }
}
