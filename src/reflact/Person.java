package reflact;
/*
实现序列化，将对象序列化写入文件，然后通过对象的形式读取出来
 */
import java.io.*;

public class Person implements Serializable {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toPersonString() {
        return "name：" + this.name + " age:" + this.age;
    }

    public static void main(String[] args) {
        File file = new File("/Users/ji/test.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person p = (Person) ois.readObject();
            System.out.println(p.toPersonString());
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
