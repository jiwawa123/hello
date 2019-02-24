package Exam;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int v = sc.nextInt();
        int arr[][] = new int[h][v];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < v; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < v; i++) {
            for (int j = h-1; j >=0; j--) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
}
