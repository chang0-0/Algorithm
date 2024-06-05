package BOJ_2358;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2358 {

    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Coordinate[] coors;
    private static Map<Coordinate, Integer> map;

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Coordinate coor = (Coordinate) obj;
            return x == coor.x && y == coor.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (x == o.x) return y - o.y;

            return x - o.x;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2358\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            Coordinate cur = coors[i];

            // X축과 Y축이 평행이 되는지 보기
            boolean flag = false;
            boolean flag2 = false;

            for (int j = i + 1; j < N; j++) {
                Coordinate temp = coors[j];
                if (cur.x == temp.x && cur.y != temp.y) {
                    flag = true;
                } else if (cur.x != temp.x && cur.y == temp.y) {
                    flag2 = true;
                }
            }

            if (flag) ans++;
            if (flag2) ans++;
        }


        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        coors = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coors[i] = new Coordinate(x, y);
            map.put(new Coordinate(x, y), map.getOrDefault(new Coordinate(x, y), 0) + 1);
        }
    } // End of input()
} // End of Main class
