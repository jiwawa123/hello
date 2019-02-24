package Dec1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number {
    public static void main(String[] args) {
        System.out.println(new Number().originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
    public String originalDigits(String s) {
        int arr[] = new int[10];
        Arrays.fill(arr,0);
        StringBuffer re = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'z':
                    arr[0]+=1;
                    break;
                case 'o':
                    arr[1]+=1;
                    break;
                case 'w':
                    arr[2]+=1;
                    break;
                case 'r':
                    arr[3]+=1;
                    break;
                case 'u':
                    arr[4]+=1;
                    break;
                case 'f':
                    arr[5]+=1;
                    break;
                case 'x':
                    arr[6]+=1;
                    break;
                case 's':
                    arr[7]+=1;
                    break;
                case 'g':
                    arr[8]+=1;
                    break;
                case 'i':
                    arr[9]+=1;
                    break;
            }
        }
        arr[7]-=arr[6];
        arr[5]-=arr[4];
        arr[9]=arr[9] - (arr[5]+arr[6]+arr[8]);
        arr[1]=arr[1]- (arr[0]+arr[2]+arr[4]);

        arr[3]=arr[3] - (arr[4]+arr[0]);

        for (int i = 0; i < 10; i++) {
            System.out.println(i+" "+arr[i]);
            for (int j = 0; j < arr[i]; j++) {
                re.append(i);
            }
        }
        return re.toString();
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length==0)
            return list;
        int min = nums[0];
        int max = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]-max==1)
                max = nums[i];
            else{
                if(min==max){
                    list.add(min+"");
                }else{
                    list.add(min+"->"+max);
                }
                min = max = nums[i];
            }
        }
        if(min==max){
            list.add(min+"");
        }else{
            list.add(min+"->"+max);
        }
        return list;
    }
}
