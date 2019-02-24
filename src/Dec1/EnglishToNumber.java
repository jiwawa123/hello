package Dec1;

public class EnglishToNumber {
    public static void main(String[] args) {
        EnglishToNumber e = new EnglishToNumber();
        System.out.println(e.originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
    public String originalDigits(String s) {
        String  re = "";
        while(s.length()>0){
            if(isExist(s,"zero")){
                re+=0+"";
                s = deal(s,"zero");
            }
            if(isExist(s,"one")){
                re+=1+"";
                s = deal(s,"one");
            }
            if(isExist(s,"two")){
                re+=2+"";
                s = deal(s,"two");
            }
            if(isExist(s,"three")){
                re+=3+"";
                s = deal(s,"three");
                
            }
            if(isExist(s,"four")){
                re+=4+"";
                s = deal(s,"four");
                
            }
            if(isExist(s,"five")){
                re+=5+"";
                s = deal(s,"five");
                
            }
            if(isExist(s,"six")){
                re+=6+"";
                s = deal(s,"six");
                
            }
            if(isExist(s,"seven")){
                re+=7+"";
                s = deal(s,"seven");
                
            }
            if(isExist(s,"eight")){
                re+=8+"";
                s = deal(s,"eight");
                
            }
            if(isExist(s,"nine")){
                re+=9+"";
                s = deal(s,"nine");
                
            }
        }
        return re;
    }
    public boolean isExist(String s,String n){
        if(s.length()<n.length())
            return false;
        for (int i = 0; i < n.length(); i++) {
            if(s.indexOf(n.charAt(i))==-1)
                return false;
            else
                s = s.substring(0,s.indexOf(n.charAt(i)))+s.substring(s.indexOf(n.charAt(i))+1,s.length());
        }
        return true;
    }
    public String deal(String s,String n){
        for (int i = 0; i < n.length(); i++) {
            s = s.substring(0,s.indexOf(n.charAt(i)))+s.substring(s.indexOf(n.charAt(i))+1,s.length());
        }
        return s;
    }

}
