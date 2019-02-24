package Dec26;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KuoHao {
    public int scoreOfParentheses(String S) {
        int res = 0;
        if(null==S||S.equals(""))
            return res;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char a = S.charAt(i);
            switch (a){
                case '(':
                    list.push(a+"");
                    break;
                case ')':
                    String t = list.pop();
                    if(t.equals(")"))
                    {
                        list.push(1+"");
                    }else{
                        int tmp = Integer.valueOf(t);
                        tmp*=2;
                        while(true){
                            t = list.pop();
                            if(t == "("){
                                res = res * 2;
                                list.push(Integer.toString(res));
                                break;
                            }else{
                                res = Integer.parseInt(t) + res;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
