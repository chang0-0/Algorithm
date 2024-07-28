package BOJ_16958;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16958_2 {

    // https://www.acmicpc.net/problem/16958
    // input
    private static BufferedReader br;

    // variables
    private static int N, T, M;
    private static City[] cities;
    private static int[] times;
    private static List<Integer> specialList;
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

        // 각 도시에서 가장 가까운 특별한 도시까지의 거리 구하기
        for (int i = 1; i <= N; i++) {
            if (cities[i].s == 1) continue; // 이미 특별한 도시일 경우 0으로 만들었으므로 continue
            for (int s : specialList) {
                // i -> s 까지 텔레포트가 가능한 경우 포함, 최단 거리 갱신
                int dist = calc(cities[i].x, cities[i].y, cities[s].x, cities[s].y);
                times[i] = Math.min(times[i], dist);
            }
        }

        System.out.println(Arrays.toString(times));

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int dist = calc(cities[a].x, cities[a].y, cities[b].x, cities[b].y);

            // a에서 가장 가까운 특별한 도시까지의 이동 시간 + b에서 가장 가까운 특별한 도시까지의 이동 시간 + 특별한 도시간의 이동시간(T)
            int total = times[a] + times[b] + T;


            sb.append(Math.min(dist, total)).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static int calc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    } // End of calc()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        cities = new City[N + 1];
        times = new int[N + 1];
        specialList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cities[i] = new City(s, x, y);
            times[i] = INF;

            if (s == 1) {
                times[i] = 0;
                specialList.add(i);
            }
        }

        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
