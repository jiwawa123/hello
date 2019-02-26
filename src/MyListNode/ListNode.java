package MyListNode;
/*
    user ji
    data 2019/2/25
    time 11:30 AM
*/

import java.util.HashMap;
import java.util.Map;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    Map<Integer,Integer> map;
    public ListNode detectCycle(ListNode head) {
        map = new HashMap();
        ListNode tmp = head;
        while(tmp!=null){
            if(map.containsKey(tmp.val))
                return tmp;
            map.put(tmp.val,1);
            tmp = tmp.next;
        }
        return null;
    }
}
