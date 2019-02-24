package alter;

import java.util.List;

public class LineUp {
    class Person{
        public String name;
        public String color;
    }
    public int line_length(List<Person> person, String color){
        for (int i = person.size(); i >0 ; i--) {
            if(person.get(i).color.equals(color)){
                person.remove(person.get(i));
            }
        }
        return person.size();
    }
}
