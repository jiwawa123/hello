package myThread;

public class MyThread extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        String words[] = {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"};
        System.out.println(new MyThread().expressiveWords("dddiiiinnssssssoooo",words));

    }
    public int expressiveWords(String S, String[] words) {
        int re = 0;
        for(String str:words){
            if(isExtend(S,str))
                re++;
        }
        return re;
    }
    public boolean isExtend(String a,String b){
        if(a.length()<=b.length())
            return false;
        int i = 0,j = 0;
        int count = 0;
        while(i<a.length()&&j<b.length()){
            char tmp = a.charAt(i);
            int count1 = 0;
            while(i<a.length()&&a.charAt(i)==tmp){
                i++;
                count1++;
            }
            if(tmp!=b.charAt(j))
                return false;
            int count2 = 0;
            while(j<b.length()&&b.charAt(j)==tmp){
                j++;
                count2++;
            }
            if(count2>count1||(count1!=count2&&count1<3))
                return false;


        }
        return i==a.length()&&j==b.length();
    }
}
