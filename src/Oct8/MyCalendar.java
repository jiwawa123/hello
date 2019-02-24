package Oct8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCalendar {
    public static void main(String[] args) {
        int arr[] = {};



    }
    List<Integer> list = new ArrayList();
    public MyCalendar() {

    }
    public boolean book(int start, int end) {
        if(list.size()==0){
            for(int i = start ;i<end;i++)
                list.add(i);
            return true;
        }
        int i = 0, j = list.size()-1;
        int med = (i+j)/2;
        while(i<=j){
            if(list.get(med)==start)
                return false;
            else if(list.get(med)<start)
                i = med+1;
            else
                j = med-1;
            med = (i+j)/2;
        }
        if(i==list.size())
        {
            List<Integer> temp = new ArrayList<>();
            for (int k = 0; k < list.size(); k++) {
                temp.add(list.get(k));
            }
            for(int k = start;k<end;k++){
                temp.add(k);
            }
            list = temp;
            return true;
        }else{
            if(list.get(i)<end)
                return false;
            else{
                List<Integer> temp = new ArrayList<>();
                for(int k = start;k<end;k++){
                    temp.add(k);
                }
                for(int k = i; k<list.size(); k++)
                    temp.add(list.get(k));
                list = temp;
                return true;
            }
        }
    }
    public boolean isNStraightHand(int[] hand, int W) {
        return false;
    }
}
