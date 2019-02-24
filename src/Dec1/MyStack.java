package Dec1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyStack {
    Map<Integer,Integer> map = new  HashMap<>();
    Stack<Integer> stack = new Stack<>();
    public void push(int x) {
        map.put(x,map.getOrDefault(x,0)+1);
        stack.push(x);
    }
    public void pop() {
        map.put(stack.peek(),map.getOrDefault(stack.peek(),0)-1);
        stack.pop();
    }
    public int top() {

        return  stack.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int k:map.keySet()
             ) {
            if(map.get(k)>0&&k<min)
                min = k;
        }
        return min;
    }
}
