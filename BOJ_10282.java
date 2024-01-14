package BOJ_10282;

import java.io.*;
import java.util.*;

public class BOJ_10282 {

    // https://www.acmicpc.net/problem/10282
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, D, C, count, maxTime;
    private static List<List<Computer>> adjList;

    private static class Computer implements Comparable<Computer> {
        int num;
        int time;

        private Computer(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return time - o.time;
        }
    } // End of Computer class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_10282\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        dijkstra();

        sb.append(count).append(' ').append(maxTime).append('\n');
        return sb.toString();
    } // End of solve()

    private static void dijkstra() {
        PriorityQueue<Computer> pQue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[C] = 0;
        pQue.offer(new Computer(C, 0));
        count = 0;
        maxTime = 0;

        while (!pQue.isEmpty()) {
            Computer current = pQue.poll();

            if (isVisited[current.num]) continue;
            if (dist[current.num] > current.time) continue;
            isVisited[current.num] = true;
            count++;
            maxTime = Math.max(maxTime, dist[current.num]);

            for (Computer next : adjList.get(current.num)) {
                if (dist[next.num] > dist[current.num] + next.time) {
                    dist[next.num] = dist[current.num] + next.time;
                    pQue.offer(new Computer(next.num, dist[next.num]));
                }
            }
        }

    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            adjList.get(b).add(new Computer(a, s));
        }
    } // End of input()
} // End of Main class
