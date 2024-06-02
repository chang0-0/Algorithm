package BOJ_31871;

import java.io.*;
import java.util.*;

public class BOJ_31871 {

    // https://www.acmicpc.net/problem/31871
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static long ans;
    private static List<List<Edge>> adjList;
    private static boolean[] isVisited;
    private static Map<Integer, Map<Integer, Integer>> edgeMap;

    private static class Edge {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_31871\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 0, 0);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int node, int dist, int count) {
        if (node == 0 && count == N + 1) {
            ans = Math.max(ans, dist);
            return;
        }

        for (Edge next : adjList.get(node)) {
            if (isVisited[next.num]) continue;

            isVisited[next.num] = true;
            DFS(next.num, dist + next.dist, count + 1);
            isVisited[next.num] = false;
        }
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ans = -1;

        adjList = new ArrayList<>();
        edgeMap = new HashMap<>();
        for (int i = 0; i <= N + 1; i++) {
            adjList.add(new ArrayList<>());
            edgeMap.put(i, new HashMap<>());
        }
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (u == v) continue; // 자신한테로 오는 간선은 제거

            Map<Integer, Integer> curMap = edgeMap.get(u);
            if (curMap.containsKey(v)) {
                curMap.put(v, Math.max(curMap.get(v), d));
            } else {
                curMap.put(v, d);
            }
        }

        for (int i = 0; i <= N; i++) {
            Map<Integer, Integer> con = edgeMap.get(i);

            for (int key : con.keySet()) {
                int d = con.get(key);
                adjList.get(i).add(new Edge(key, d));
            }
        }
    } // End of input()
} // End of Main class
