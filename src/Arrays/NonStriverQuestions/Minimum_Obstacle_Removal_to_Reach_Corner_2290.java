package Arrays.NonStriverQuestions;

public class Minimum_Obstacle_Removal_to_Reach_Corner_2290 {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];

        for (int[] row : dist)
            java.util.Arrays.fill(row, Integer.MAX_VALUE);

        java.util.ArrayDeque<int[]> dq = new java.util.ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        dist[0][0] = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1)
                return dist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int cost = dist[r][c] + grid[nr][nc];

                if (cost < dist[nr][nc]) {
                    dist[nr][nc] = cost;

                    if (grid[nr][nc] == 0)
                        dq.offerFirst(new int[]{nr, nc});
                    else
                        dq.offerLast(new int[]{nr, nc});
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}
