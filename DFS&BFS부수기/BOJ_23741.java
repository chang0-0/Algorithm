package BOJ_23741;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_23741 {

    // https://www.acmicpc.net/problem/23741
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, X, Y;
    private static List<List<Integer>> adjList;

    private static class Edge {
        int num;
        int dist;

        private Edge(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    } // End of Edge class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_23741\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        boolean[] able = BFS();
        for (int i = 1; i <= N; i++) {
            if (able[i]) {
                sb.append(i).append(' ');
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        return sb.toString();
    } // End of solve()

    private static boolean[] BFS() {
        ArrayDeque<Edge> que = new ArrayDeque<>();
        boolean[] able = new boolean[N + 1];
        boolean[] isVisited = new boolean[N + 1];

        // 앞으로 가고 뒤로 가고를 선택할 수 있다.
        // X에서 출발해서 앞으로 가는 것과 뒤로가는 것을 선택해서 도착하는 곳이 후보가된다.

        que.offer(new Edge(X, 0));

        while (!que.isEmpty()) {
            Edge current = que.poll();

            if (current.dist == Y) {
                able[current.num] = true;
                continue;
            }

            for (int next : adjList.get(current.num)) {
                int nextDist = current.dist + 1;
                if (nextDist > Y) continue;

                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.offer(new Edge(next, nextDist));
                }

                if (!able[next] && nextDist % 2 == 0) {
                    que.offer(new Edge(next, nextDist));
                    isVisited[next] = true;
                    able[next] = true;
                    continue;
                }

                if (able[next] && nextDist % 2 == 1) {
                    que.offer(new Edge(next, nextDist));
                    isVisited[next] = true;
                }
            }
        }

        return able;
    } // End of BFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
    } // End of input()
} // End of Main class
