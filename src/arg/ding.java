package arg;

import java.util.Scanner;

public class ding {
    public static void main(String[] args) {
        double Pai = 3.14159;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double r = sc.nextDouble();
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double result = r*2*Pai;
        double z1 = x;
        double z2 = y;
        for (int i = 0; i < n-1 ; i++) {
            double m =  sc.nextDouble() ;
            double k = sc.nextDouble();
            result += distance(x,m,y,k);
            x = m;
            y = k;
        }
        result += distance(z1,x,z2,y);
        System.out.println((double)Math.round(result*100)/100);
    }
    public static double distance(double a,double b,double c,double d){
        return Math.sqrt((a-b)*(a-b)+(c-d)*(c-d));
    }

}
