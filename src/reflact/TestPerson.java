package reflact;

import java.lang.reflect.Constructor;

public class TestPerson {
    public static void main(String[] args) throws Exception{
        Class class1 = Class.forName("reflact.Person");
        Constructor constructor = class1.getConstructor(int.class,String.class);
        Person p = (Person)constructor.newInstance(3,"xiaoming");
        System.out.println(p.toPersonString());
    }
}
