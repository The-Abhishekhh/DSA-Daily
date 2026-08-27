package Arrays.NonStriverQuestions;

import java.util.*;

public class Critical_Connections_in_a_Network_1192 {
    private int time = 0;

    public List<List<Integer>> criticalConnections(
            int n, List<List<Integer>> connections) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] discovery = new int[n];
        int[] low = new int[n];

        List<List<Integer>> result = new ArrayList<>();

        Arrays.fill(discovery, -1);

        dfs(0, -1, graph, discovery, low, result);

        return result;
    }

    private void dfs(
            int node,
            int parent,
            List<Integer>[] graph,
            int[] discovery,
            int[] low,
            List<List<Integer>> result) {

        discovery[node] = low[node] = time++;

        for (int next : graph[node]) {

            if (next == parent) {
                continue;
            }

            if (discovery[next] != -1) {

                low[node] = Math.min(
                        low[node],
                        discovery[next]
                );

            } else {

                dfs(
                        next,
                        node,
                        graph,
                        discovery,
                        low,
                        result
                );

                low[node] = Math.min(
                        low[node],
                        low[next]
                );

                if (low[next] > discovery[node]) {
                    result.add(
                            Arrays.asList(node, next)
                    );
                }
            }
        }
    }
}
