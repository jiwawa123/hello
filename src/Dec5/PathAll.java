package Dec5;

import java.util.ArrayList;
import java.util.List;

public class PathAll {
    int n ;
    List<List<Integer>> list ;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        list = new ArrayList<>();
        List<Integer> l = new ArrayList();
        for (int i = 0; i < graph[0].length; i++) {
            l = new ArrayList<>();
            l.add(0);
            add(l,graph,graph[0][i]);
        }
        return list;
    }
    public void add(List<Integer> l,int[][] graph,int k){
        if(k==n-1){
            List ll = new ArrayList(l);
            ll.add(k);
            list.add(ll);
            return ;
        }
        l.add(k);
        int arr[] = graph[k];
        if(null==arr||arr.length==0){
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            add(l,graph,arr[i]);
        }
    }
}
