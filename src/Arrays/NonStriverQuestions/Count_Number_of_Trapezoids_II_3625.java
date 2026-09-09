package Arrays.NonStriverQuestions;

import java.util.*;

public class Count_Number_of_Trapezoids_II_3625 {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Slope, Map<Long, Integer>> lines = new HashMap<>();
        Map<Midpoint, Map<Slope, Integer>> mids = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];

            for (int j = 0; j < i; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1, dy = y2 - y1;

                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;

                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }

                Slope s = new Slope(dx, dy);
                long c = (long) dx * y1 - (long) dy * x1;

                lines.computeIfAbsent(s, k -> new HashMap<>())
                        .merge(c, 1, Integer::sum);

                Midpoint m = new Midpoint((long) x1 + x2, (long) y1 + y2);

                mids.computeIfAbsent(m, k -> new HashMap<>())
                        .merge(s, 1, Integer::sum);
            }
        }

        long ans = 0;

        for (Map<Long, Integer> map : lines.values()) {
            long sum = 0;
            for (int count : map.values()) {
                ans += sum * count;
                sum += count;
            }
        }

        for (Map<Slope, Integer> map : mids.values()) {
            long sum = 0;
            for (int count : map.values()) {
                ans -= sum * count;
                sum += count;
            }
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static class Slope {
        int dx, dy;

        Slope(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Slope)) return false;
            Slope s = (Slope) o;
            return dx == s.dx && dy == s.dy;
        }

        public int hashCode() {
            return 31 * dx + dy;
        }
    }

    static class Midpoint {
        long x, y;

        Midpoint(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Midpoint)) return false;
            Midpoint m = (Midpoint) o;
            return x == m.x && y == m.y;
        }

        public int hashCode() {
            return 31 * Long.hashCode(x) + Long.hashCode(y);
        }
    }
}
