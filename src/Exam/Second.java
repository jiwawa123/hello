package Exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = n-1; i >=0; i -- ) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n-1; i++) {
            if(arr[i] >arr[i+1]){
                arr[i+1] = arr[i];
                set.add(i+1);
            }
        }
        System.out.println(set.size());
    }
}
