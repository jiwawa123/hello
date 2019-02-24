package Dec18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopVotedCandidate {
    class Vote{
        int candidate;
        int time;
    }
    List<Vote> l = new ArrayList();

    public TopVotedCandidate(int[] persons, int[] times) {
        for (int i = 0; i < persons.length; i++) {
            Vote vote = new Vote();
            vote.candidate = persons[i];
            vote.time = times[i];
            l.add(vote);
        }
    }

    public int q(int t) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //用来记录最近投票的时间
        Map<Integer,Integer> tt = new HashMap<>();
        int times = 0;
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i).time>t){
                break;
            }else{
                map.put(l.get(i).candidate,map.getOrDefault(l.get(i).candidate,0)+1);
                times = Math.max(times,map.get(l.get(i).candidate));
                tt.put(l.get(i).candidate,l.get(i).time);
            }
        }
        List<Integer> lll = new ArrayList<>();
        for (int k :map.keySet()
             ) {
            if(map.get(k)==times)
                lll.add(k);
        }
        int max = 0;
        for (int i = 0; i < lll.size(); i++) {
            if(tt.get(lll.get(i))>max){
                max = tt.get(lll.get(i));
                res = lll.get(i);
            }
        }
        return res;
    }
}
