package Oct15;

public class Queue {
    public boolean isGood(int s){
        String tmp = s+"";
        String temp = "";
        for(int i = 0;i<tmp.length();i++){
           switch (tmp.charAt(i)){
               case '2':
                   temp+="5";
                   break;
               case '5':
                   temp+="2";
                   break;
               case '6':
                   temp+="9";
                   break;
               case '9':
                   temp+="6";
               case '4':
                   return false;
               case '7':
                   return false;
               case '3':
                   return false;
               default:
                   temp+=tmp.charAt(i);
                   break;
           }
        }
        return  !temp.equals(tmp);
    }
}
