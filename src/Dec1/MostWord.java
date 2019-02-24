package Dec1;

import java.util.HashMap;

public class MostWord {
    public static void main(String[] args) {

    }
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph.replaceAll(","," ");
        paragraph.replaceAll("."," ");
        HashMap<String,Integer> string = new HashMap<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (String str:banned
             ) {
            string.put(str,1);
        }
        String[] re = paragraph.split(" ");
        for (int i = 0; i < re.length; i++) {
            if(string.containsKey(getResult(re[i])))
                map.put(getResult(re[i]),map.getOrDefault(getResult(re[i]),0)+1);
        }
        String result = "";
        int index = 0;
        for (String str:map.keySet()
             ) {
            if(map.get(str)>index){
                index = map.get(str);
                result = str;
            }
        }
        return result;

    }
    public String getResult(String re){
        String result = "";
        for (int i = 0; i < re.length(); i++) {
            if((re.charAt(i)>='a'&&re.charAt(i)<='z'))
                result += re.charAt(i)+"";
        }
        return result;
    }
    public boolean checkRecord(String s) {

        int count = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='A')
                count++;
        }
        return !s.contains("LL")&&count<2;
    }
}
