import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelfDil {
    public static void main(String[] args) {
        SelfDil selfDil = new SelfDil();
        System.out.println(selfDil.iselfdividing(21));
        
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(iselfdividing(i))
                list.add(i);
        }
        return list;
    }
    public boolean iselfdividing(int number){
        Map<Integer,Integer> map = new HashMap();
        int temp = number ;
        while(number/10!=0){
            if(number%10==0||temp%(number%10)!=0){
                return false;
            }
            number/= 10;
        }
        if(temp%(number%10)!=0){
            return false;
        }
        return true;
    }
}
