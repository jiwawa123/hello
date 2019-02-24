package Oct15;

import java.util.HashMap;
import java.util.Map;

public class Pill {
    public static void main(String[] args) {
        int arr[] = {5,5,10,10,20};
        System.out.println(lemonadeChange(arr));
    }
    public static boolean lemonadeChange(int[] bills) {
        if(bills.length==0)
            return true;
        Map<Integer,Integer> map =new HashMap<>();
        int count = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]){
                case 5:
                        count+=5;
                        map.put(5,map.getOrDefault(5,0)+1);
                        break;
                case 10:
                        if(map.containsKey(5)&&map.get(5)>0){
                            map.put(5,map.get(5)-1);
                            count+=10;
                            map.put(10,map.getOrDefault(10,0)+1);
                        }else{
                            return false;
                        }
                        break;
                case 20:
                        if(count<15)
                            return false;
                        else{
                            if(map.containsKey(5)&&map.get(5)>0){
                                if(map.containsKey(10)&&map.get(10)>0){
                                    map.put(5,map.get(5)-1);
                                    map.put(10,map.get(10)-1);
                                    count+=20;
                                    break;
                                }else{
                                    if(map.get(5)>=3){
                                        map.put(5,map.get(5)-3);
                                        count+=20;
                                        break;
                                    }else{
                                        return false;
                                    }
                                }
                            }else{
                                return false;
                            }
                        }
            }
        }
        return true;
    }
}
