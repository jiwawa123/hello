package Oct8;


import Oct27.Leet;

import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println('a');
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList();
        for(int i = 1; i<= n;i++){
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -compareL(o1,o2);
            }
        });
        return list;
    }
    public int  compareL(int a,int b){
        String s1 = a+"";
        String s2 = b+"";
        int i = 0 ,j = 0;
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)>s2.charAt(j)){
                return -1;
            }else if(s1.charAt(i)<s2.charAt(j)){
                return 1;
            }else {
                i++;
                j++;
            }
        }
        return  s2.length() - s1.length();
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if(o1.getValue()!=o2.getValue()){
                    return o1.getValue() - o2.getValue();
                }else{
                    return  compareL(o1.getKey() ,o2.getKey());
                }
            }
        });

        List<String> l = new ArrayList<>();
        int index = Integer.MAX_VALUE;
        int count = 0;
        for(Map.Entry<String,Integer> mapping:list){
            l.add(mapping.getKey());
            count++;
            if(count==k)
                break;
        }
        Collections.sort(l);
        return l;
    }
    public int  compareL(String a,String b){
        String s1 = a+"";
        String s2 = b+"";
        int i = 0 ,j = 0;
        while(i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)>s2.charAt(j)){
                return -1;
            }else if(s1.charAt(i)<s2.charAt(j)){
                return 1;
            }else {
                i++;
                j++;
            }
        }
        return  s2.length() - s1.length();
    }
    public String addBinary(String a, String b) {
        StringBuffer re = new StringBuffer();
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();

        int next = 0;
        int i = 0,j = 0;
        while(i<a.length()&&j<b.length()){

            re.append((a.charAt(i)-'0'+(b.charAt(j)-'0')+next)%2);
            next = (a.charAt(i)-'0'+(b.charAt(j)-'0')+next)/2;
            i++;
            j++;
        }
        while(i<a.length()){
            re.append((a.charAt(i)-'0'+next)%2);
            next = (a.charAt(i)-'0'+next)/2;
            i++;
        }
        while(j<b.length()){
            re.append((b.charAt(j)-'0'+next)%2);
            next = (b.charAt(j)-'0'+next)/2;
            j++;
        }
        if(next!=0)
            re.append(next);
        return re.reverse().toString();
    }
    public boolean hasAlternatingBits(int n) {
        if(n<=1)
            return true;
        StringBuffer re = new StringBuffer();
        while(n>=2){
            re.append(n%2);
            n/=2;
        }
        if(n!=0)
            re.append(n);
        System.out.println(re);
        return  (!re.toString().contains("11"))&&(!re.toString().contains("00"));
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int m = s.length();
        Map<Character,Character> map = new HashMap();
        Map<Character,Character> map1 = new HashMap();
        for(int i = 0;i<m;i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))!=t.charAt(i))
                return false;
            else
                map.put(s.charAt(i),t.charAt(i));
            if(map1.containsKey(t.charAt(i))&&map1.get(t.charAt(i))!=s.charAt(i))
                return false;
            else
                map1.put(t.charAt(i),s.charAt(i));
        }

            return true;
    }
    public boolean isIso(String t,String ss){
        String s[] = ss.split(" ");
        if(s.length!=t.length())
            return false;
        int m = s.length;
        Map<String,Character> map = new HashMap();
        Map<Character,String> map1 = new HashMap();
        for(int i = 0;i<m;i++){
            if(map.containsKey(s[i])&&map.get(s[i])!=t.charAt(i))
                return false;
            else
                map.put(s[i],t.charAt(i));
            if(map1.containsKey(t.charAt(i))&&map1.get(t.charAt(i))!=s[i])
                return false;
            else
                map1.put(t.charAt(i),s[i]);
        }

        return true;
    }
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuffer(str[i]).reverse().toString();
        }
        String re = "";
        for (int i = 0; i < str.length; i++) {
            re+=str[i];
            if(i!=str.length-1)
                re+=" ";
        }
        return re;
    }
    public String toHex(int num) {
        String re = "";
        while(num>0){
            if(num%16>9){
                re+=""+(num%16-10+'a');
            }else{
                re+=""+num%16;
            }
                num/=16;

        }
        return new StringBuffer(re).reverse().toString();
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap();
        Map<String,Integer> map1 = new HashMap();
        Map<String,Integer> re = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i],i);
        }
        for (String s: map.keySet()
             ) {
            if(map1.containsKey(s)){
                re.put(s,map.get(s)+map1.get(s));
            }
        }
        int min = Integer.MAX_VALUE;
        for(String s: re.keySet()){
            if(re.get(s)<min)
                min = re.get(s);
        }
        String res = "";
        for (String s: re.keySet()
             ) {
            if(map.get(s)==min)
                res+=s+" ";
        }
        return res.split(" ");

    }
}
