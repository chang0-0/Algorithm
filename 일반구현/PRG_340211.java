package PRG_340211;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class PRG_340211 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/340211

    private static class Coordinate {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate coordinate = (Coordinate) o;
            return x == coordinate.x && y == coordinate.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Coordinate{" + "x=" + x + ", y=" + y + '}';
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};


        bw.write(solve(points, routes));
        bw.close();
    } // End of main()

    private static String solve(int[][] points, int[][] routes) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;

        Map<Integer, Coordinate> coordinateMap = new HashMap<>();
        int pointsLen = points.length;
        for (int i = 0; i < pointsLen; i++) {
            coordinateMap.put(i + 1, new Coordinate(points[i][0], points[i][1]));
        }

        List<List<Coordinate>> robotPaths = new ArrayList<>();

        for (int[] t : routes) {
            List<Coordinate> paths = new ArrayList<>();
            Coordinate start = coordinateMap.get(t[0]);

            paths.add(start);
            int tLen = t.length;

            for (int i = 1; i < tLen; i++) {
                Coordinate next = coordinateMap.get(t[i]);
                paths.addAll(makePath(start, next));
                start = next;
            }

            robotPaths.add(paths);
            System.out.println(paths);
        }

        int maxTime = 0;
        for (List<Coordinate> paths : robotPaths) {
            maxTime = Math.max(maxTime, paths.size());
        }

        for (int i = 0; i < maxTime; i++) {
            Map<Coordinate, Integer> coordinateCount = new HashMap<>();

            for (List<Coordinate> path : robotPaths) {
                if (i < path.size()) {
                    Coordinate coord = path.get(i);
                    coordinateCount.put(coord, coordinateCount.getOrDefault(coord, 0) + 1);
                }
            }

            for (int count : coordinateCount.values()) {
                if (count > 1) {
                    ans++;
                }
            }
        }


        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static List<Coordinate> makePath(Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        int x = start.x;
        int y = start.y;

        // 경로 만들기
        while (x != end.x) {
            if (x < end.x) x++;
            else x--;
            path.add(new Coordinate(x, y));
        }

        while (y != end.y) {
            if (y < end.y) y++;
            else y--;
            path.add(new Coordinate(x, y));
        }

        return path;
    } // End of makePath()
} // End of Main class
