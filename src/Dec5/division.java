package Dec5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class division {

    public static void main(String[] args) {

    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        //make adjacent list
        // A-> (B, 2.0) (C, 3.0)
        Map<String, Map<String, Double>> map = new HashMap<>();
        for(int i = 0 ; i < equations.length; ++i){
            Map<String, Double> current = map.computeIfAbsent(equations[i][0], k -> new HashMap());
            current.put(equations[i][1], values[i]);
            current = map.computeIfAbsent(equations[i][1], k -> new HashMap());
            current.put(equations[i][0], 1 / values[i]);
        }

        //populate the result
        double[] result = new double[queries.length];
        for(int i = 0 ; i < queries.length; ++i){
            result[i] = dfs(queries[i][0], queries[i][1], map, new HashSet<String>());
        }
        return result;
    }

    private double dfs(String numerator, String denominator, Map<String, Map<String, Double>> map,HashSet<String> visited){
        if(visited.contains(numerator)) return -1;
        visited.add(numerator);
        Map<String, Double> adj = map.get(numerator);
        if(adj == null) return -1;
        if(adj.containsKey(denominator)){
            return adj.get(denominator);
        }
        for(String next: adj.keySet()){
            double ans = dfs(next, denominator, map, visited);
            if(ans != -1){
                return adj.get(next) * ans;
            }
        }
        return -1;
    }
}
