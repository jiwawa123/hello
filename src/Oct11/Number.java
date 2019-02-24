package Oct11;

import java.util.ArrayList;
import java.util.List;

public class Number {
    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        List<String> list =new ArrayList<>();
        String string[] = new String[10];
        string[2] = "abc";
        string[3] = "edf";
        string[4] = "ghi";
        string[5] = "jkl";
        string[6] = "mno";
        string[7] = "pqrs";
        string[8] = "tuw";
        string[9] = "wxyz";
        String str[] = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i);
            str[i] = string[c];

        }
        return list;
    }
    public void addList(List<String> list ,String str[]){

        for (int i = 0; i < str.length; i++) {

        }
    }
}
