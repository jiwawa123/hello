package Dec5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    List<Integer> l = new ArrayList();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger tmp:nestedList
             ) {
            deal(tmp);
        }
    }
    public void deal(NestedInteger ni){
        if(ni.isInteger()){
            l.add(ni.getInteger());
            return;
        }else{
            List<NestedInteger> l = ni.getList();
            for (NestedInteger tmp:l
                 ) {
                deal(tmp);
            }
        }
    }
    @Override
    public Integer next() {
        int val = l.get(0);
        l.remove(0);
        return val;
    }

    @Override
    public boolean hasNext() {
        return !l.isEmpty();
    }
}
