package Home_Web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        new Main().CountUserItem("");
    }
    public void CountUserItem(String path){
        File file = new File("/Users/ji/Downloads/yelp_deal/300.txt");
        Set<String> user = new HashSet<>();
        Set<String> item = new HashSet<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while((tempString=reader.readLine())!=null){
                String str[] = tempString.split(" ");
                user.add(str[0]);
                item.add(str[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(user.size()+" "+item.size());
    }
}
