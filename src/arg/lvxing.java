package arg;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lvxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int array[] = new int[n+1];
        int st[] = new int[n+1];
        int en[] = new int[n+1];
        for(int i = 0; i< n-1;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            array[start] = end;
            st[start] +=1;
            en[end]+=1;
        }
        int sta = 0;
        int count = 1;
        for (int i = 1; i <n ; i++) {
            if(st[i] == 1&&en[i] ==0){
                System.out.println(i);
                sta = i;
                break;
            }
        }
        while(count<n){
            System.out.println(array[sta]);
            sta = array[sta];
            count ++;
        }
    }
}
