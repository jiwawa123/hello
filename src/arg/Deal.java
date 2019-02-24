package arg;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Deal {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/ji/Downloads/data.txt"),"GBK"));
        String str = null;
        Map<String,Integer> map =new HashMap<>();
        int count = 1;
        while ((str = in.readLine()) != null) {
            String[] string = str.split(",");
            //写入相关文件
            if(!map.containsKey(string[2])){

                map.put(string[2],count);
                count++;
            }
        }
        in.close();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/ji/Downloads/data.txt"),"GBK"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/ji/Downloads/data1.txt"),"GBK"));
        String ss = null;
        while((str = in1.readLine())!=null){
            String[] string = str.split(",");
            str +=","+map.get(string[2]);
            out.write(str);
            out.newLine();
        }
        in1.close();
        out.close();
    }
}
