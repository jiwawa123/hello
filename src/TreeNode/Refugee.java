package TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Refugee {
    public int age;
    public int point;
    public String name;
    public String sex;
    public Refugee(String name,String sex,int age,int point){
        this.age = age;
        this.name = name;
        this.point = point;
        this.sex = sex;
    }
    public  String toString(){
        return  this.name;
    }
    public static void Sort(List<Refugee> list){
        Collections.sort(list, new Comparator<Refugee>() {
            @Override
            public int compare(Refugee o1, Refugee o2) {
                if(o1.age<=12&&o2.age<=12){
                    if(o1.sex.equals("female")&&o2.sex.equals("female")){
                        if(o1.point>o2.point){
                            return -1;
                        }else{
                            return 1;
                        }
                    }else{
                        if(o1.sex.equals("female"))
                            return -1;
                        if(o2.sex.equals("female"))
                            return 1;
                        return -1;
                    }
                }else{
                    if(o1.age<=12){
                        return -1;
                    }
                    if(o2.age<=12){
                        return 1;
                    }
                    return 1;
                }
            }
        });
    }

    public static void main(String[] args) {
        List<Refugee> list = new ArrayList<Refugee>();
        //此处添加人员信息，略
        Sort(list);

    }
}
