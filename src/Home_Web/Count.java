package Home_Web;

import net.sf.json.JSONObject;

import java.io.*;
import java.util.*;

public class Count {
    public static void main(String[] args) throws Exception {
        long a = System.currentTimeMillis();
        countUserAndRest();
        System.out.println(System.currentTimeMillis() - a);
    }

    //进行文件的json格式的解析
    public static void dealReviewJson(String content, List<Review> list) {
        JSONObject obj = JSONObject.fromObject(content);
        Review r = new Review();
        r.setBusiness_id(obj.get("business_id").toString());
        r.setUser_id(obj.get("user_id").toString());
        r.setStarts((int) obj.get("stars"));
        r.setDate(obj.getString("date").toString());
        list.add(r);
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

    }

    public void CountUserItem(String path) {
        File file = new File("/Users/ji/Downloads/yelp_deal/yelp.txt");
        Set<String> user = new HashSet<>();
        Set<String> item = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                String str[] = tempString.split(" ");
                user.add(str[0]);
                item.add(str[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.size() + " " + item.size());
    }

    //餐馆的部分信息进行相应的提炼
    public static void writeRest() throws Exception {
        File file = new File("/Users/ji/Downloads/yelp_dataset");
        List<Rest> list = new ArrayList<>();
        BufferedReader reader = null;
        int index = 0;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            boolean flag = false;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("business_id") && tempString.contains("state") && tempString.contains("city")) {
                    if (tempString.charAt(0) == '{') {
                        flag = true;
                        index++;
                        dealRest(tempString, list);
                    }

                } else {
                    if (flag)
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        //将整个文件读取完之后开始将处理好之后的文件写入新的文件中
        File f = new File("/Users/ji/Downloads/yelp_deal/" + "resaurant.txt");
        if (!f.exists())
            f.createNewFile();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/ji/Downloads/yelp_deal/" + "resaurant.txt")), "UTF-8"));
        for (Rest r : list
                ) {
            output.append(r.toString() + "\n");
        }
        output.flush();
        output.close();
        System.out.println(index);
    }

    //解析数据将文件中包含评分的数据直接拿出来，然后写入文件
    public void writeReview() throws Exception {
        File file = new File("/Users/ji/Downloads/yelp_dataset");
        List<Review> list = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            boolean flag = false;
            int index = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("review_id")) {
                    flag = true;
                    if (index == 0) {
                        index++;
                    } else {
                        dealReviewJson(tempString, list);
                    }
                } else {
                    if (flag)
                        break;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        //将整个文件读取完之后开始将处理好之后的文件写入新的文件中
        File f = new File("/Users/ji/Downloads/yelp_deal/" + "yelp.txt");
        if (!f.exists())
            f.createNewFile();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/ji/Downloads/yelp_deal/" + "yelp.txt")), "UTF-8"));
        for (Review r : list
                ) {
            output.append(r.reviewToString() + "\n");
        }
        output.flush();
        output.close();
    }

    public static void dealRest(String content, List<Rest> l) {
        JSONObject obj = JSONObject.fromObject(content);
        Rest r = new Rest();
        r.setBusiness_id(obj.get("business_id").toString());
        r.setCity(obj.get("city").toString());
        r.setState(obj.get("state").toString());
        l.add(r);
    }

    //进行相应的统计，查看哪个州出现的餐馆数量最多
    public static void countRestByCity(String path) throws Exception {
        File file = new File(path);
        Map<String, Integer> map = new HashMap<>();
        String temp = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((temp = br.readLine()) != null) {
            String str[] =  temp.split(",");
            map.put(str[1],map.getOrDefault(str[1],0)+1);
        }
        for (String str:map.keySet()
             ) {
            System.out.println(str+" "+map.get(str));
        }
        br.close();

    }

    public static void  dealRating(String str1,String str2) throws Exception{
        List<String> l = new ArrayList<>();
        File file = new File(str1);
        Map<String, Integer> map = new HashMap<>();
        String temp = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((temp = br.readLine()) != null) {
            String str[] =  temp.split(",");
            if(str[1].equals("Scottsdale"))
                map.put(str[0],1);
        }
        br = new BufferedReader(new FileReader(new File("/Users/ji/Downloads/yelp_deal/yelp.txt")));
        while ((temp = br.readLine()) != null) {
            String str[] =  temp.split(" ");
            if(map.containsKey(str[1]))
                l.add(temp);
        }
        br.close();
        File f = new File("/Users/ji/Downloads/yelp_deal/" + "Scottsdale.txt");
        if (!f.exists())
            f.createNewFile();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/ji/Downloads/yelp_deal/" + "resaurant.txt")), "UTF-8"));
        for (String r : l
                ) {
            output.append(r + "\n");
        }
        output.flush();
        output.close();
    }
    //统计相应的用户数量和餐馆数量
    public static void countUserAndRest(){
        File file = new File("/Users/ji/Downloads/yelp_deal/Scottsdale.txt");
        Set<String> user = new HashSet<>();
        Set<String> rest = new HashSet<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String tmp = null;
            while((tmp=br.readLine())!=null){
                String str[] = tmp.split(" ");
                user.add(str[0]);
                rest.add(str[1]);
            }
            br.close();
            System.out.println("user"+user.size());
            System.out.println("rest"+rest.size());
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
