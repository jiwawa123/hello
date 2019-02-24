package Dec18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Opeator {
    //使用分治的思想进行相应的计算
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c=='*'||c=='+'||c=='-'){
                List<Integer> l1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
                for (int a:l1
                     ) {
                    for (int b:l2
                         ) {
                        if(c=='*')
                            res.add(a*b);
                        if(c=='+')
                            res.add(a+b);
                        if(c=='-')
                            res.add(a-b);
                    }
                }
            }
        }
        if(res.isEmpty())
            res.add(Integer.valueOf(input));
        return res;
    }
    public int hIndex(int[] citations) {
        Map<Integer,Integer> map = new HashMap<>();
        if(citations==null||citations.length==0)
            return 0;
        if(citations.length==1&&citations[0]==0)
            return 0;
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if(map.containsKey(citations[j]))
                    continue;
                if(citations[j]<i+1)
                    count++;
                else{
                    map.put(citations[j],count);
                    break;
                }

            }

            if((citations.length - count)>=i+1)
                max = Math.max(max,i+1);
        }
        return max;
    }

    public static void main(String[] args) {
        new Opeator().diffWaysToCompute("2-1-1");
    }
}
