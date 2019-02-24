public class Palindrome {
    public static boolean isPalindrome(String str) {
        if(str.equals("")||null==str)
            return true;
        int i = 0,j = str.length()-1;
        while(i<=j){
            while(!isNP(str.charAt(i))&&i<j)
                i++;
            while(!isNP(str.charAt(j))&&i<j)
                j--;
            if(Character.isDigit(str.charAt(i))&&Character.isLetter(str.charAt(j)))
                return false;
            if(Character.isDigit(str.charAt(j))&&Character.isLetter(str.charAt(i)))
                return false;
            if((str.charAt(i)!=str.charAt(j)&&(str.charAt(i)+32!=str.charAt(j))&&(str.charAt(i)!=32+str.charAt(j))))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static boolean isNP(char ch){
        return Character.isLetter(ch)||Character.isDigit(ch);
    }

    public static void main(String[] args) {
        System.out.print(isPalindrome("0P"));
    }
}
