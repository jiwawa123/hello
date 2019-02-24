package reflact;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class MyReflection {
    public static void main(String[] args) throws Exception{
        /*
        利用反射机制从而实现在list<Integer>里面添加string
         */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        Class class1 = list.getClass();
        Method method = class1.getMethod("add",Object.class);
        method.invoke(list,"ddd");
        System.out.println(list);
    }
}
