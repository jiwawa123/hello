package Dec18;

import java.util.*;

public class ConnectEmail {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("John");
        l.add("johnsmith@mail.com");
        l.add("john_newyork@mail.com");
        list.add(l);
        l = new ArrayList<>();
        l.add("John");
        l.add("johnsmith@mail.com");
        l.add("john00@mail.com");
        list.add(l);
        l = new ArrayList<>();
        l.add("John");
        l.add("johnnybravo@mail.com");
        list.add(l);
        l = new ArrayList<>();
        l.add("Mary");
        l.add("mary@mail.com");
        list.add(l);
        new ConnectEmail().accountsMerge(list);
    }
    class Accout{
        public String name;
        public Map<String,Integer> email;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Accout> list = new ArrayList<>();
        //List<String> tmp = new ArrayList<>();
        for (int i = 0; i <accounts.size() ; i++) {
            List<String> tp = accounts.get(i);
            String name = tp.get(0);
            boolean flag = false;
            for (int j = 0; j < list.size(); j++) {
                Accout tmp = list.get(j);
                if(!tmp.name.equals(name))
                    continue;
                Map<String,Integer> map = tmp.email;
                for (int k = 1; k < tp.size(); k++) {
                    if(map.containsKey(tp.get(k))){
                        for (int l = 1; l < tp.size(); l++) {
                            map.put(tp.get(l),1);
                        }
                        flag = true;
                        tmp.email = map;
                        list.set(j,tmp);
                        if(flag)
                            break;
                    }
                }
                if(flag)
                    break;
            }
            if(!flag){
                    Accout accout = new Accout();
                    accout.name = name;
                    Map<String,Integer> email = new HashMap<>();
                    for (int j = 1; j <tp.size() ; j++) {
                        email.put(tp.get(j),1);
                    }
                    accout.email = email;
                    list.add(accout);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <list.size(); i++) {
            List<String> l = new ArrayList<>();
            Accout accout = list.get(i);
            l.add(accout.name);
            for (String k: accout.email.keySet()
                 ) {
                l.add(k);
            }
            res.add(l);
        }
        return  res;
    }
}
