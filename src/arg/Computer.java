package arg;


import java.util.Scanner;

public class Computer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = "";
        int count = 0;
        int allCount = 0;
        for (int i = 0; i < n; i++) {
                String tmpname = sc.next();
                int g1 = sc.nextInt();
                int g2 = sc.nextInt();
                String g3 = sc.next();
                String g4 = sc.next();
                int g5 = sc.nextInt();
                int tmpCount = first(g1,g5)+second(g1,g2)+third(g1)+fourth(g1,g4)+fiveth(g2,g3);
                allCount += tmpCount;
                if(tmpCount>count){
                    count = tmpCount;
                    name = tmpname;
                }

        }
        System.out.println(name);
        System.out.println(count);
        System.out.println(allCount);
    }
    public static int first(int g1,int g5){
        if(g1>80&&g5>0)
            return 8000;
        return 0;
    }
    public static  int second(int g1,int g2){
        if(g1>85&&g2>80)
            return 4000;
        return 0;
    }
    public  static int third(int g1){
        if(g1>90)
            return 2000;
        return 0;
    }
    public static int fourth(int g1,String g4){
        if(g1>85&&g4.equals("Y"))
            return 1000;
        return 0;
    }
    public static int fiveth(int g2,String g3){
        if(g2>80&&g3.equals("Y"))
            return 850;
        return 0;
    }
}
