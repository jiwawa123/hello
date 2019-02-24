package alter;

import java.util.ArrayList;
import java.util.List;

public class Second {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};
        System.out.println(Model(array));
    }
    public static int Model(int array[]){
        List<List<Integer>> list = dealArray(array);
        System.out.println(list.toString());
        return Mod(list)%(int)(Math.pow(10,9)+7);

    }
    public static  List<List<Integer>> dealArray(int[] array){
        List<List<Integer>> list = new ArrayList();
        int len = array.length;
        while(len>0){
            for (int i = 0; i < len; i++) {
                List<Integer> l = new ArrayList<>();
                for (int j = i; j < len; j++) {
                   l.add(array[j]) ;
                }
                list.add(l);
            }
            len --;
        }
        return list;
    }
    public static int Mod(List<List<Integer>> list){
        int count = 0;
        for(List<Integer> li: list){
            if(li.size()>0){
                int re = li.get(0);
                for(Integer k :li)
                    if(k<re)
                        re = k;
                count+=re;
            }
        }
        return count;
    }
}
