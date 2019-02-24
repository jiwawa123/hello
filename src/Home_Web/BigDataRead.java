package Home_Web;

import java.io.*;

public class BigDataRead {

    public static void main(String[] args) throws IOException {
        long timer = System.currentTimeMillis();
        int bufferSize = 20 * 1024 * 1024;//设读取文件的缓存为20MB
        //建立缓冲文本输入流
        File file = new File("/Users/ji/Downloads/yelp_dataset");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //注意这里有时会乱码，根据自己的文本存储格式，进行调整
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream,"utf-8");
        BufferedReader input = new BufferedReader(inputStreamReader, bufferSize);
        //要分割的块数减一,这里表示分割为50个文件
        int splitNum = 5000;
        //9329093表示我的输入本文的行数
        int fileLines = 9329093;
        //分割后存储每个块的行数
        long perSplitLines = fileLines / splitNum;
        for (int i = 0; i <= splitNum; ++i){
            //分割
            //每个块建立一个输出
            File f=new File("/Users/ji/Downloads/yelp/" + i + ".txt");
            if(!f.exists())
                f.createNewFile();
            BufferedWriter output = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(new File("/Users/ji/Downloads/yelp/" + i + ".txt")),"UTF-8"));
            String line = null;
            //逐行读取，逐行输出
            for (long lineCounter = 0; lineCounter < perSplitLines && (line = input.readLine()) != null; ++lineCounter)
            {
                output.append(line + "\r");
            }
            output.flush();
            output.close();
            output = null;
        }
        input.close();
        timer = System.currentTimeMillis() - timer;
        System.out.println("处理时间：" + timer);
    }

}