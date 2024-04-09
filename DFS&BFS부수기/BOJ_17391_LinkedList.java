package BOJ_17391;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17391_LinkedList {

    // https://www.acmicpc.net/problem/17391
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[][] map;

    private static final int INF = Integer.MAX_VALUE;
    private static final int[] dirX = {1, 0}; // 하 우
    private static final int[] dirY = {0, 1}; // 하 우

    private static class Coordinate {
        int x;
        int y;
        int total;

        private Coordinate(int x, int y, int total) {
            this.x = x;
            this.y = y;
            this.total = total;
        }
    } // End of Coordinate


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17391\\res.txt"));
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
        Queue<Coordinate> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N + 1][M + 1];

        que.offer(new Coordinate(1, 1, 0));

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Coordinate current = que.poll();
                if (current.x == N && current.y == M) {
                    return current.total;
                }

                int count = map[current.x][current.y];
                for (int j = 0; j < 2; j++) {
                    for (int k = 1; k <= count; k++) {
                        int nextX = current.x + k * dirX[j];
                        int nextY = current.y + k * dirY[j];

                        if (!isAbleCheck(nextX, nextY)) break;
                        if (isVisited[nextX][nextY]) continue;

                        isVisited[nextX][nextY] = true;
                        que.offer(new Coordinate(nextX, nextY, current.total + 1));
                    }
                }
            }
        }

        return -1;
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY) {
        return nextX >= 1 && nextX <= N && nextY >= 1 && nextY <= M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
