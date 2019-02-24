package arg;

import java.util.HashMap;
import java.util.Map;

public class Move {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Move_k(2,array);
        for(Integer k : array){
            System.out.println(k);
        }
    }
    /*
    算法的理解，
     */
    public  static void Move_k(int k,int[] array){
        int n = array.length;
        for(int i=0;i<k;i++){
            int t=array[n-k+i];
            for(int j=0;j<n-k;j++){
                array[n-k+i-j]=array[n-k+i-j-1];
            }
            array[i]=t;
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<numbers.length;i++){
            map.put(numbers[i],i);
        }
        for(Integer i :map.keySet()){
            if(map.containsKey(target-i)){
                result[0] = map.get(i);
                result[1] = map.get(target-i);
            }
        }
        return result;
    }



    }
