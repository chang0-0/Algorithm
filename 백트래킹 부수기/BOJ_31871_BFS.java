package BOJ_31871;

import java.io.*;
import java.util.*;

public class BOJ_31871_BFS {

    // https://www.acmicpc.net/problem/31871
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static List<List<Edge>> adjList;
    private static Map<Integer, Map<Integer, Integer>> edgeMap;

    private static class Edge {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    } // End of Edge class

    private static class State implements Comparable<State> {
        int num;
        Set<Integer> visited;
        int totalDist;

        private State(int num, Set<Integer> visited, int totalDist) {
            this.num = num;
            this.visited = new HashSet<>(visited);
            this.visited.add(num);
            this.totalDist = totalDist;
        }

        @Override
        public int compareTo(State o) {

            if (visited.size() == o.visited.size()) {
                return o.totalDist - totalDist;
            }

            return o.visited.size() - visited.size();
        }
    } // End of State class

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

        sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static int BFS() {
        PriorityQueue<State> que = new PriorityQueue<>();
        que.offer(new State(0, new HashSet<>(), 0));
        int ans = -1;

        while (!que.isEmpty()) {
            State cur = que.poll();

            if (cur.visited.size() == N + 1 && cur.num == 0) {
                ans = Math.max(ans, cur.totalDist);
                continue;
            }

            for (Edge next : adjList.get(cur.num)) {
                if (!cur.visited.contains(next.num) || cur.visited.size() == N + 1 && next.num == 0) {
                    que.offer(new State(next.num, cur.visited, cur.totalDist + next.dist));
                }
            }
        }

        return ans;
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        edgeMap = new HashMap<>();
        for (int i = 0; i <= N + 1; i++) {
            adjList.add(new ArrayList<>());
            edgeMap.put(i, new HashMap<>());
        }

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
