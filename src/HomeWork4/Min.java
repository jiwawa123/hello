package HomeWork4;

import java.util.Arrays;
import java.util.Scanner;

public class Min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            int k = sc.nextInt();
            int arr[] = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = sc.nextInt();
            }
            if (arr.length == 2) {
                System.out.println(Math.abs(arr[0] - arr[1]));
            }else{
                System.out.println(minAbs(arr));
            }
        }
    }

    public static int minAbs(int arr[]) {
        Arrays.sort(arr);
        String a = "", b = "";
        boolean flag[] = new boolean[arr.length];
        Arrays.fill(flag, true);
        //判断是奇数的情况
        if (arr.length % 2 != 0) {
            int k = 0;
            if(arr[0]==0){
                arr[0] = arr[1];
                arr[1] = 0;
            }
            for (int i=0;i<arr.length/2+1;i++)
                a+=arr[i]+"";
            for (int i=arr.length-1;i>=arr.length/2+1;i--)
                b+=arr[i]+"";
            return Math.abs(Integer.valueOf(a) - Integer.valueOf(b));
        } else {//判断是偶数的情况
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 1; i <arr.length ; i++) {
                if(arr[i]-arr[i-1]<min&&arr[i-1]!=0){
                    min = arr[i]-arr[i-1];
                    index = i-1;
                }
            }
            a+=arr[index]+"";
            b+=arr[index+1]+"";
            for (int i = 0; i < arr.length; i++) {
                if(i!=index&&i!=index+1)
                    b+=arr[i]+"";
                if(b.length()==arr.length/2)
                    break;
            }
            for (int i = arr.length-1; i >=0 ; i--) {
                if(i!=index&&i!=index+1)
                    a+=arr[i]+"";
                if(a.length()==arr.length/2)
                    break;
            }
            return Math.abs(Integer.valueOf(a) - Integer.valueOf(b));
        }
    }
}
