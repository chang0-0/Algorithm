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
    private static ArrayDeque<Integer> visited;
    private static Map<Integer, Map<Integer, Long>> edgeMap;

    private static class Edge {
        int num;
        long dist;

        private Edge(int num, long dist) {
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

        DFS(0, 0);
        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int node, long dist) {
        if (node == 0 && visited.size() == N + 1) {
            ans = Math.max(ans, dist);
            return;
        }

        for (Edge next : adjList.get(node)) {
            if (isVisited[next.num]) continue;

            isVisited[next.num] = true;
            visited.offerLast(next.num);
            DFS(next.num, dist + next.dist);
            isVisited[next.num] = false;
            visited.pollFirst();
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
        visited = new ArrayDeque<>();
        isVisited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            if (u == v) continue;
            Map<Integer, Long> currentMap = edgeMap.get(u);
            if (currentMap.containsKey(v)) {
                currentMap.put(v, Math.max(currentMap.get(v), d));
            } else {
                currentMap.put(v, d);
            }
        }

        for (int i = 0; i <= N; i++) {
            Map<Integer, Long> connections = edgeMap.get(i);

            for (int key : connections.keySet()) {
                long d = connections.get(key);
                adjList.get(i).add(new Edge(key, d));
            }
        }
    } // End of input()
} // End of Main class
