package BOJ_22116;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_22116 {

    // https://www.acmicpc.net/problem/22116
    // input
    private static BufferedReader br;

    // variables
    private static final int INF = Integer.MAX_VALUE;
    private static int N;
    private static int[][] map;
    private static int[] dirX = {0, 0, -1, 1};
    private static int[] dirY = {-1, 1, 0, 0};

    private static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;
        int slope;

        private Coordinate(int x, int y, int slope) {
            this.x = x;
            this.y = y;
            this.slope = slope;
        }

        @Override
        public int compareTo(Coordinate o) {
            return slope - o.slope;
        }

        @Override
        public String toString() {
            return "Coordinate {x : " + x + ", y : " + y + "} \n";
        }
    } // End of Coordinate class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_22116\\res.txt"));
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

    private static long dijkstra() {
        PriorityQueue<Coordinate> pQue = new PriorityQueue<>();
        int[][] maxSlopes = new int[N][N];
        boolean[][] isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(maxSlopes[i], INF);
        }

        maxSlopes[0][0] = 0;
        pQue.offer(new Coordinate(0, 0, 0));

        while (!pQue.isEmpty()) {
            Coordinate current = pQue.poll();

            if (maxSlopes[current.x][current.y] < current.slope) continue;
            if (isVisited[current.x][current.y]) continue;
            isVisited[current.x][current.y] = true;

            for (int i = 0; i < 4; i++) {
                int nextX = dirX[i] + current.x;
                int nextY = dirY[i] + current.y;

                if (!isAbleCheck(nextX, nextY, isVisited)) continue;

                int nextSlope = Math.max(current.slope, Math.abs(map[current.x][current.y] - map[nextX][nextY]));

                if (maxSlopes[nextX][nextY] > nextSlope) {
                    maxSlopes[nextX][nextY] = nextSlope;
                    pQue.offer(new Coordinate(nextX, nextY, nextSlope));
                }
            }
        }

        return maxSlopes[N - 1][N - 1];
    } // End of dijkstra()

    private static boolean isAbleCheck(int nextX, int nextY, boolean[][] isVisited) {
        return nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !isVisited[nextX][nextY];
    } // End of isAbleCheck()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
