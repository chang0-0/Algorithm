package BOJ_1240;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1240 {

    // https://www.acmicpc.net/problem/1240
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Edge>> adjList;

    private static class Edge {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1240\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        // 방향 그래프 노드 이동 최단거리 구하기
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(BFS(a, b)).append('\n');
        }

        return sb.toString();
    } // End of solve()

    private static int BFS(int start, int target) {
        ArrayDeque<Edge> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];
        que.offer(new Edge(start, 0));

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (cur.num == target) {
                return cur.dist;
            }

            if (isVisited[cur.num]) continue;
            isVisited[cur.num] = true;

            for (Edge next : adjList.get(cur.num)) {
                que.offer(new Edge(next.num, cur.dist + next.dist));
            }
        }

        return -1;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.get(a).add(new Edge(b, c));
            adjList.get(b).add(new Edge(a, c));
        }

    } // End of input()
} // End of Main class
