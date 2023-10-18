package BOJ_30024;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_30024_옥수수밭 {

    // https://www.acmicpc.net/problem/30024
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static LinkedList<Coordinate> que;
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int value;

        public Coordinate(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return "x : " + x + " y : " + y + " value : " + value;
        }

        @Override
        public int compareTo(Coordinate o) {
            return value - o.value;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30024\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        while (!que.isEmpty()) {
            System.out.println(que.poll());
        }

        // sb.append(BFS());
        return sb.toString();
    } // End of solve()

    private static String BFS() {
        StringBuilder sb = new StringBuilder();

        while (K-- > 0) {
            Coordinate pollCoor = que.poll();
            sb.append(pollCoor.x + 1).append(' ').append(pollCoor.y + 1).append('\n');

            for (int i = 0; i < 4; i++) {
                int nextX = pollCoor.x + dirX[i];
                int nextY = pollCoor.y + dirY[i];

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                isVisited[nextX][nextY] = true;
                que.offer(new Coordinate(nextX, nextY, map[nextX][nextY]));
            }
        }

        return sb.toString();
    } // End of BFS()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !isVisited[nextX][nextY];
    } // End of isAble()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        que = new LinkedList<>();
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0 || j == 0 || i == N - 1 || j == M - 1) {
                    que.offer(new Coordinate(i, j, map[i][j]));
                    isVisited[i][j] = true;
                }
            }
        }

        K = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
