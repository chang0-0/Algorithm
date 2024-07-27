package BOJ_16958;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16958 {

    // https://www.acmicpc.net/problem/16958
    // input
    private static BufferedReader br;

    // variables
    private static int N, T, M;
    private static City[] cities;
    private static int[][] times;
    private static final int INF = Integer.MAX_VALUE / 2;

    private static class City {
        int s;
        int x;
        int y;

        private City(int s, int x, int y) {
            this.s = s;
            this.x = x;
            this.y = y;
        }
    } // End of City class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16958\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        // 각 노드별 최단 시간 계산

        floyd();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(times[a][b]).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static void floyd() {

        // 초기 거리 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    times[i][j] = calc(cities[i].x, cities[i].y, cities[j].x, cities[j].y);
                    if (cities[i].s == 1 && cities[j].s == 1) {
                        times[i][j] = Math.min(times[i][j], T);
                    }
                } else {
                    times[i][j] = 0;
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (times[i][j] > times[i][k] + times[k][j]) {
                        times[i][j] = times[i][k] + times[k][j];
                    }
                }
            }
        }
    } // End of floyd()

    private static int calc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    } // End of calc()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        cities = new City[N + 1];
        times = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cities[i] = new City(s, x, y);
            Arrays.fill(times[i], INF);
        }

        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
