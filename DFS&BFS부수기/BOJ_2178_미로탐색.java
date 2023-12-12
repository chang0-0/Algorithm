package BOJ_2178;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

    // https://www.acmicpc.net/problem/2178
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] map;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};

    private static class Node {
        int x;
        int y;
        int count;

        private Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node : {x : " + x + ", y : " + y + "}";
        } // End of toString()
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2178\\res.txt"));
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
        boolean[][] isVisited = new boolean[N + 1][M + 1];
        LinkedList<Node> que = new LinkedList<>();
        que.offer(new Node(1, 1, 1));
        isVisited[1][1] = true;

        while (!que.isEmpty()) {
            Node current = que.poll();

            if (current.x == N && current.y == M) {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                isVisited[nextX][nextY] = true;
                que.offer(new Node(nextX, nextY, current.count + 1));
            }
        }

        return 0;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M && !isVisited[nextX][nextY] && map[nextX][nextY] == 1;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = temp.charAt(j - 1) - '0';
            }
        }
    } // End of input()
} // End of Main class
