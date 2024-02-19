package BOJ_17471;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17471 {

    // https://www.acmicpc.net/problem/17471
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N, ans;
    private static boolean[] isVisited;
    private static LinkedList<Integer> combList;
    private static int[] pops;
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17471\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            // 1번 부터 인접한 구역을 하나씩 선택하면서,
            int size = adjList.get(i).size();
            isVisited = new boolean[size];
            combList = new LinkedList<>();
            combList.offerFirst(i);
            DFS(i, size, 0, 0);
        }

        if (ans == INF) {
            sb.append(-1);
        } else {
            sb.append(ans);
        }

        return sb.toString();
    } // End of solve()

    private static void DFS(int node, int n, int depth, int idx) {
        if (depth <= n) {
            int ret = BFS(combList);
            if (ret < ans) {
                ans = ret;
            }

            if (depth == n) {
                return;
            }
        }

        for (int i = idx; i < n; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            combList.offerFirst(adjList.get(node).get(i));
            DFS(node, n, depth + 1, i);
            combList.pollFirst();
            isVisited[i] = false;
        }
    } // End of DFS()

    private static int BFS(LinkedList<Integer> combList) {
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int sum = 0;

        int start = 0;
        for (int i = 1; i <= N; i++) {
            if (combList.contains(i)) continue;
            start = i;
        }

        if (combList.size() == N) return INF;

        for (int num : combList) {
            visited[num] = true;
            sum += pops[num];
        }

        que.offer(start);
        visited[start] = true;
        int sum2 = pops[start];

        while (!que.isEmpty()) {
            int current = que.poll();

            for (int next : adjList.get(current)) {
                if (visited[next] || !adjList.get(current).contains(next)) continue; // Only add adjacent districts
                visited[next] = true;
                que.offer(next);
                sum2 += pops[next];
            }
        }

        // All districts must be connected
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return INF;
        }

        return Math.abs(sum - sum2);
    }


    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pops = new int[N + 1];

        ans = INF;
        combList = new LinkedList<>();
        adjList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= N; i++) {
            if (i >= 1) {
                pops[i] = Integer.parseInt(st.nextToken());
            }
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int limit = Integer.parseInt(st.nextToken());

            for (int j = 0; j < limit; j++) {
                int num = Integer.parseInt(st.nextToken());
                adjList.get(i).add(num);
            }
        }
    } // End of input()
} // End of Main class
