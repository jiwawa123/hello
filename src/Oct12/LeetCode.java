package Oct12;

import java.sql.SQLOutput;
import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println(new LeetCode().customSortString("cba","abcd"));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap = new HashMap();
        for(String str:strs){
            char c[] = str.toCharArray();
            Arrays.sort(c);
            if(hashMap.containsKey(String.valueOf(c))){
                List<String> l = hashMap.get(String.valueOf(c));
                l.add(str);
                hashMap.put(String.valueOf(c),l);
            }else{
                List<String> l = new ArrayList<>();
                l.add(str);
                hashMap.put(String.valueOf(c),l);
            }
        }
        List<List<String>> re = new ArrayList<>();
        for (String k: hashMap.keySet()
             ) {
            re.add(hashMap.get(k));
        }
        return re;
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        String temp = "";
        for (int i = 0; i < licensePlate.length(); i++) {
            if(licensePlate.charAt(i)>='a'&&licensePlate.charAt(i)<='z'){

                    temp+=licensePlate.charAt(i);

            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);

        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (String str:list
             ) {
            if(containsAll(temp,str))
                return str;
        }
        return "";
    }
    public boolean containsAll(String a,String b){
        if(a.length()>b.length())
            return false;
        for (int i = 0; i < b.length(); i++) {
            if(b.indexOf(a.charAt(i))==-1)
                return false;
            else
                b = b.substring(0,b.indexOf(a.charAt(i)))+b.substring(b.indexOf(a.charAt(i))+1,b.length());
        }
        return true;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i),map.getOrDefault(magazine.charAt(i),0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(!map.containsKey(ransomNote.charAt(i))||map.get(ransomNote.charAt(i))<=0){
                return false;
            }else{
                map.put(ransomNote.charAt(i),map.getOrDefault(ransomNote.charAt(i),0)-1);
            }
        }
        return true;
    }
    public String customSortString(String S, String T) {

        List<Character> list = new ArrayList();
        for (int i = 0; i < T.length(); i++) {
            list.add(T.charAt(i));
        }
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return S.indexOf(o1) - S.indexOf(o2);
            }
        });
        String re = "";
        for (Character a:list
             ) {
            re+=a;
        }
        return re;
    }
}
