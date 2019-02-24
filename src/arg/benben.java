package arg;

import java.util.*;

public class benben {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Integer> map =new HashMap<>();
        //将map里面加入词典
        String abc = sc.next();
        for (int i = 0; i < 26 ; i++) {
            map.put(abc.charAt(i),i);
        }
        int n = sc.nextInt();
        String array[] = new String[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.next();
        Arrays.sort(array,new Comparator<String>() {
            public int compare(String string1, String string){
                if(pan(string1,string,map))
                    return 1;
                return -1;
            }
        });
        int k = sc.nextInt();
        if(k==1)
            for (int i = 0; i < n; i++)
                System.out.println(array[i]);
        else
            for (int i = n-1; i >=0; i--)
                System.out.println(array[i]);


    }

    public static boolean pan(String a,String b,Map<Character,Integer> map){
        int len = 0;
        while(len < a.length()&&len<b.length()){
            if(map.get(a.charAt(len))>map.get(b.charAt(len))){
                return true;
            }
            if(map.get(a.charAt(len))<map.get(b.charAt(len)))
                return false;
            len++;
        }
        if(a.length()>b.length()){
            return true;
        }
        return false;
    }
}
