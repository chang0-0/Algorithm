package BOJ_21278;

import java.io.*;
import java.util.*;

public class BOJ_21278 {

    // https://www.acmicpc.net/problem/21278
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, minDist, num1, num2;
    private static List<List<Edge>> adjList;
    private static final int INF = Integer.MAX_VALUE;

    private static class Edge implements Comparable<Edge> {
        int num;
        int time;

        private Edge(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return time - o.time;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_21278\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    /*
        문제 분석
        양방향 그래프,
        멀티 소스 다익스트라

        모든 건물에서 가장 가까운 치킨집까지 왕복하는 최단 시간의 총합을 최소화할 수 있는 건물 2개를 골라서 오픈한다.
        N개의 노드 중에서 2개의 노드를 선택한다.
        가능한게 여러개라면, 건물 번호 중 작은게 더 작을수록, 작은 번호가 같아면 큰 번호가 더 작을수록 좋은 건물 조합이다.
     */

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                BFS(i, j);
            }
        }

        sb.append(num1).append(' ').append(num2).append(' ').append(minDist);
        return sb.toString();
    } // End of solve()

    private static void BFS(int start1, int start2) {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dists = new int[N + 1];
        Arrays.fill(dists, INF);

        que.offer(new Edge(start1, 0));
        que.offer(new Edge(start2, 0));
        dists[start1] = 0;
        dists[start2] = 0;

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (isVisited[cur.num]) continue;
            if (cur.time > dists[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                if (dists[next.num] > dists[cur.num] + next.time) {
                    dists[next.num] = dists[cur.num] + next.time;
                    que.offer(new Edge(next.num, dists[next.num]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dists[i];
            if ((sum * 2) >= minDist) {
                return;
            }
        }

        if (minDist > sum * 2) {
            minDist = sum * 2;
            num1 = start1;
            num2 = start2;
        }
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minDist = INF;

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Edge(v, 1));
            adjList.get(v).add(new Edge(u, 1));
        }
    } // End of input()
} // End of Main class
