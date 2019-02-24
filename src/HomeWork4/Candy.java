package HomeWork4;

import java.util.*;

public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
            System.out.println(0);
            return;
        }
        List<Integer> l = new ArrayList();
        for (int i = 0; i < n; i++) {
            l.add(sc.nextInt());
        }
        if(n==2){
            System.out.println(l.get(0)+l.get(1));
            return;
        }
        Collections.sort(l);
        int count = 0;
        while(l.size()>1){
            int temp=l.get(0)+l.get(1);
            l.remove(0);
            l.remove(0);
            l.add(temp);
            count+=temp;
            Collections.sort(l);
        }
        System.out.println(count);

    }
}
