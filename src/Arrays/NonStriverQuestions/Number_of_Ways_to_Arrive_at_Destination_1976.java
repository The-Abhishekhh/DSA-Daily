package Arrays.NonStriverQuestions;

import java.util.*;

public class Number_of_Ways_to_Arrive_at_Destination_1976 {

    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {


        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            long currDist = current[0];
            int node = (int) current[1];

            if (currDist > dist[node]) {
                continue;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int time = edge[1];

                long newDist = currDist + time;

                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    ways[next] = ways[node];

                    pq.offer(new long[]{newDist, next});
                }

                else if (newDist == dist[next]) {

                    ways[next] =
                            (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
