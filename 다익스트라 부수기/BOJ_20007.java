package BOJ_20007;

import java.io.*;
import java.util.*;

public class BOJ_20007 {

    // https://www.acmicpc.net/problem/20007
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, M, X, Y;
    private static List<List<Edge>> adjList;

    private static class Edge implements Comparable<Edge> {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_20007\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        /*
            떡은 한번에 하나씩만 들고 갈 수 있다.
            잠은 꼭 본인 집에서 자야하므로 왕복할 수 없는 거리는 다음날 가기로 한다.
            왕복할 수 있는 거리라면 집을 들러서 떡을 가지고 다시 갈 수 있다.
            모두 방문할 수 없으면 -1을 출력
         */

        int[] temp = dijkstra(Y);
        PriorityQueue<Edge> pque = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if (i == Y) continue;
            if (temp[i] == INF) {
                sb.append(-1);
                return sb.toString();
            }
            pque.offer(new Edge(i, temp[i]));
        }

        int sum = 0;
        int ans = 1;
        boolean flag = true;

        while (!pque.isEmpty()) {
            Edge current = pque.peek();

            sum += current.dist * 2;

            if (X < sum) {
                // 못 감
                sum = current.dist * 2;
                if (sum <= X) {
                    pque.poll();
                    ans++;
                } else {
                    flag = false;
                    break;
                }
            } else {
                // 가능
                pque.poll();
            }
        }

        if (!flag) {
            sb.append(-1);
        } else {
            sb.append(ans);
        }

        return sb.toString();
    } // End of solve()

    private static int[] dijkstra(int start) {
        PriorityQueue<Edge> pque = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N];
        int[] dist = new int[N];
        Arrays.fill(dist, INF);

        pque.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pque.isEmpty()) {
            Edge current = pque.poll();

            if (dist[current.num] < current.dist) continue;
            if (isVisited[current.num]) continue;
            isVisited[current.num] = true;

            for (Edge next : adjList.get(current.num)) {
                if (dist[next.num] > dist[current.num] + next.dist) {
                    dist[next.num] = dist[current.num] + next.dist;
                    pque.offer(new Edge(next.num, dist[next.num]));
                }
            }
        }

        return dist;
    } // End of dijkstra()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, c));
            adjList.get(b).add(new Edge(a, c));
        }
    } // End of input()
} // End of Main class
