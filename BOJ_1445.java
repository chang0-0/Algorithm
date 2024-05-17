package BOJ_1445;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1445 {

    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] arr;
    private static Coordinate start;
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int trashCount;
        int sideCount;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int trashCount, int sideCount) {
            this.x = x;
            this.y = y;
            this.trashCount = trashCount;
            this.sideCount = sideCount;
        }

        @Override
        public int compareTo(@NotNull Coordinate o) {
            if (trashCount == o.trashCount) {
                return sideCount - o.sideCount;
            }

            return trashCount - o.trashCount;
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1445\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        dijkstra();

        return sb.toString();
    } // End of solve()

    private static void dijkstra() {
        PriorityQueue<Coordinate> pque = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[N][M];
        int[][] dist = new int[N][M];


        int temp = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = dirX[i] + start.x;
            int nextY = dirY[i] + start.y;

            // 주변에 쓰레기가 있으면 +
            if (isAbleCheck(nextX, nextY, isVisited) && arr[nextX][nextY] == 'g') {
                temp++;
            }
        }

        dist[start.x][start.y] = temp;
        pque.offer(new Coordinate(start.x, start.y, 0, temp));

        while (!pque.isEmpty()) {
            Coordinate cur = pque.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + cur.x;
                int nextY = dirY[i] + cur.y;

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                isVisited[nextX][nextY] = true;

                if (arr[nextX][nextY] == 'g') {
                    pque.offer(new Coordinate(nextX, nextY, cur.trashCount + 1, cur.sideCount));
                }

            }
        }

    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M;
    } // End of isAbleCheck()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp.charAt(j);

                if (arr[i][j] == 'S') {
                    start = new Coordinate(i, j);
                }
            }
        }
    } // End of input()
} // End of Main class
