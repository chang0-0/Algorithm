package BOJ_1261;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

    // https://www.acmicpc.net/problem/1261
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] map;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int crashCount;

        private Node(int x, int y, int crashCount) {
            this.x = x;
            this.y = y;
            this.crashCount = crashCount;
        }

        @Override
        public int compareTo(Node o) {
            return crashCount - o.crashCount;
        } // End of compareTo()

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", crashCount=" + crashCount +
                    '}';
        }
    } // End of Node

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1261\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(dijkstra());

        return sb.toString();
    } // End of solve()

    private static int dijkstra() {
        PriorityQueue<Node> pQue = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];
        int[][] crashs = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(crashs[i], Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE / 40;

        pQue.offer(new Node(0, 0, 0));
        isVisited[0][0] = true;
        crashs[0][0] = 0;

        while (!pQue.isEmpty()) {
            Node current = pQue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                ans = Math.min(ans, current.crashCount);
            }

            if (map[current.x][current.y] > crashs[current.x][current.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dirX[i];
                int nextY = current.y + dirY[i];

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;
                if (crashs[nextX][nextY] > crashs[current.x][current.y] + map[nextX][nextY]) {
                    crashs[nextX][nextY] = crashs[current.x][current.y] + map[nextX][nextY];
                    pQue.offer(new Node(nextX, nextY, crashs[nextX][nextY]));
                }
            }
        }

        return ans;
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
    } // End of input()
} // End of Main class
