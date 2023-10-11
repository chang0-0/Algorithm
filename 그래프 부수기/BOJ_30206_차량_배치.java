package BOJ_30206;

import java.io.*;
import java.util.*;

public class BOJ_30206_차량_배치 {

    // https://www.acmicpc.net/problem/30206
    // input
    private static BufferedReader br;

    // variables
    private static final int MOD = 1_000_000_007;
    private static int N, M;
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30206\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static long BFS() {
        LinkedList<Integer> que = new LinkedList<>();
        que.offer(1);

        int[] dist = new int[N + 1];
        int[] counts = new int[N + 1];

        Arrays.fill(dist, -1);
        dist[1] = 0;
        counts[1] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int next : adjList.get(now)) {
                if (dist[next] != -1) continue;

                dist[next] = dist[now] + 1;
                counts[dist[next]]++;
                que.offer(next);
            }
        }

        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans = (ans * (counts[i] + 1)) % MOD;
        }

        return --ans;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    } // End of input()
} // End of Main class
